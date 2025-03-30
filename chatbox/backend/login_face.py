from flask import Blueprint, request, jsonify, Flask
from flask_cors import CORS
import face_recognition
import os
import uuid
import cv2
import numpy as np
import traceback

from database import DatabaseConnection

app = Flask(__name__)
CORS(app)

FACES_DIR = "app/storage/faces"
os.makedirs(FACES_DIR, exist_ok=True)

def save_image_and_encoding(image_np, idUsuario):
    
    if image_np is None or image_np.size == 0:
        return None, "Invalid image data"
    
    filename = f"{idUsuario}_{uuid.uuid4().hex[:8]}.jpg"
    path = os.path.join(FACES_DIR, filename)
    cv2.imwrite(path, image_np)
    
    encoding = face_recognition.face_encodings(image_np)
    if not encoding:
        return None, "No face found"
    
    db = DatabaseConnection()
    conn = db.get_connection()
    cursor = conn.cursor()
    cursor.execute("INSERT INTO loginface (loginface_image, idUsuario) VALUES (%s, %s)",
                   (encoding[0].tobytes(), idUsuario))
    
    conn.commit()
    cursor.close()
    
    return path, None


@app.route("/register-face", methods=["POST"])
def register():
    try:
        print("Entré")
        # Validar username
        idUsuario = request.form.get("idUsuario")
        if not idUsuario:
            return jsonify({"error": "usuario is required"}), 400
        
        # Verificar si el archivo está presente
        if "image" not in request.files:
            return jsonify({"error": "No image uploaded in form-data (key: image)"}), 400
        
        file = request.files["image"]
        if file.filename == "":
            return jsonify({"error": "Uploaded file has no filename"}), 400
        
        # Leer imagen como array numpy
        image_data = file.read()
        if not image_data:
            return jsonify({"error": "Empty image file"}), 400

        image_np = np.frombuffer(image_data, np.uint8)
        image_np = cv2.imdecode(image_np, cv2.IMREAD_COLOR)

        if image_np is None:
            return jsonify({"error": "Invalid image data. Could not decode image"}), 400

        # Guardar imagen y encoding
        path, error = save_image_and_encoding(image_np, idUsuario)
        if error:
            return jsonify({"error": error}), 400

        return jsonify({"message": "User registered", "image_path": path})

    except Exception as e:
        traceback.print_exc()  # Imprime el error en consola
        return jsonify({"error": "Server error", "details": str(e)}), 500


# @api.route("/register", methods=["POST"])
# def register():
#     username = request.form.get("username")
#     if "image" not in request.files:
#         return jsonify({"error": "No image uploaded"}), 400
    
#     file = request.files["image"]
#     image_np = np.frombuffer(file.read(), np.uint8)
#     image_np = cv2.imdecode(image_np, cv2.IMREAD_COLOR)
    
#     path, error = save_image_and_encoding(image_np, username)
#     if error:
#         return jsonify({"error": error}), 400
    
#     return jsonify({"message": "User registered", "image_path": path})

@app.route("/login-face", methods=["POST"])
def login():
    if "image" not in request.files:
        return jsonify({"error": "No image uploaded"}), 400
    
    file = request.files["image"]
    image_np = np.frombuffer(file.read(), np.uint8)
    image_np = cv2.imdecode(image_np, cv2.IMREAD_COLOR)
    
    unknown_encoding = face_recognition.face_encodings(image_np)
    if not unknown_encoding:
        return jsonify({"error": "No face found"}), 400
    
    unknown_encoding = unknown_encoding[0]
    
    db = DatabaseConnection()
    conn = db.get_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT loginface_image, idUsuario FROM loginface")
    users = cursor.fetchall()
    
    for loginface_image, idUsuario  in users:
        known_encoding = np.frombuffer(loginface_image, dtype=np.float64)
        distance = face_recognition.face_distance([known_encoding], unknown_encoding)[0]
        print(f"[DEBUG] Distance with {idUsuario}: {distance}")  # para debug

        match = face_recognition.compare_faces([known_encoding], unknown_encoding, tolerance=0.45)
        if match[0]:
            return jsonify({"message": "Login successful", "user": idUsuario})

    return jsonify({"error": "No match found"}), 401
  
if __name__ == "__main__":
    print("🚀 FaceID iniciado en http://localhost:5005")
    app.run(host='0.0.0.0', port=5005, debug=False)
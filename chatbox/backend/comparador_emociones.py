from flask import Flask, request, jsonify
from transformers import AutoTokenizer, AutoModelForSequenceClassification
import torch
from flask_cors import CORS
from producto_dao import LibrosDAO

app = Flask(__name__)
CORS(app)

# Cargar el modelo multilingüe
modelo = "nlptown/bert-base-multilingual-uncased-sentiment"
tokenizer = AutoTokenizer.from_pretrained(modelo)
model = AutoModelForSequenceClassification.from_pretrained(modelo)

# Mapeo de estrellas a categorías interpretables
sentiment_mapping = {
    0: "⭐ Muy Negativo",
    1: "⭐⭐ Negativo",
    2: "⭐⭐⭐ Neutral",
    3: "⭐⭐⭐⭐ Positivo",
    4: "⭐⭐⭐⭐⭐ Muy Positivo"
}

# Función para detectar sentimiento
def detectar_emocion(texto):
    inputs = tokenizer(texto, return_tensors="pt", truncation=True, padding=True)

    with torch.no_grad():
        outputs = model(**inputs)
        predicted_class = torch.argmax(outputs.logits).item()

    emocion = sentiment_mapping[predicted_class]

    print(f"\n Comentario: {texto}")
    print(f"🎭 Satisfacción detectada: {emocion}")
    return emocion
    
# Ruta para clasificar comentarios
@app.route("/emocion", methods=["POST"])
def clasificar_emocion():
    datos = request.get_json()
    print(datos)
    comentario = datos.get("comentario", "")
    
    if not comentario:
        return jsonify({"error": "Falta el comentario."}), 400
      
    answer = detectar_emocion(comentario)
    #guardar_comentario(answer)
    return jsonify({"status":200, "data": comentario, "message": answer})
  
# Ruta para guardar el comentario en la base de datos
# @app.route("/guardar", methods=["POST"])
def guardar_comentario(puntuacionComentario):
    datos = request.get_json()
    print(datos)
    #Campos de la tabla calificaciones (idCalificacion, idLibro, idUsuario, fechaCalificacion, comentario, puntuacion)
    idLibro = datos.get("idLibro", {}).get("idLibros", "")
    idUsuario = datos.get("idUsuario", {}).get("idUsuario", "")
    fechaCalificacion = datos.get("fechaCalificacion", "")
    comentario = datos.get("comentario", "")
    puntuacion = puntuacionComentario
    
    LibrosDAO.calificar_libro(idLibro, idUsuario, fechaCalificacion, comentario, puntuacion)
    return jsonify({"status":200, "message": "Comentario guardado correctamente."}), 201
  
  
    
    

# Nuevos ejemplos de comentarios de productos
# ejemplos = [
    # "El producto llegó roto y no funciona, muy decepcionado.",
    # "No es lo que esperaba, la calidad es baja.",
    # "Cumple con lo prometido, aunque podría mejorar.",
    # "Buen producto, lo volvería a comprar.",
    # "Excelente calidad y entrega rápida, totalmente satisfecho.",
    # "No me gustó, venía incompleto y el soporte no respondió.",
    # "Es útil, pero el precio me parece un poco alto.",
    # "Me encantó, superó mis expectativas por completo."
# ]

# Evaluar los comentarios
# for texto in ejemplos:
    # detectar_emocion(texto)
    
# Entrada personalizada desde el usuario
# print("\n🔍 Clasificador de satisfacción del cliente")
# comentario_usuario = input("Escribe un comentario sobre un producto o servicio: ")
# 
#  # Clasificar el comentario ingresado
# detectar_emocion(comentario_usuario)

if __name__ == "__main__":
    print("🚀 Chatbot Service iniciado en http://localhost:5003")
    app.run(host='0.0.0.0', port=5003, debug=True)
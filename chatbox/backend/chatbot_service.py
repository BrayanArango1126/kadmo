from flask import Flask, request, jsonify
from transformers import pipeline
from producto_dao import LibrosDAO

app = Flask(__name__)

# Cargar modelo de QA
#print("🚀 Iniciando carga de modelos...")

#qa_pipeline = pipeline("question-answering",model="mrm8488/bert-spanish-cased-finetuned-squad-es")

#qa_pipeline = pipeline("question-answering", model="mrm8488/electra-small-spanish-squad2")


qa_pipeline = pipeline("question-answering", model="distilbert-base-cased-distilled-squad",max_answer_length=50)


print("✅ Modelo de QA cargado.")

def obtener_contexto(idLibro):
    """Obtiene la descripción del libro desde la base de datos."""
    libro = LibrosDAO.obtener_libro_por_id(idLibro)
    return libro['descripcion'] if libro else "Descripción no encontrada."

@app.route("/chat", methods=["POST"])
def chat():
    """Procesa la pregunta del usuario con el contexto del producto."""
    datos = request.get_json()
    pregunta = datos.get("pregunta", "")
    idLibro = datos.get("idLibro", None)
    print(datos)
    
    if not idLibro:
        return jsonify({"error": "Falta el ID del libro."}), 400
    
    contexto = obtener_contexto(idLibro)
    
    if contexto == "Descripción no encontrada.":
        return jsonify({"error": "No se encontró información sobre este libro."}), 404
    
    respuesta = qa_pipeline({"question": pregunta, "context": contexto})
    return jsonify({"status":200, "message": respuesta["answer"]})

if __name__ == "__main__":
    print("🚀 Chatbot Service iniciado en http://localhost:5001")
    app.run(host='0.0.0.0', port=5001, debug=True)

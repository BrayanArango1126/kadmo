from flask import Flask, request, jsonify
from producto_dao import LibrosDAO
import base64

app = Flask(__name__)

@app.route("/libros", methods=["GET"])
def obtener_libros():
    """Devuelve la lista de libros desde la base de datos."""
    try:
        libros = LibrosDAO.obtener_libros()
        if libros:
            # # Convertir imágenes BLOB a Base64
            # for libro in libros:
                # if isinstance(libro["image"], bytes):
                    # libro["image"] = base64.b64encode(libro["image"]).decode("utf-8")
            return jsonify({"libros": libros}), 200
        return jsonify({"mensaje": "No hay libros disponibles"}), 404
    except Exception as e:
        print(f"⚠️ Error en obtener_libros: {e}")
        return jsonify({"error": "Error interno del servidor"}), 500

@app.route("/libros/<int:idLibro>", methods=["GET"])
def obtener_libro(idLibro):
    """Obtiene un libro específico por ID."""
    try:
        libro = LibrosDAO.obtener_libro_por_id(idLibro)
        if libro:
            # if isinstance(libro["image"], bytes):
            #     libro["image"] = base64.b64encode(libro["image"]).decode("utf-8")
            return jsonify({"libro": libro}), 200
        return jsonify({"mensaje": "Libro no encontrado"}), 404
    except Exception as e:
        print(f"⚠️ Error en obtener_libro: {e}")
        return jsonify({"error": "Error interno del servidor"}), 500

@app.route("/productos", methods=["POST"])
def agregar_producto():
    """Agrega un nuevo producto."""
    try:
        datos = request.get_json()
        
        nombre = datos.get("name")  # Corregido
        precio = datos.get("price")  # Corregido
        descripcion = datos.get("description")  # Se agregó para consistencia
        imagen_base64 = datos.get("image")
        
        print("🔍 Datos recibidos en el backend:", nombre, precio, descripcion)  # Depuración
        
        
        if not nombre or not isinstance(nombre, str):
            return jsonify({"error": "El campo 'name' es obligatorio y debe ser una cadena"}), 400
        if not precio or not isinstance(precio, (int, float)):
            return jsonify({"error": "El campo 'price' es obligatorio y debe ser un número"}), 400
        if not descripcion or not isinstance(descripcion, str):
            return jsonify({"error": "El campo 'description' es obligatorio y debe ser una cadena"}), 400
        if not imagen_base64 or not isinstance(imagen_base64, str):
            return jsonify({"error": "El campo 'image' es obligatorio y debe ser una cadena Base64"}), 400

        imagen_bytes = base64.b64decode(imagen_base64)  # Convertir Base64 a BLOB
        LibrosDAO.agregar_producto(nombre, precio, descripcion, imagen_bytes)
        return jsonify({"mensaje": "Producto agregado exitosamente"}), 201
    except Exception as e:
        print(f"⚠️ Error en agregar_producto: {e}")
        return jsonify({"error": "Error interno del servidor"}), 500

if __name__ == "__main__":
    print("🚀 Productos Service iniciado en http://localhost:5002")
    app.run(host='0.0.0.0', port=5002, debug=True)
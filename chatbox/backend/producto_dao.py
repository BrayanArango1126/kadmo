import mysql.connector
from database import DatabaseConnection

class LibrosDAO:
    """Clase de acceso a datos para libros."""

    @staticmethod
    def obtener_libros():
        """Consulta todos los libros."""
        try:
            conexion = DatabaseConnection().get_connection()
            cursor = conexion.cursor(dictionary=True)
            cursor.execute("SELECT * FROM libros;")
            libros = cursor.fetchall()
            return libros
        except Exception as e:
            print(f"❌ Error al obtener libros: {e}")
            return []

    @staticmethod
    def obtener_libro_por_id(idLibro):
        """Obtiene un libro específico por su ID."""
        try:
            conexion = DatabaseConnection().get_connection()
            cursor = conexion.cursor(dictionary=True)
            cursor.execute("SELECT * FROM libros WHERE idLibros = %s;", (idLibro,))
            libro = cursor.fetchone()
            return libro
        except Exception as e:
            print(f"❌ Error al obtener libro por ID: {e}")
            return None

    @staticmethod
    def agregar_producto(nombre, precio, descripcion, imagen):
        """Inserta un nuevo producto en la base de datos."""
        try:
            conexion = DatabaseConnection().get_connection()
            cursor = conexion.cursor()
            consulta = """
                INSERT INTO products (name, price, description, image)
                VALUES (%s, %s, %s, %s);
            """
            cursor.execute(consulta, (nombre, precio, descripcion, imagen))
            conexion.commit()
            print("✅ Producto agregado correctamente.")
        except Exception as e:
            print(f"❌ Error al agregar producto: {e}")

#Usa el patrón Singleton para evitar múltiples conexiones a MySQL.
import mysql.connector

# class DatabaseConnection:
#     """Clase Singleton para manejar la conexión a MySQL."""
#     _instance = None

#     def __new__(cls):
#         if cls._instance is None:
#             cls._instance = super(DatabaseConnection, cls).__new__(cls)
#             cls._instance.connection = mysql.connector.connect(
#                 host="localhost",
#                 port=3306,
#                 user="root",
#                 password="",
#                 database="kadmodb"
#             )
#         return cls._instance

#     def get_connection(self):
#         """Devuelve la conexión a la base de datos."""
#         return self.connection


class DatabaseConnection:
    """Clase Singleton para manejar la conexión a MySQL."""
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(DatabaseConnection, cls).__new__(cls)
            cls._instance._connect_to_database()  # Intentar conectar
        return cls._instance

    def _connect_to_database(self):
        """Intentar conectar a la base de datos y manejar errores."""
        try:
            self.connection = mysql.connector.connect(
                host="localhost",
                port=3306,
                user="root",
                password="",
                database="kadmodb"
            )
            print("✅ Conexión a MySQL establecida.")
        except mysql.connector.Error as err:
            print(f"❌ Error al conectar a MySQL: {err}")
            self.connection = None  # Evita errores si la conexión falla

    def get_connection(self):
        """Devuelve la conexión activa o intenta reconectar si se perdió."""
        if not hasattr(self, 'connection') or self.connection is None or not self.connection.is_connected():
            print("🔄 Intentando reconectar a MySQL...")
            self._connect_to_database()

        if self.connection is None:
            raise Exception("❌ No se pudo conectar a la base de datos.")

        return self.connection

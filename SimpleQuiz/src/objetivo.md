******************** Enums (Enumeraciones): ******************** 
Categoria: Define las categorías disponibles (TECNOLOGIA, HISTORIA, CIENCIA) para clasificar preguntas.
Opcion: Representa las opciones de respuestas (A, B, C, D) para las preguntas.

******************** Clases principales: ********************
Main: Es el punto de entrada del programa. Maneja la interacción con el usuario (pedir nombre, seleccionar categoría, y mostrar preguntas). Coordina el flujo del juego usando un Scanner.
BancoPregunta: Administra las preguntas, organizándolas en un Map basado en categorías. 
 - Permite crear preguntas directamente en el código o cargarlas desde un archivo. -
Jugador: Representa a los jugadores del juego con su nombre, un identificador único y los puntos acumulados.

******************** Clases secundarias: ********************
Pregunta: Representa una pregunta individual. Contiene la pregunta, la respuesta correcta, y las posibles respuestas (almacenadas en un Map).

******************** Conceptos clave utilizados: ********************
Colecciones: Uso de Map y List para gestionar preguntas y categorías.
Entrada/Salida (I/O): Lectura de preguntas desde archivos de texto con BufferedReader.
Control de flujo: Uso de estructuras como switch, bucles, y condiciones para manejar la lógica del juego.

******************** En resumen ********************
El programa combina conceptos de estructura de datos 
diseño orientado a objetos y manejo de archivos para crear una experiencia interactiva de preguntas y respuestas. 



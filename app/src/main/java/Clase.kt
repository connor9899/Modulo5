class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,
    val referencia: Usuario? = null
) {
    fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        println("Trabajo: ${trabajo ?: "No especificado"}")
        println("Referencia: ${referencia?.nombre ?: "Sin referencia"}")
        println()
    }
}

fun main() {
    val usuario1 = Usuario("Ana", 28, "Ingeniera")
    val usuario2 = Usuario("Carlos", 35, "Profesor", usuario1)
    val usuario3 = Usuario("María", 22)

    println("Datos de Usuario 1:")
    usuario1.mostrarDatos()

    println("Datos de Usuario 2:")
    usuario2.mostrarDatos()

    println("Datos de Usuario 3:")
    usuario3.mostrarDatos()
}
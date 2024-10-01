package cl.boodcamp.m5_ejercicioindividual2


fun calcularPrecioEntrada(edad: Int, diaSemana: String): String {
    when {
        edad < 0 || edad > 100 -> return "Error: La edad ingresada no es válida."
        edad < 4 -> return "Entrada gratuita para menores de 4 años."
        edad <= 15 -> return "Precio de la entrada: 15.000 CLP"
        edad <= 60 -> {
            val precioBase = 30000
            val descuento = if (diaSemana.toLowerCase() in listOf("lunes", "martes")) 5000 else 0
            return "Precio de la entrada: ${precioBase - descuento} CLP"
        }
        else -> return "Precio de la entrada: 20.000 CLP"
    }
}

fun main() {
    println("Bienvenido al sistema de cálculo de precios del parque de diversiones")

    print("Por favor, ingrese la edad del visitante: ")
    val edad = readLine()?.toIntOrNull() ?: -1

    print("Por favor, ingrese el día de la semana (ej. lunes, martes, etc.): ")
    val diaSemana = readLine() ?: ""

    val resultado = calcularPrecioEntrada(edad, diaSemana)
    println(resultado)
}
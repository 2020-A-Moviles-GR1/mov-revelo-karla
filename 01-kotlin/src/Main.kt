import java.util.*

fun main(args:Array<String>) {
    print("Hola")
    val nombreProfesor: String = "Vicente Adrian"
    val sueldo: Double = 12.20
    val apellidoProfesor: Char = 'a'
    val fechaNacimiento = Date() //new Date()

    when (sueldo) {
        12.20 -> println("Sueldo normal")
        -12.20 -> println("Sueldo negativo")
        else -> println("No se reconoce el sueldo")
    }

    val esSueldoMayorAlEstablecido = if (sueldo == 12.20) true else false
    // EXPRESION ? X:Y
    // calcularSueldo(1000.00,14.00)
    calcularSueldo(1000.00, 14.00, null)
    calcularSueldo (
            tasa = 16.00,
            sueldo = 800.00,
            calculoEspecial = null
    ) //Parámetros nombrados
    calcularSueldo(700.00) //Se puede enviar solo el sueldo porque la tasa ya está definida en la función
    calcularSueldo(sueldo = 650.00)
}
fun calcularSueldo (
        sueldo: Double, //Requerido
        tasa: Double = 12.00, //Requerido (Tiene valor por defecto)
        calculoEspecial: Int? = null //(Pueden ser nulos)
        // int? debe especificarse cuando llame la función
        // null no es necesario especificar cuando llame la función
): Double {
    if (calculoEspecial != null) {
        return sueldo * tasa * calculoEspecial
    } else {
        return sueldo * tasa
    }
}
fun imprimirMensaje (){ //Unit = void
    println("")
}

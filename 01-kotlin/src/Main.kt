import java.util.*
import kotlin.collections.ArrayList

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

    val arregloConstante: Array<Int> = arrayOf(1,2,3)
    val arregloCumpleanos: ArrayList<Int> = arrayListOf(30,31,22,23,20)
    print(arregloCumpleanos)
    arregloCumpleanos.add(24)
    print(arregloCumpleanos)
    arregloCumpleanos.remove(30)
    print(arregloCumpleanos)

    //forEach
    arregloCumpleanos.forEach {
        println("Valor iteracion1: " + it)
    }

    arregloCumpleanos.forEach { valorIteracion: Int ->
        println("Valor iteracion2: " + valorIteracion)
    }

    arregloCumpleanos.forEach(
            {valorIteracion: Int ->
                println("Valor iteracion3: " + valorIteracion)
            }
    )
    //Map
    val respuestaMap = arregloCumpleanos
            .map { iterador: Int ->
                iterador * -1
    }
    println(respuestaMap)
    println(arregloCumpleanos)

    val respuestaMapDos = arregloCumpleanos
            .map { iterador: Int ->
                val nuevoValor = iterador * -1
                val otroValor = nuevoValor * 2
                return@map otroValor
            }
    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCumpleanos)

    //Filter
    val respuestaFilter = arregloCumpleanos
            .filter {
                iteracion: Int ->
                val esMayorA23 = iteracion > 23
                return@filter esMayorA23
            }

    arregloCumpleanos
            .filter {
                iteracion: Int -> iteracion > 23
            }
    println(respuestaFilter)
    println(arregloCumpleanos)
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

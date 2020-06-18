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

    //Any
    //And -> Todo verdadero es verdadero, el resto falso, si todos cumplen la condicion es verdadero
    //Or -> Todo falso es falso, el resto verdadero, si uno cumple la condicion ya es verdadero
    //All (some) -> Representa al AND
    //Any (every)-> Representa al OR
    // Devuelve una expresion TRUE o FALSE

    val respuestaAny:Boolean = arregloCumpleanos.any {
        iterador:Int ->
            return@any iterador<25
    }
    println(respuestaAny)

    val respuestaAll:Boolean = arregloCumpleanos.all {
        iterador:Int ->
        return@all iterador > 65
    }
    println(respuestaAll)

    //Reduce
    // 1. Devuelve un acumulador
    // Acumulador = 0

    val respuestaReduce:Int = arregloCumpleanos.reduce {
        acumulador, iteracion ->
        return@reduce acumulador + iteracion
    }
    println(respuestaReduce)

    // Fold
    val respuestaFold: Int = arregloCumpleanos.fold(
            100,
                {
                    acumulador, iteracion ->
                    return@fold acumulador - iteracion
                }
    )
    println(respuestaFold)
}


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

    // Ejercicio 1
    // Reducir el daño del 20% inicialmente
    // Todos los daños mayores a 18 afectaran a la vida del jugador

    val vidaActual: Double = arregloCumpleanos
            .map { it * 0.8 }
            .filter { it > 18 }
            .fold(100.00, {acc , d -> acc - d})
            .also { println(it) }

    val nuevoNumeroUno = SumaDosNumerosDos(1,1)
    val nuevoNumeroDos = SumaDosNumerosDos(null,1)
    val nuevoNumeroTres = SumaDosNumerosDos(1,null)
    val nuevoNumeroCuatro = SumaDosNumerosDos(null,null)

    println(SumaDosNumerosDos.arregloNumeros)
    SumaDosNumerosDos.agregarNumero(1)
    println(SumaDosNumerosDos.arregloNumeros)
    SumaDosNumerosDos.eliminarNumero(0)
    println(SumaDosNumerosDos.arregloNumeros)

    val  nombre : String?=null
    imprimirNombre("Karlita")

}

fun imprimirNombre(nombre :String?){
    println(nombre?.length)
    println(nombre?.toInt())
    println(nombre?.toDouble())

    val numeroCaracteres: Int ? = nombre?.length
}

// Clases Abstractas

abstract class NumerosJava{  // val nuevosNumeros = Numeros(1,2)
    protected val numeroUno:Int
    private val numeroDos:Int
    constructor(uno:Int, dos:Int){
        numeroUno = uno
        numeroDos = dos
    }
}
abstract class Numeros( // val nuevosNumeros = Numeros(1,2)
        protected var numeroUno:Int,
        protected var numeroDos:Int
){
}

class Suma(
        uno: Int,
        dos: Int
) : Numeros(uno, dos) {
    fun sumar():Int{
        // this.uno
        return this.numeroUno + this.numeroDos
    }
}
class SumaDos(
        public var uno: Int,
        public var dos: Int
) : Numeros(uno, dos) {
    fun sumar():Int{
        this.uno
        this.dos
        return this.numeroUno + this.numeroDos
    }
}

class SumaDosNumerosDos(
        uno: Int,
        dos: Int
): Numeros(uno,dos) {
    init {
        println("Hola init")
    }

    constructor(uno: Int?, dos: Int) : this(
            if (uno == null) 0 else uno,
            dos
    ) {
        println("Hola 1")
    }

    constructor(uno: Int, dos: Int?) : this(
            uno,
            if (dos == null) 0 else dos
    ) {
        println("Hola 2")
    }

    constructor(uno: Int?, dos: Int?) : this(
            if (uno == null) 0 else uno,
            if (dos == null) 0 else dos
    ) {
        println("Hola 3")
    }

    companion object {
        //para toda declaracion estatica
        val arregloNumeros = arrayListOf(1, 2, 3, 4)
        fun agregarNumero(nuevoNumero: Int) {
            this.arregloNumeros.add(nuevoNumero)
        }

        fun eliminarNumero(posicionNumero: Int) {
            this.arregloNumeros.removeAt(posicionNumero)
        }
    }
}
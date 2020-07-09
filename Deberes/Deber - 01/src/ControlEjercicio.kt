import java.io.File
import java.nio.file.Files.write
import java.nio.file.StandardOpenOption
import java.io.BufferedReader
import kotlin.system.exitProcess

class ControlEjercicio {

    fun crearEjercicio(
            nombreEjercicio: String,
            duracionEjercicio: Double,
            repeticiones: Int,
            eliminaGrasa: Boolean,
            tonifica: Boolean
    ) {
        val ejercicio1= Ejercicio(
            nombreEjercicio,
            duracionEjercicio,
            repeticiones,
            eliminaGrasa,
            tonifica
        )
        val outString = ejercicio1.toString()
        val archivo = File("archivos//ejercicios")
        write(archivo.toPath(), outString.toByteArray(), StandardOpenOption.APPEND)
        println("Ejercicio Creado Exitosamente")
        leerEjercicio()
    }

    fun buscarEjercicio(nombreEjercicio: String): List<String>? {
        var vector: List<String>
        var vectorResultado: List<String> = listOf("", "", "", "", "")
        var contador = 0

        val bufferedReader: BufferedReader = File("archivos//ejercicios").bufferedReader()
        val contenido = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { contenido.add(it) } }

        for (i: Int in contenido.indices) {
            vector = contenido[i].split(",")
            if (vector[0] == nombreEjercicio) {
                vectorResultado = vector
                //println("Ejercicio ubicado")
            } else {
                contador = contador + 1
            }
        }
        if (contador == contenido.size) {
           // println("Ejercicio no existe")
            vectorResultado = emptyList()
        }
        return vectorResultado;
    }

    fun actualizarEjercicio(nombreDato: String,nombreEjercicio: String) {
        var vector: MutableList<String> = mutableListOf()
        val tipoDato = nombreDato.split(":")
        var contador = 0
        val indice: Int
        var lineaNueva: String
        var lineasNuevas: ArrayList<String> = arrayListOf()

        if (tipoDato[0] == "nombre") {
            indice = 0
        } else if (tipoDato[0] == "duracion") {
            indice = 1
        } else if (tipoDato[0] == "repeticiones") {
            indice = 2
        } else if (tipoDato[0] == "elimina grasa") {
            indice = 3
        } else {
            indice = 4
        }

        val bufferedReader: BufferedReader = File("archivos//ejercicios").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector = lineas[i].split(",") as MutableList<String>
            if(vector[0]==nombreEjercicio){
                for (j: Int in vector.indices) {
                    if (j==indice) {
                        vector[j] = tipoDato[1]
                        if (indice == 5) {
                            vector[j] = tipoDato[1] + "\n"
                            // println("Ejercicio ubicado")
                        }
                        // println("Ejercicio ubicado")
                    }
                }
            } else {
                contador = contador + 1
                // print(contador)
            }
            lineaNueva = vector.joinToString(separator = ",")+"\n"
            lineasNuevas.add(lineaNueva)
        }
        if( contador == lineas.size){
            // println("Ejercicio no existe")
        }
        for (k: Int in lineasNuevas.indices) {
            if(k==0){
                File("archivos//ejercicios").bufferedWriter().use { out -> out.write(lineasNuevas[0])}
            }else{
                val file = File("archivos//ejercicios")
                write(file.toPath(), lineasNuevas[k].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

    fun eliminarEjercicio(nombreEjercicio: String){

        var vector1: MutableList<String> = mutableListOf()
        val vector2: MutableList<String> = mutableListOf("","","","","")
        var contador = 0
        var lineaNueva: String
        var lineasNuevas: ArrayList<String> = arrayListOf()

        val bufferedReader: BufferedReader = File("archivos//ejercicios").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>
            if(vector1[0]==nombreEjercicio){
                vector1=vector2
            } else {
                contador = contador + 1
               // print(contador)
            }
            lineaNueva = vector1.joinToString(separator = ",")+"\n"
            if( lineaNueva!= ",,,,"+"\n"){
                lineasNuevas.add(lineaNueva)
            }
        }
        if(contador == lineas.size){
            // println("Ejercicio no existe")
        }
        for (j: Int in lineasNuevas.indices) {
            if(j==0){
                File("archivos//ejercicios").bufferedWriter().use { out -> out.write(lineasNuevas[0])}
            }else{
                val file = File("archivos//ejercicios")
                write(file.toPath(), lineasNuevas[j].toByteArray(), StandardOpenOption.APPEND)
            }
        }
        val controlMusculo = ControlMusculo()
        controlMusculo.eliminarMusculoEjercicio(nombreEjercicio)
    }

    fun leerEjercicio() {

        val bufferedReader: BufferedReader = File("archivos//ejercicios").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }
        lineas.forEach { println(" $it") }
    }

    fun menu(){
        println("MENÚ DE EJERCICIOS")
        println("1. Crear un ejercicio")
        println("2. Buscar un ejercicio")
        println("3. Actualizar un ejercicio")
        println("4. Eliminar un ejercicio")
        println("5. Volver al menú principal")
        print("Elija una opción: ")
        var seleccion = readLine()?.toInt()
        when (seleccion){
            1 -> {
                println("Ingrese los datos del ejercicio");
                crearEj()
            }
            2 -> {
                println("Ingrese el nombre del ejercicio que desea buscar: ")
                val opcion = readLine().toString()
                buscarEj(opcion)
            }
            3 -> {
                print("Ingrese el nombre del ejercicio que desea actualizar: ")
                val opcion = readLine().toString()
                actualizarEj(opcion)
            }
            4 -> {
               println("ADVERTENCIA: Al eliminar un ejercicio se eliminarán los músculos trabajados por dicho ejercicio.")
                print("Ingrese el nombre del ejercicio que desea eliminar: ")
                val opcion = readLine().toString()
                eliminarEj(opcion)
            }
            5 -> {
                exitProcess(1)
            }
        }
        menu()
    }

    fun crearEj(){
        var nombreEjercicio: String
        var duracionEjercicio: Double
        var repeticiones: Int
        var eliminaGrasa: Boolean
        var tonifica: Boolean

        println("Ingrese el nombre del ejercicio : ")
        nombreEjercicio = readLine()?.toString() as String
        println("Ingrese la duración del ejercicio : ")
        duracionEjercicio = readLine()?.toDouble() as Double
        println("Ingrese la cantidad de repeticiones del ejercicio : ")
        repeticiones = readLine()?.toInt() as Int
        println("¿El ejercicio elimina grasa? : ")
        eliminaGrasa = readLine()?.toBoolean() as Boolean
        println("¿El ejercicio tonifica? : ")
        tonifica = readLine()?.toBoolean() as Boolean

        val controlEjercicio=ControlEjercicio()
        controlEjercicio.crearEjercicio(nombreEjercicio, duracionEjercicio, repeticiones, eliminaGrasa, tonifica)
    }

    fun buscarEj(nombreE: String){
        val controlEjercicio = ControlEjercicio()
        val datos = controlEjercicio.buscarEjercicio(nombreE)
        println(datos)
    }

    fun actualizarEj(nombreE: String){
        var nuevoDato: String
        println("Ingrese el dato a modificar con el siguiente formato : ")
        println("nombre:abdominales")
        println("duracion:0.5")
        println("repeticiones:4")
        println("elimina grasa:True")
        println("tonifica:False")
        nuevoDato = readLine()?.toString() as String
        val controlEjercicio = ControlEjercicio()
        controlEjercicio.actualizarEjercicio(nuevoDato,nombreE)
    }

    fun eliminarEj(nombreE: String){
        val controlEjercicio = ControlEjercicio()
        val controlMusculo = ControlMusculo()
        controlEjercicio.eliminarEjercicio(nombreE)
        controlMusculo.eliminarMusculoEjercicio(nombreE)
    }
}
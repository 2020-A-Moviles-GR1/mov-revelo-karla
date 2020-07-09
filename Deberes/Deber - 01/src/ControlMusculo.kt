import java.io.File
import java.nio.file.Files.write
import java.nio.file.StandardOpenOption
import java.io.BufferedReader
import kotlin.system.exitProcess

class ControlMusculo {

    fun crearMusculo(
        nombreEj: String,
        nombreMusculo: String,
        ubicacionMusculo: String,
        definicion: Boolean,
        masaMuscular: Double
    ) {
        val musculo1= Musculo(
            nombreMusculo,
            ubicacionMusculo,
            definicion,
            masaMuscular,
            nombreEj
        )
        val outString = musculo1.toString()
        val file = File("archivos//musculos")
        write(file.toPath(), outString.toByteArray(), StandardOpenOption.APPEND)
        leerMusculo()
    }

    fun buscarMusculo(nombreMusculo: String): List<String>? {
        var vector: List<String>
        var vectorResultado: List<String> = listOf("", "", "", "", "","")
        var contador = 0

        val bufferedReader: BufferedReader = File("archivos//musculos").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector = lineas[i].split(",")
            if (vector[0] == nombreMusculo) {
                vectorResultado = vector
               // println("Musculo ubicado")
            } else {
                contador = contador + 1
            }
        }
        if (contador == lineas.size) {
            // println("Musculo no existe")
            vectorResultado = emptyList()
        }
        return vectorResultado;
    }

    fun actualizarMusculo(nombreDato: String,nombreMusculo: String, nombreEjercicio:String) {
        var vector: MutableList<String> = mutableListOf()
        val tipoDato = nombreDato.split(":")
        var contador = 0
        val indice: Int
        var lineaNueva: String
        var lineasNuevas: ArrayList<String> = arrayListOf()

        if (tipoDato[0] == "nombre") {
            indice = 0
        } else if (tipoDato[0] == "ubicacion") {
            indice = 1
        } else if (tipoDato[0] == "definicion") {
            indice = 2
        }else if (tipoDato[0] == "masa muscular") {
            indice = 3
        } else {
            indice = 4
        }

        val bufferedReader: BufferedReader = File("archivos//musculos").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector = lineas[i].split(",") as MutableList<String>
            if(vector[0]==nombreMusculo){
                for (j: Int in vector.indices) {
                    if (j==indice) {
                        vector[j] = tipoDato[1]
                        if (indice == 4 ) {
                            vector[j] = tipoDato[1] + "\n"
                            // println("Musculo no existe")
                        }
                        // println("Musculo no existe")
                    }
                }
            } else {
                contador = contador + 1
                // print(contador)
            }
            lineaNueva = vector.joinToString(separator = ",")+"\n"
            lineasNuevas.add(lineaNueva)
        }
        if(contador==lineas.size){
            // println("Musculo no existe")
        }
        for (k: Int in lineasNuevas.indices) {
            if(k==0){
                File("archivos//musculos").bufferedWriter().use { out -> out.write(lineasNuevas[0])}
            }else{
                val file = File("archivos//musculos")
                write(file.toPath(), lineasNuevas[k].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

    fun eliminarMusculo(nombreMusculo: String){

        var vector1: MutableList<String> = mutableListOf()
        val vector2: MutableList<String> = mutableListOf("","","","","","")
        var contador = 0
        var lineaNueva: String
        var lineasNuevas: ArrayList<String> = arrayListOf()

        val bufferedReader: BufferedReader = File("archivos//musculos").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vector1 = lineas[i].split(",") as MutableList<String>
            if(vector1[0]==nombreMusculo){
                vector1=vector2
            } else {
                contador = contador + 1
               // print(contador)
            }
            lineaNueva = vector1.joinToString(separator = ",")+"\n"

            if(lineaNueva!=",,,,,"+"\n"){
                lineasNuevas.add(lineaNueva)
            }
        }
        if(contador==lineas.size){
            // println("Musculo no existe")
        }
        for (j: Int in lineasNuevas.indices) {
            if(j==0){
                File("archivos//musculos").bufferedWriter().use { out -> out.write(lineasNuevas[0])}
            }else{
                val file = File("archivos//musculos")
                write(file.toPath(), lineasNuevas[j].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

    fun eliminarMusculoEjercicio(nombreEjercicio1: String){

        var vectorA: MutableList<String> = mutableListOf()
        val vector2: MutableList<String> = mutableListOf("","","","","","")
        var cont = 0
        val indice: Int
        var lineaReEscrita: String
        var lineasNuevasUni: ArrayList<String> = arrayListOf()
        val bufferedReader: BufferedReader = File("archivos//musculos").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }

        for (i: Int in lineas.indices) {
            vectorA = lineas[i].split(",") as MutableList<String>
            if (vectorA[4]== nombreEjercicio1){
                //print("entre al if")
                vectorA=vector2
            } else {
                cont = cont + 1
            }
            lineaReEscrita = vectorA.joinToString(separator = ",")+"\n"
            if(lineaReEscrita!=",,,,"+"\n"){
                lineasNuevasUni.add(lineaReEscrita)
            }
        }
        if(cont==lineas.size){
            //println("error lineas size")
        }
        for (iter: Int in lineasNuevasUni.indices) {
            if(iter==0){
                File("archivos//musculos").bufferedWriter().use { out -> out.write(lineasNuevasUni[0])}
            }else{
                val archivo = File("archivos//musculos")
                write(archivo.toPath(), lineasNuevasUni[iter].toByteArray(), StandardOpenOption.APPEND)
            }
        }
    }

    fun leerMusculo() {

        val bufferedReader: BufferedReader = File("archivos//musculos").bufferedReader()
        val lineas = mutableListOf<String>()
        bufferedReader.useLines { lines -> lines.forEach { lineas.add(it) } }
        lineas.forEach { println(" $it") }
    }

    fun menu(){
        println("MENÚ DE MÚSCULOS")
        println("1. Crear un músculo")
        println("2. Buscar un músculo")
        println("3. Actualizar un músculo")
        println("4. Eliminar un músculo")
        println("5. Volver al menú principal")
        print("Elija una opción: ")
        var seleccion = readLine()?.toInt()
        when (seleccion){
            1 -> {
                println("Ingrese los datos del músculo");
                crearMu()
            }
            2 -> {
                print("Ingrese el nombre del músculo que desea buscar : ")
                val opcion = readLine().toString()
                buscarMu(opcion)
            }
            3 -> {
                print("Ingrese el nombre del músculo que desea actualizar: ")
                val opcionM = readLine().toString()
                print("Ingrese el nombre del ejercicio que trabaja este músculo: ")
                val opcionE = readLine().toString()
                actualizarMu(opcionM, opcionE)
            }
            4 -> {
                print("Ingrese el nombre del músculo que desea eliminar: ")
                val opcion = readLine().toString()
                eliminarMu(opcion)
            }
            5 -> {
                exitProcess(1)
            }
        }
        menu()
    }

    fun crearMu(){
        var nombreMusculo: String
        var ubicacionMusculo: String
        var definicion: Boolean
        var masaMuscular: Double
        var nombreEj: String

        println("Ingrese el nombre del músculo : ")
        nombreMusculo = readLine()?.toString() as String
        println("Ingrese la ubicación del músculo : ")
        ubicacionMusculo = readLine()?.toString() as String
        println("¿Tiene definido este músculo? : ")
        definicion = readLine()?.toBoolean() as Boolean
        println("Ingrese la masa muscular del músculo : ")
        masaMuscular = readLine()?.toDouble() as Double
        println("Ingrese el ejercicio que trabaja este músculo : ")
        nombreEj = readLine()?.toString() as String

        val controlMusculo = ControlMusculo()
        controlMusculo.crearMusculo(nombreEj, nombreMusculo, ubicacionMusculo, definicion, masaMuscular)
    }

    fun buscarMu(nombreM: String){
        val controlMusculo = ControlMusculo()
        val datos = controlMusculo.buscarMusculo(nombreM)
        println(datos)
    }

    fun actualizarMu(nombreM: String, nombreE:String){
        var nuevoDato: String
        println("Ingrese el dato a modificar con el siguiente formato:")
        println("nombre:oblicuo")
        println("ubicacion:abdomen")
        println("definicion:True")
        println("masa muscular:0.3")
        nuevoDato = readLine()?.toString() as String
        val controlMusculo = ControlMusculo()
        controlMusculo.actualizarMusculo(nuevoDato,nombreM, nombreE)
    }

    fun eliminarMu(nombreM: String){
        val controlMusculo = ControlMusculo()
        controlMusculo.eliminarMusculo(nombreM)
    }
}
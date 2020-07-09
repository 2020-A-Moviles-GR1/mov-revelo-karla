class Main {

}

fun main ( args:Array<String> ) {

    println("MENÚ PRINCIPAL")
    println("1. Gestionar ejercicios")
    println("2. Gestionar músculos")
    print("Elija una opción: ")
    var opcion = readLine()?.toInt()
    when (opcion) {
        1 -> {
            val menuEjercicio = ControlEjercicio()
            menuEjercicio.menu()
        }
        2 -> {
            val menuMusculo = ControlMusculo()
            //menuMusculo.menu()
            menuMusculo.eliminarMusculoEjercicio("abdominales")
        }
    }
    // val uno = ControlEjercicio()
    // uno.crearEjercicio("sentadillas", 0.5, 4, true,true)
}


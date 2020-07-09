import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue

class Ejercicio (
    var nombreEjercicio: String,
    var duracionEjercicio: Double,
    var repeticiones: Int,
    var eliminaGrasa: Boolean,
    var tonifica: Boolean
){
    override fun toString ():String{
        return "${nombreEjercicio},${duracionEjercicio}," +
                "${repeticiones},${eliminaGrasa}, ${tonifica}\n"
    }
}

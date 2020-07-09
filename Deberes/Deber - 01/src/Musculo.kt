class Musculo (
    var nombreMusculo: String,
    var ubicacionMusculo: String,
    var definicion: Boolean,
    var masaMuscular: Double,
    var nombreEj: String
) {
    override fun toString(): String {
        return "${nombreMusculo},${ubicacionMusculo},${definicion}," +
                "${masaMuscular},${nombreEj}\n"
    }
}

package com.example.examen1bimestre

class BddService {
    companion object{
        var listaEjercicios= arrayListOf<Ejercicio>(Ejercicio("Sentadillas","0.5","4","Sí", "Gluteo mayor"))
        var listaMusculos1 = arrayListOf<Musculo>(Musculo("gluteo mayor","gluteos","20.5","Sí"));
        var listaMusculos= arrayListOf<Musculo>(
            Musculo("gluteo mayor","gluteos","20.5","Sí"),
            Musculo("gluteo menor","gluteos","22.5","Sí"),
            Musculo("cuadriceps","piernas","10.5","Sí"),
            Musculo("isquiotibiales","piernas","12.5","Sí"),
            Musculo("recto abdominal","abdomen","11.5","Sí"),
            Musculo("pectoral","pecho","23.5","Sí"),
            Musculo("gluteo mayor","gluteos","20.5","Sí"),
            Musculo("femorales","piernas","7.5","Sí"),
            Musculo("gluteo mayor","gluteos","20.5","Sí")
        )
        fun buscarMusculo(valor:String): Musculo? {
            var musculoE= listaMusculos.find{ musculo -> musculo.nombre
                .equals(valor.toLowerCase())||musculo.ubicacion.equals(valor.toLowerCase()) }
            return musculoE
        }

        fun agregarEjercicio(ejercicio:Ejercicio){
            listaEjercicios.add(ejercicio)
        }
        fun eliminarEjercicio(ejercicio: Ejercicio){
            listaEjercicios.remove(ejercicio)
        }
        fun modificarEjercicio(posicion:Int,ejercicio: Ejercicio){
            listaEjercicios.set(posicion,ejercicio);
        }
        fun recuperarEjercicio(posicion: Int):Ejercicio{
            return listaEjercicios.get(posicion);
        }

        fun agregarMusculo(musculo: Musculo){
            listaMusculos1.add(musculo)
        }
        fun eliminarMusculo(musculo: Musculo){
            listaMusculos1.remove(musculo)
        }
        fun modificarMusculo(posicion:Int, musculo: Musculo){
            listaMusculos1.set(posicion,musculo)
        }
        fun recuperarMusculo(posicion:Int): Musculo{
            return listaMusculos1.get(posicion)
        }
    }
}
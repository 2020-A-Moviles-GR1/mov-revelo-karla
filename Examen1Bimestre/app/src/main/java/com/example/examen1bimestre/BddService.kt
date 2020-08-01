package com.example.examen1bimestre

class BddService {
    companion object{
        var listaCanciones= arrayListOf<Cancion>(Cancion("Kids","MGMT","Easy Listening","Am,Bm,C"))
        var listaAcordes= arrayListOf<Acorde>(
            Acorde("c","do",R.drawable.c),
            Acorde("cm","dom",R.drawable.dom),
            Acorde("d","re",R.drawable.d),
            Acorde("dm","rem",R.drawable.rem),
            Acorde("e","mi",R.drawable.e),
            Acorde("em","mim",R.drawable.mim),
            Acorde("f","fa",R.drawable.f),
            Acorde("fm","fam",R.drawable.fam),
            Acorde("g","sol",R.drawable.g),
            Acorde("gm","solm",R.drawable.solm),
            Acorde("a","la",R.drawable.a),
            Acorde("am","lam",R.drawable.lam),
            Acorde("b","si",R.drawable.b),
            Acorde("bm","sim",R.drawable.sim)
        )
        fun buscarAcorde(chord:String): Acorde? {
            var acordeEncontrado=listaAcordes.find{acorde -> acorde.notacionInglesa
                .equals(chord.toLowerCase())||acorde.notacionLatina.equals(chord.toLowerCase()) }
            return acordeEncontrado
        }

        fun agregarCancion(cancion:Cancion){
            listaCanciones.add(cancion)
        }
        fun elimarCancion(cancion: Cancion){
            listaCanciones.remove(cancion)

        }
        fun modificarCancion(posicion:Int,cancion: Cancion){
            listaCanciones.set(posicion,cancion);
        }
        fun obtenerCancion(posicion: Int):Cancion{
            return listaCanciones.get(posicion);
        }


    }
}
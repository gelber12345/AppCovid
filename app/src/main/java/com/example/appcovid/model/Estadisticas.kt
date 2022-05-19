package com.example.appcovid.model


import com.example.appcovid.R
object Estadisticas{
    data class Estadistica(
        val provincia:String,
        val posv: Int,
        val posm: Int,
        val nega:Int,
        val pendientes:Int,
        val total:Int,
        val img: Int
        )

    private val estadList:  MutableList<Estadistica> = mutableListOf(
        Estadistica(" ALTO SELVA ALEGRE " , 20770 , 267 , 147024 , 123 , 168184, R.drawable.escudoaltosv ),
        Estadistica("AREQUIPA", 75328, 2517, 858603, 198, 936646, R.drawable.escudoaqp),
        Estadistica("CAYMA", 22954, 301, 178000, 149, 201404, R.drawable.escudocayma),
        Estadistica("CERRO COLORADO", 41591, 440, 448239, 271, 490541, R.drawable.escudocerroc),
        Estadistica("CHARACATO", 2201, 34, 17751, 22, 20008, R.drawable.escudoaqp),
        Estadistica("CHIGUATA", 820, 7, 5063, 2, 5892, R.drawable.escudoaqp),
        Estadistica("JACOBO HUNTER", 14114, 211, 96141, 92, 110558, R.drawable.escudojahunter),
        Estadistica(" JOSÉ LUIS BUSTAMANTE Y RIVERO ", 21730 , 277 , 174959 , 129 , 197095 , R.drawable.escudojlbr),
        Estadistica("LA JOYA", 4359, 74, 19744, 7, 24184, R.drawable.escudoaqp),
        Estadistica ("MARIANO MELGAR", 15911, 219, 93182, 69, 109381, R.drawable.escudomarianomelgar),
        Estadistica(" MIRAFLORES ", 16190 , 246 , 99562 , 66 , 116064 , R.drawable.escudomiraflores),
        Estadistica(" MOLLEBAYA " , 402 , 4 , 3045 , 4 , 3455, R.drawable.escudomollebaya ),
        Estadistica (" PAUCARPATA ", 36002 , 528 , 230103 , 163 , 266796 , R.drawable.escudopaucarpata),
        Estadistica("POCSI", 77, 2, 344, 0, 423, R.drawable.escudopocsi),
        Estadistica("POLOBAYA", 107, 1, 573, 1, 682, R.drawable.escudoaqp),
        Estadistica("QUEQUEÑA", 324, 6, 2066, 1, 2397, R.drawable.escudoquequena),
        Estadistica("SABANDIA", 953, 11, 7123, 10, 8097, R.drawable.escudosabandia),
        Estadistica("SACHACA", 6600, 58, 61334, 48, 68040, R.drawable.escudosacha),
        Estadistica("SAN JUAN DE SIGUAS", 47, 0, 316, 0, 363, R.drawable.escudoaqp),
        Estadistica("SAN JUAN DE TARUCANI", 161, 2, 811, 1, 975, R.drawable.escudoaqp),
        Estadistica("SANTA ISABEL DE SIGUAS", 31, 0, 187, 0, 218, R.drawable.escudosantaisabel),
        Estadistica("SANTA RITA DE SIGUAS", 654, 11, 2128, 0, 2793, R.drawable.escudosantarita),
        Estadistica("SOCABAYA", 17908, 213, 132440, 113, 150674, R.drawable.escudosocabaya),
        Estadistica("TIABAYA", 4162, 39, 37029, 64, 41294, R.drawable.escudotiabaya),
        Estadistica("UCHUMAYO", 3332 , 38 , 36649 , 77 , 40096, R.drawable.escudoaqp ),
        Estadistica("VITOR", 702, 12, 2330, 0, 3044, R.drawable.escudovitor),
        Estadistica("YANAHUARA", 12307, 134, 114843, 41, 127325, R.drawable.escudoaqp),
        Estadistica("YARABAMBA", 489, 7, 4674, 1, 5171, R.drawable.escudoaqp) ,
        Estadistica("YURA", 4598, 47, 39323, 32, 44000, R.drawable.escudoaqp)
        )

    fun getListIterator(): MutableListIterator<Estadistica> {
        return estadList.listIterator()
    }
    fun getList(): MutableList<Estadistica> {
        return estadList
    }
    fun getEvent(prov:String) : Estadistica {
        estadList.forEach() {
            if (prov == it.provincia) {
                return it
            }
        }
        return estadList[0];
    }
}
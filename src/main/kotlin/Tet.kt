import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

object Tet {
    var arrayDron:ArrayList<Dron> = ArrayList()
    var dest:String= ""
    var ArrayOrdenes:ArrayList<Orden> = ArrayList()
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale("es","ES"))
    var fecha = sdf.format(Date()).toString()
    var desc=""

    fun meterDron(){
        for (i in 0..199){
            arrayDron.add(Factoria.generarDrones())
        }
    }

    fun generarOrdenRepara():Reparacion{
        var ob = Reparacion(fecha,false,null)
        return ob
    }
    fun generarOrdenReco():Reconocimiento{
        var ob = Reconocimiento(fecha,false,dest, desc)
        return ob
    }



}
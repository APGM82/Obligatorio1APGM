import java.text.SimpleDateFormat
import java.util.*

abstract class Orden {
    //val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale("es","ES"))
    //var fecha = sdf.format(Date()).toString()
    var fecha:String?=null
    var completada:Boolean = false


    constructor(f:String, c:Boolean){
        this.fecha = f
        this.completada = c
    }

    abstract fun resumenOrden():String
}
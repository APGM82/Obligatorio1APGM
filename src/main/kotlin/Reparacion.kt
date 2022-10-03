import java.util.*

class Reparacion (f: String,c:Boolean):Orden(f,c){
    var destino:String?=null

    constructor(f:String, c:Boolean, d:String?):this(f,c){
        this.fecha = f
        this.completada = c
        this.destino=d
    }

    override fun resumenOrden(): String {
        return "Fecha reparación " + this.fecha + " esta completada: "+this.completada
    }
}
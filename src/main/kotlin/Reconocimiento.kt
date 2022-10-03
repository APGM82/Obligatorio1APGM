import kotlin.random.Random

class Reconocimiento (f: String, c:Boolean):Orden(f,c){
    var numAzar:Int = 0
    var descripcion:String?=null
    var destino:String?=null
    //var i:Int=Random.nextInt(0,2)
    //var j:Int=Random.nextInt(0,2)
    init{
        this.numAzar = Random.nextInt(1,20)
        //this.destino = ""+i+","+j
    }

    constructor(f:String, c:Boolean, d:String, des:String):this(f,c){
        this.fecha = f
        this.completada = c
        this.destino=d
        //this.numAzar=n
        this.descripcion=des
    }


    override fun resumenOrden(): String {
        return "Fecha reconocimiento " + this.fecha + " esta completada: "+this.completada + "descripción: "+this.descripcion
    }
}
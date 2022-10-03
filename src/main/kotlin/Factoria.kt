import kotlin.random.Random

object Factoria {
    var dn:Int=1;
    fun generarDrones():Dron{
        var idnom:Int = dn;
        var changado:Boolean = false;
        var d:Dron = Dron.Builder().id(idnom).estado(changado).build()
        dn++
        return d

    }
    var f:Int=0;
    var C:Int=-1;
    var fv:Int=0;
    var Cv:Int=-1;

    fun generarJack():Persona {
        if(C>=2){f++}
        if(!(C>=2)){C++}else{C=0}
        var nom:String = "Jack"+f+C;
        //var vida = Random.nextInt(1,100)
        //var edadAzar:Int = Random.nextInt(1,200)
        //var p:Persona = Persona(nombre, edadAzar, vida, "DAM")
        var p:Persona = Persona.Builder().nombre(nom).build()
        return p
    }
    fun generarVika():Persona {
        if(Cv>=2){fv++}
        if(!(Cv>=2)){Cv++}else{Cv=0}
        var nom:String = "Vika"+fv+Cv
        //var vida = Random.nextInt(1,100)
        //var edadAzar:Int = Random.nextInt(1,200)
        //var p:Persona = Persona(nombre, edadAzar, vida, "DAM")
        var p:Persona = Persona.Builder().nombre(nom).build()
        return p
    }
}
class Dron (var id:Int? = null,var estado:Boolean? = null){

    override fun toString(): String {
        return "Dron número: (" + this.id + ", estropeado = " + this.estado + ")"//ponerlo bonito para que diga el estado
    }

    class Builder(var id:Int? = null,var estado:Boolean? = null) {
        fun id(id: Int): Builder {
            this.id = id
            return this
        }

        fun estado(estado: Boolean): Builder {
            this.estado = estado
            return this
        }



        fun build(): Dron {
            return Dron(id,estado)
        }
    }

}
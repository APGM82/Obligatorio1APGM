class Persona(var nombre:String? = null) {
    override fun toString(): String {
        return "Persona: (" + this.nombre + ")"
    }
    class Builder(var nombre:String? = null) {
        fun nombre(nombre: String): Builder {
            this.nombre = nombre
            return this
        }


        fun build(): Persona {
            return Persona(nombre)
        }
    }
}
package clases
class lampada {
    private val identificador: String
    private var estat: Boolean = false
    private var color: String = "blanco"
    private var intensitat: Int = 1

    constructor(identificador: String) {
        this.identificador = identificador
    }

    fun veureId(): String {
        return this.identificador
    }

    fun veureEstat(): Boolean {
        return this.estat
    }

    fun veureColor(): String {
        return this.color
    }

    fun veureIntensitat(): Int {
        return this.intensitat
    }
    fun encendre() {
        this.estat = true
    }

    fun apagar() {
        this.estat = false
    }

    fun canviarColor(color: String) {
        this.color = color
    }

    fun canviarIntensitat(intensitat: Int) {
        this.intensitat = intensitat
    }

    override fun toString(): String {
        return "Lampada: $identificador\n" +
                "Estat: $estat\n" +
                "Color: $color\n" +
                "Intensitat: $intensitat"
    }


}
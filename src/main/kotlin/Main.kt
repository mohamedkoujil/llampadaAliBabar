import clases.lampada

fun main() {
    var lampades = mutableListOf<lampada>()

    do {
        var menuInicial = menuInicial()
        when (menuInicial) {
            1 -> {
                lampades.add(menuCreacio())
            }
            2 -> {
                if (lampades.size == 0) {
                    println("No hi ha cap lampada creada")
                    continue
                }
                eleccioLampada(lampades)
            }
        }
    } while (menuInicial != 0)

}
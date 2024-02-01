import clases.lampada
/**
 * Muestra el menú inicial de la aplicación y retorna la opción seleccionada por el usuario.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @return La opción seleccionada por el usuario.
 */
fun menuInicial(): Int {
    return readInt(
        "1. Crear lámpara\n" +
                "2. Seleccionar lámpara",
        "Introduce un número",
        "Introduce una opción correcta",
        1, 2
    )
}

/**
 * Crea una nueva lámpara con el nombre proporcionado por el usuario.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @return La nueva lámpara creada.
 */
fun menuCreacio(): lampada {

    var nomLampada = readWord(
        "Introduce el nombre de la lámpara, recuerda que debe ser único",
        "Introduce un nombre correcto"
    )

    return lampada(nomLampada)
}

/**
 * Muestra la lista de lámparas disponibles.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampades Lista de lámparas a mostrar.
 */
fun mostrarLampades(lampades: MutableList<lampada>) {
    for (i in lampades.indices) {
        println("${i + 1}. ${lampades[i].veureId()}")
    }
}

/**
 * Permite al usuario seleccionar una lámpara de la lista y acceder a su menú.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampades Lista de lámparas disponibles.
 */
fun eleccioLampada(lampades: MutableList<lampada>) {
    mostrarLampades(lampades)
    var eleccioLampada = readInt("Introduce el número de la lámpara que quieres escoger",
        "Introduce un número correcto",
        "Introduce un número correcto",
        1,
        lampades.size
    )
    menuLampada(lampades[eleccioLampada - 1], lampades)
}

/**
 * Menú de opciones para una lámpara específica.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampada Lámpara sobre la que se realizan las operaciones.
 * @param lampades Lista de lámparas disponibles.
 */
fun menuLampada(lampada: lampada, lampades: MutableList<lampada>) {
    var index = 0
    var intensitat = 1
    veureLampada(lampada)
    do {
        var eleccioUsr = readInt("1. Encender lámpara\n"+
                "2. Apagar lámpara\n"+
                "3. Cambiar color lámpara\n"+
                "4. Cambiar intensidad lámpara\n"+
                "5. Ver lámpara\n"+
                "6. Eliminar lámpara\n"+
                "7. Volver al menú inicial",
            "Introduce un número",
            "Introduce una opción correcta",
            1,7)

        when (eleccioUsr) {

            1 -> {
                lampada.encendre()
                veureLampada(lampada)
            }
            2 -> {
                lampada.apagar()
                veureLampada(lampada)
            }
            3 -> {
                if(comprovarEstat(lampada)) {
                    index++
                    if (index == 4) {
                        index = 0
                    }
                    canviarColor(lampada, index)
                    veureLampada(lampada)
                }

            }
            4 -> {
                if(comprovarEstat(lampada)) {
                    intensitat++
                    if (intensitat == 6) {
                        intensitat = 1
                    }
                    canviarIntensitat(lampada, intensitat)
                    veureLampada(lampada)
                }
            }
            5 -> {
                println(lampada.toString())

            }
            6 -> {
                eliminarLampada(lampades, lampada)

            }

        }


    } while (eleccioUsr != 7 && eleccioUsr != 6)
}

/**
 * Verifica el estado de la lámpara y muestra un mensaje si está apagada.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampada Lámpara cuyo estado se verifica.
 * @return `true` si la lámpara está encendida, `false` si está apagada.
 */
fun comprovarEstat(lampada: lampada): Boolean {
    if (!lampada.veureEstat()) {
        println("La lámpara está apagada")
    }
    return lampada.veureEstat()
}

/**
 * Cambia el color de la lámpara según el índice proporcionado.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampada Lámpara cuyo color se cambia.
 * @param index Índice que determina el color a cambiar.
 */
fun canviarColor(lampada: lampada, index: Int) {
    val colors = arrayOf("blanco","rojo", "verde", "azul", "amarillo")
    lampada.canviarColor(colors[index])
}

/**
 * Cambia la intensidad de la lámpara según el valor proporcionado.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampada Lámpara cuya intensidad se cambia.
 * @param intensitat Nuevo valor de intensidad.
 */
fun canviarIntensitat(lampada: lampada, intensitat: Int) {
    lampada.canviarIntensitat(intensitat)
}

/**
 * Muestra el estado y la intensidad de la lámpara.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampada Lámpara cuyo estado e intensidad se muestra.
 */
fun veureLampada(lampada: lampada) {
    print("${lampada.veureId()}  ")
    if (lampada.veureEstat()) {
        when (lampada.veureColor()) {
            "blanco" -> print("$WHITE_BACKGROUND          $RESET ")
            "rojo" -> print("$RED_BACKGROUND          $RESET ")
            "verde" -> print(" $GREEN_BACKGROUND          $RESET ")
            "azul" -> print("$BLUE_BACKGROUND          $RESET ")
            "amarillo" -> print("$YELLOW_BACKGROUND          $RESET ")
        }
        println("Intensidad: " + lampada.veureIntensitat())
    } else println("          Intensidad: 0")

}

/**
 * Elimina una lámpara de la lista de lámparas disponibles.
 * @since 01/02/2024
 * @author mohamedkoujil
 * @param lampades Lista de lámparas disponibles.
 * @param lampada Lámpara a eliminar.
 */
fun eliminarLampada(lampades: MutableList<lampada>, lampada: lampada) {
    lampades.removeAt(lampades.indexOf(lampada))
}

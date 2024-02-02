![image](https://github.com/mohamedkoujil/llampadaAliBabar/assets/74406781/2769adf6-dc54-46e1-b335-bc1551c6349c)

@startuml
class Lampada {
-- atributs --
- identificador: String
- estat: boolean
- color: string
- intensitat: Int
-- mètodes --
+ constructor(identificador: String): lampada
+ veureId(): String
+ veureEstat(): Boolean
+ veureColor(): String
+ veureIntensitat(): Int
+ encendre()
+ apagar()
+ canviarColor(color: String)
+ canviarIntensitat(intensitat: Int)
+ toString(): String
}
@enduml

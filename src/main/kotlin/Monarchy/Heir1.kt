package Monarchy

class Heir1(private val heir1Name: String, private val intelect: Int,
            private val power: Int) : Ruler(heir1Name, intelect, power) {
    // Переопределяем метод rullingKingdom для вывода информации о наследнике 1
    override fun rullingKingdom(): String {
        return "Имя наследника 1: $heir1Name, интелект: $intelect, сила: $power"
    }
}
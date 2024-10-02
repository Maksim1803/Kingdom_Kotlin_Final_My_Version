package Monarchy

class Heir2(private val heir2Name: String, private val intelect: Int,
            private val power: Int) : Ruler(heir2Name, intelect, power) {
    // Переопределяем метод rullingKingdom для вывода информации о наследнике 2
    override fun rullingKingdom(): String {
        return "Имя наследника 2: $heir2Name, интелект: $intelect, сила: $power"
    }
}

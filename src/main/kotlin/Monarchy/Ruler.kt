package Monarchy

open class Ruler(private val rulerName: String, private val intelect: Int,
                 private val power: Int) : RullingKingdom {
    // Переопределяем метод rullingKingdom для вывода информации о правителе
    override fun rullingKingdom(): String {
        return "Имя короля: $rulerName, интелект: $intelect, сила: $power"
    }
}
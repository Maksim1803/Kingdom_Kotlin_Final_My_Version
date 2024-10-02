import Army.Archer
import Army.Warrior
import Monarchy.Heir1
import Monarchy.Heir2
import Monarchy.Ruler
import Peasants.*
import kotlin.random.Random
import Monarchy.Heirs

class Kingdom { // Объявление класса Kingdom

    var treasury = 0 // Объявление изменяемой переменной treasury (казна) типа Int,
    // инициализированной нулем.
    val peasants = mutableListOf<Peasant>() // объявление списка крестьян

}

private fun addPeasants(myKingdom: Kingdom) {  //функция addPeasants3 принимает параметр
    // myKingdom типа Kingdom3. Это значит, что функция addPeasants ожидает,
    // что ей будет передан объект типа Kingdom3.

    val peasants = mutableListOf<Peasant>() // Создаем список для хранения крестьян

    // Создаем 10 крестьян с разными профессиями:
    for (i in 1..10) {
        // Используем `when` для выбора профессии:
        when {
            // Если i делится на 2, то крестьянин - строитель
            i % 2 == 0 -> {
                peasants.add(Peasant(Occupation.BUILDER))
            }
            // Если i делится на 3, то крестьянин - фермер
            i % 3 == 0 -> {
                peasants.add(Peasant(Occupation.FARMER))
            }
            // В остальных случаях крестьянин - рабочий
            else -> {
                peasants.add(Peasant(Occupation.WORKER))
            }
        }
    }
    //  Добавляем всех созданных крестьян в королевство
    myKingdom.peasants.addAll(peasants)
}

private fun addHeirs() {
    // Создаем список для хранения наследниц
    val heirs = mutableListOf<Heirs>()
    // Добавляем наследниц в список
    heirs.add(Heirs("Мария", 8, 6))
    heirs.add(Heirs("Елизавета", 9, 8))
    heirs.add(Heirs("Екатерина", 7, 8))
    // ... добавьте других наследниц

    // Выводим список наследниц
    println("Наследницы короля:")
    heirs.forEach { heir ->
        println("Имя: ${heir.name}, Интеллект: ${heir.intellect}, Сила: ${heir.power}")
    }
}

private fun addArchers() {
    // Создаем список для хранения лучников
    val archers = mutableListOf<Archer>()

    // Создаем 5 лучников со случайным наличием кинжала
    for (i in 1..5) {
        val name = "Лучник $i"
        val bow = "Длинный лук $i"
        val dagger = if (Random.nextInt(2) == 0) "в наличии $i" else null
        archers.add(Archer(name, bow, dagger))
    }
    // Выводим список лучников
    println("Лучники короля:")
    archers.forEach { archer ->
        println("${archer.name}: лук - ${archer.bow}, кинжал - ${archer.dagger ?: "без кинжала"}}")
    }
}

private fun addWarriors() {
    // Создаем список для хранения воинов
    val warriors = mutableListOf<Warrior>()

    // Создаем 5 воинов со случайным выбором оружия
    for (x in 1..5) {
        val name = "Воин $x"
        val weapon = if (Random.nextInt(2) == 0) "Меч" else "Топор"
        warriors.add(Warrior(name, weapon))
    }

    // Выводим список воинов
    println("Воины короля:")
    warriors.forEach { warrior ->
        println("${warrior.name}: оружие - ${warrior.weapon}")
    }
}

// Создание extension функции, которая будет добавлять «Ваше Высочество» к строкам и выводить это в консоль.
fun String.yourHighness() {
    println("Ваше Высочество, $this")
}
// Разберем подробнее. Здесь у нас функция yourHighness(): Это имя функции.
// Она не принимает никаких параметров. String: Указывает, что эта функция
// является расширяющей функцией для класса String. Это значит, что ее можно
// вызывать на объектах типа String. Println ("Ваше...) - вывод в консоль
// $this - специальный символ, который заменяется на значение объекта,
// на котором вызвана функция yourHighness. У нас в main это
// "Ваша популярность падает!" - значение объекта, .yourHighness() - вызов функции.

fun main() {
    // Создаем объект Ruler (правителя)
    val kingdom = Ruler("Артем", 10, 10)
    // Создаем объект Heir1 (наследника 1)
    val heir1 = Heir1("Иван", 8, 7)
    // Создаем объект Heir2 (наследника 2)
    val heir2 = Heir2("Павел", 9, 9)
    // Выводим информацию о правителе и наследниках
    println(kingdom.rullingKingdom())
    println(heir1.rullingKingdom())
    println(heir2.rullingKingdom())

    //Чтобы использовать функцию addPeasants, нужно создать объект Kingdom3 и передать его в addPeasants:
    val myKingdom = Kingdom() // Создаем объект Kingdom

    addPeasants(myKingdom) // Вызывая функцию addPeasants в main мы передаем ей переменную myKingdom,
    //которая представляет объект класса Kingdom.

    println(kingdom.rullingKingdom()) // // Выводим в консоль информацию о правителе

    // Устанавливаем объект myKingdom для сборщика налогов
    //(связываем каждого сборщика налогов с королевством)
    workerTaxCollector.kingdom = myKingdom
    builderTaxCollector.kingdom = myKingdom
    farmerTaxCollector.kingdom = myKingdom

    //Вызываем функцию collect() у каждой группы крестьян
    //(сбор налогов от каждой группы крестьян):
    workerTaxCollector.collect()
    builderTaxCollector.collect()
    farmerTaxCollector.collect()

    // Выводим количество золота в королевской казне
    println("Золото короля: " + myKingdom.treasury)

    // Объявляем переменную workerTax с типом Int. Присваиваем ей (при помощи =)
    // результат вызова функции taxCalculation (функция, которая, рассчитывает налог).
    // workerTaxCollector3 - это объект (сборщик налогов для рабочих),
    // который содержит свойство .kingdom, которое содержит ссылку на объект Kingdom3.
    val workerTax = taxCalculation(workerTaxCollector.kingdom.peasants.filter {
            it.occupation == Occupation.WORKER }.size, 1)
    //.peasants - это свойство объекта Kingdom3 (список крестьян), к которому workerTaxCollector3.kingdom ссылается.
    // .filter { ... } - это метод, который фильтрует список крестьян.
    // { it.occupation == Occupation3.WORKER } - это лямбда-выражение, которое определяет условие фильтрации.
    // it: Это текущий элемент списка (крестьянин) во время итерации.
    //it.occupation: Это свойство крестьянина, которое определяет его профессию.
    //Occupation3.WORKER: Это константа, которая представляет профессию “рабочий”.
    //В результате выполнения .filter, мы получим новый список, который будет содержать только тех крестьян,
    // у которых профессия “рабочий”.
    // .size: Это свойство, которое возвращает количество элементов в списке
    // (в данном случае, количество рабочих). Для WORKER size = 1, для BUILDER и FARMER 2 и 3 соответственно.

    // Объявляем переменную builderTax с типом Int. Дальше смотри описание WORKER (выше)
    val builderTax = taxCalculation(builderTaxCollector.kingdom.peasants.filter {
        it.occupation == Occupation.BUILDER }.size, 2)

    // Объявляем переменную farmerTax с типом Int. Дальше смотри описание WORKER (выше)
    val farmerTax = taxCalculation(farmerTaxCollector.kingdom.peasants.filter {
        it.occupation == Occupation.FARMER }.size, 3)

    //Выводим в консоль количество денег для каждой группы крестьян
    println("Налоговая служба короля.")
    println("Рабочие: Собрано ${workerTax} золотых")
    println("Строители: Собрано ${builderTax} золотых")
    println("Фермеры: Собрано ${farmerTax} золотых")

    //Вызов функции .yourHighness()
    "Ваша популярность падает!".yourHighness()
    "На нас напали!".yourHighness()
    "Нужно больше золота!".yourHighness()

    //Вызываем наследниц короля
    addHeirs()

    println("Армия короля.")

    //Вызываем остальные методы addArchers addWarriors.
    addArchers()
    addWarriors()
}
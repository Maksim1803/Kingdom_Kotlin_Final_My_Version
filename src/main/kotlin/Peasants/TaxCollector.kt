package Peasants

import Kingdom

abstract class TaxCollector(var kingdom: Kingdom) : CollectTaxes {
    constructor() : this(Kingdom()) //конструктор создан автоматически идеей, вписал только Kingdom
}

// Сборщик налогов для рабочих
val workerTaxCollector = object : TaxCollector() { //Создается переменная с именем workerTaxCollector3
    //ей присваивается созданный анонимный объект object, который наследуется от класса TaxCollector3.
    override fun collect() { //Переопределяется метод collect() из класса TaxCollector.
        val taxGroup = kingdom.peasants.filter { it.occupation == Occupation.WORKER }
        // Создается переменная taxGroup типа List<Peasant3>(см. класс Kingdom3).
        //Из свойства peasants королевства kingdom фильтруются крестьяне с профессией WORKER.
        //kingdom.peasants — список крестьян в королевстве.
        //filter { ... } — метод фильтрации списка.
        //it.occupation == Occupation3.WORKER — условие фильтрации: крестьянин должен иметь профессию WORKER.
        kingdom.treasury += taxGroup.size //В казначейство королевства kingdom добавляется количество
        // крестьян в группе taxGroup.
        // kingdom.treasury — свойство казначейства королевства.
        // += — оператор прибавления значения.
        // taxGroup.size — количество элементов в списке taxGroup.
    }
}

// Сборщик налогов для строителей
// (см. описание выше, как для worker, только кол-во элементов в списке еще умножаем на 2)
val builderTaxCollector = object : TaxCollector() {
    override fun collect() {
        val taxGroup = kingdom.peasants.filter { it.occupation == Occupation.BUILDER }
        kingdom.treasury += taxGroup.size * 2
    }
}

// Сборщик налогов для фермеров
// (см. описание выше, как для worker, только кол-во элементов в списке еще умножаем на 3)
val farmerTaxCollector = object : TaxCollector() {
    override fun collect() {
        val taxGroup = kingdom.peasants.filter { it.occupation == Occupation.FARMER }
        kingdom.treasury += taxGroup.size * 3
    }
}

// Создание one line функции, которая будет считать, сколько каждый сборщик налогов собрал со своей группы:
fun taxCalculation(size: Int, multiplier: Int): Int = size * multiplier
// Разберем подробнее. Здесь у нас функция taxCalculation, где в скобках(size: Int, multiplier: Int): -
// это параметры функции. Оба параметра и size и multiplier являются Int, т.е. целочисленными.
// : Int: - сразу после скобок, указывает тип возвращаемого значения функции. У нас это целое число (Int).
// = size * multiplier - это тело функции. В нём происходит расчёт налога.
// Функция умножает size на multiplier и возвращает результат.



@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import ru.spbstu.wheels.toMutableMap
import java.io.File
import java.lang.IllegalArgumentException
import kotlin.math.*

// Урок 1: простые функции
// Максимальное количество баллов = 5
// Рекомендуемое количество баллов = 4

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main() {
    val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
    println("Root product: $x1x2")
}

/**
 * Тривиальная (3 балла).
 *
 * Задача имеет повышенную стоимость как первая в списке.
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = hours * 60 * 60 + minutes * 60 + seconds
/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    val a = sagenes * 48 * 4.445
    val b = arshins * 16 * 4.445
    val c = vershoks * 4.445
    return (a+b+c)/100

}

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    val sum = deg * 60 * 60 + min * 60 + sec
    return sum / 206265.0

}



/**
 * Тривиальная (1 балл)
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = sqrt(sqr(x2-x1)+ sqr(y2-y1))


/**
 * Простая (2 балла)
 *
 * Пользователь задает целое число, больше или равно 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    val a = number % 1000
    return a / 100

}


/**
 * Простая (2 балла)
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int =
    (hoursArrive * 60 + minutesArrive) - (hoursDepart * 60 + minutesDepart)


/**
 * Простая (2 балла)
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double =
    initial * (percent/100.0 + 1.0) * (percent/100.0 + 1.0) * (percent/100.0 + 1.0)


/**
 * Простая (2 балла)
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    val c = number % 10
    val n2 = number / 10
    val b = n2 % 10
    val a = n2 / 10
    println('a' + 1)
    return c * 100 + b * 10 + a

}

//fun myFun(table: Map<String,Int>,taxes : String): Collection<Any>{
//    if (!(taxes matches Regex("""(([А-я\s]*[А-я]+\s)\-\s([А-я]+\s[А-я]*)\s\-\s\d+"""))){
//        throw IllegalArgumentException()
//    }
//    val taxeslist = taxes.split(Regex("""\n"""))
//    for (i in 0 until taxeslist.size){
//        val list = taxeslist[i].split(" - ")
//        val result = mutableListOf<Pair<String, Int>>()
//        for ((key,value) in table){
//
//        }
//    }
//}
//fun myfun(taxes: String, money: Int): Any {
////    val str = taxes.split("y.e. - ")
//    var result = 0
//    var count = money
//    var previous = 0
//    if (Regex("""(\d+\sy.e. - \d+%; )+else - \d+%""").matches(taxes)){
//        var lastpercent = taxes.takeLast(3)
//        lastpercent = lastpercent.replace("%","")
//        for (i in taxes.split("; ")){
//            var str = i.replace("%","")
//            val (sum, percent) = str.split(" y.e. - ")
//            if (count > 0){
//                if (sum == "else"){
//                    result += (money - previous) * (lastpercent.toInt() / 100)
//                } else {
////                    println(sum)
////                    println(percent)
////                    println(result)
////                    println(previous)
//                    println(sum.toInt())
//                    println(percent.toInt())
//                    println(sum.toInt() * (percent.toInt() / 100))
//                    result += sum.toInt() * (percent.toInt() / 100)
//                    count -= (sum.toInt() - previous)
//                    previous = sum.toInt()
//                }
//            }
//        }
//    } else {
//        throw IllegalArgumentException("")
//    }
//    return result
//}
fun myFun(inputName: String, range: String): Double {
    var (x, y) = range.split("-")
    println(x)
    println(y)
    var sort = '%'
    var x1 = x[0]
    var y1 = x[1]
    var x2 = y[0]
    var y2 = y[1]
    if (x1 > x2) {
        sort = x2
        x2 = x1
        x1 = sort
    }
    if (y1 > y2) {
        sort = y2
        y2 = x1
        x1 = sort
    }
    var count = 0
    var res = mutableListOf<Double>()
    for (line in inputName.split("\n")) {
        count++
        var part = line.split(", ")
        for (i in part.indices){
            if (('A'.toInt() + i) in x1.toInt()..x2.toInt() && count in y1.toString().toInt()..y2.toString().toInt()){
                res.add(part[i].toDouble())
            }
        }
    }
    println(res)
    return res.average()
}


fun FormulaOne(inputName: String): MutableMap<String, Int> {
    var list = mutableListOf<String>()
    var result = mutableMapOf<String, Int>()
    for (line in inputName.split("\n")){
        if (line matches Regex("""[А-я]\.\s[А-я\s\-]+\,\s[А-я\s]+\,\s[0-9]+""")){
            list += line
        }
    }
    for (i in 0 until list.size){
        var(name, team, score) = list[i].split(", ")
        if (result.containsKey(team)) {
            result.put(team, result.get(team)!! + score.toInt());
        } else {
            result.put(team, score.toInt());
        }
    }
//
    return result.entries.sortedBy { it.value }.reversed().toMutableMap()
}
fun foo(inputName: String, src: String, dst: String): String{

    var result = ""
    for (line in File(inputName).readLines()){
        println(line)
        if (line.contains(src) && line.contains(dst)){
            var spacecount = 0
            for (i in line.indices){
                result += line[i]
                println(result)
                if (line[i + 1] == ' '){
                    spacecount += 1
                }
                println(spacecount)
                if (spacecount == 2){
                    return result
                }
            }
        }
    }
    return result
}
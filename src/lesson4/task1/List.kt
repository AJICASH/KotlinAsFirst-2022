@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.*
import lesson3.task1.digitNumber

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>) = sqrt(v.map { it * it }.sum())
// {
//    var res = 0.0
//    for (i in 0..v.size - 1){
//        res += v[i] * v[i]
//    }
//    return sqrt(res)
//}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    return if (list.size > 0.0) {
        list.sum() / list.size
    } else 0.0
}

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var sr = mean(list)
    for (i in 0..list.size - 1) {
        list[i] -= sr
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = a.mapIndexed { index, i -> i * b[index] }.sum()
//    var c = 0
//    if (a.size == 0 || b.size == 0){
//        c = 0
//    } else {
//        for (i in 0..min(a.size - 1 , b.size - 1)){
//         c += a[i] * b[i]
//        }
//    }
//    return c
//}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = p.mapIndexed { index, i -> i * x.toDouble().pow(index).toInt() }.sum()
//    var res = 0
//    for (i in 0..p.size - 1){
//        res += p[i] * x.toFloat().pow(i).toInt()
//    }
//    return res
//}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    for (i in 1..list.size - 1) {
        list[i] += list[i - 1]
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var n2 = n
    var i = 2
    val result = mutableListOf<Int>()
    while (n2 > 1) {
        while (n2 % i == 0) {
            result.add(i)
            n2 /= i
        }
        i += 1
    }
    return result.sorted()
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var n2 = n
    val list = mutableListOf<Int>()
    if (n == 0){
        list.add(0)
    } else {
        while (n2 > 0) {
            list.add(n2 % base)
            n2 /= base
        }
    }

    return list.reversed()
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    val list = convert(n, base) as MutableList<Int>
    var result = ""
    if (n == 0) {
        result = "0"
    } else {
        for (i in 0 until list.size) {
            if (list[i] >= 10) {
                var count = 9
                for (j in 'a'..'z') {
                    count++
                    if (list[i] == count) {
                        result += j
                    }
                }
            } else {
                result += list[i].toString()
                println(result)
            }
        }
    }
    return result
}


/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int =
    digits.reversed().mapIndexed { index, i -> i * base.toDouble().pow(index).toInt() }.sum()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var res = ""
    val rom = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val arab = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    var num = n
    for (i in 0 until 13) {
        while (num >= arab[i]) {
            res += rom[i]
            num -= arab[i]
        }
    }
    return res
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */


fun firsttrio(n: Int): String {
    val one = listOf("", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val ruina = listOf(
        "одиннадцать",
        "двенадцать",
        "тринадцать",
        "четырнадцать",
        "пятнадцать",
        "шестнадцать",
        "семнадцать",
        "восемнадцать",
        "девятнадцать"
    )
    val dozens = listOf(
        "",
        "десять",
        "двадцать",
        "тридцать",
        "сорок",
        "пятьдесят",
        "шестьдесят",
        "семьдесят",
        "восемьдесят",
        "девяносто"
    )
    val hundreds =
        listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    var number = n
    var numberthree = n
    var res = ""
    var i = 0
    if (number % 100 < 20 && number % 100 > 10) {
        res = ruina[(number % 10) - 1]
        number /= 100
        if (n < 100){
             res += " тысяч"
        }else{
            res = hundreds[number] + " " + res + " тысяч"
        }
        println(res)
        println("v pervom")

    } else {
        println(res)
        while (number > 0) {
            println(res)

            i++
            if (i % 3 == 1) {
                if (number % 10 == 0) {
                    res = one[(number % 10)] + res
                } else {
                    res = one[(number % 10)] + " " + res + when (number % 10) {
                        1 -> "тысяча"
                        2, 3, 4 -> "тысячи"
                        0, 5, 6, 7, 8, 9 -> "тысяч"
                        else -> ""
                    }
                }
            } else if (i % 3 == 2) {
                if (number % 10 == 0) {
                    res = dozens[(number % 10)] + res
                } else {
                    if (n % 10 == 0) {
                        res = dozens[(number % 10)] + " " + res + "тысяч"
                    } else {
                        res = dozens[(number % 10)] + " " + res
                    }
                }
            } else if (i % 3 == 0) {
                res = hundreds[(number % 10)] + " " + res
            }
            number /= 10
        }
        println(res)
        println("v dva")
    }
    if (numberthree % 100 == 0) {
        res += "тысяч"
        println(res)
        println("v tri")
    }
//    if (digitNumber(n) == 2) {
//        res = res.substring(1)
//    }
    return res
}

fun secondtrio(n: Int): String {
    val one = listOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val ruina = listOf(
        "одиннадцать",
        "двенадцать",
        "тринадцать",
        "четырнадцать",
        "пятнадцать",
        "шестнадцать",
        "семнадцать",
        "восемнадцать",
        "девятнадцать"
    )
    val dozens = listOf(
        "",
        "десять",
        "двадцать",
        "тридцать",
        "сорок",
        "пятьдесят",
        "шестьдесят",
        "семьдесят",
        "восемьдесят",
        "девяносто"
    )
    val hundreds =
        listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    var number = n
    var res = ""
    var i = 0
    if (number % 100 < 20 && number % 100 > 10) {
        res = ruina[(number % 10) - 1]
        number /= 100
        if (n < 100){
            res += " "
        } else{
            res = hundreds[number] + " " + res + " "
        }

        println(res)
        println("v pervom")

    } else {
        println(res)
        while (number > 0) {
            println(res)

            i++
            if (i % 3 == 1) {
                if (number % 10 == 0) {
                    res = one[(number % 10)] + res
                } else {
                    res = one[(number % 10)] + " " + res
                }
            } else if (i % 3 == 2) {
                if (number % 10 == 0) {
                    res = dozens[(number % 10)] + res
                } else {
                    res = dozens[(number % 10)] + " " + res
                }
            } else if (i % 3 == 0) {
                res = hundreds[(number % 10)] + " " + res
            }
            number /= 10
        }
        println(res)
        println("v dva")
    }
//    if (digitNumber(n) == 2) {
//        res = res.substring(1)
//    }
    return res.dropLast(1)

}

fun russian(n: Int): String {
    if (digitNumber(n) >= 4){
        var second = n % 1000
        var first = n / 1000
        if (second == 0){
            return firsttrio(first)
        } else{
            return firsttrio(first) + " " + secondtrio(second)
        }

    } else{
        return secondtrio(n)
    }
//    val one = listOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать")
//    val dozens = listOf("", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
//    val hundreds = listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
//    val thousands = listOf("одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч")
//    var number = n
//    var res = ""
//    var i = 0
//    while (number > 0){
//        i++
//        if (i == 4){
//            res = thousands[(number % 10) - 1] + " "  + res
//        } else {
//            if (i % 3 == 1){
//                if (number % 10 == 0){
//                    res = one[(number % 10)] + res
//                }else{
//                res = one[(number % 10)] + " "  + res
//                }
//            } else if (i % 3 == 2){
//                if (number % 10 == 0){
//                    res = dozens[(number % 10)] + res
//                }else{
//                    res = dozens[(number % 10)] + " "  + res
//                }
//            } else if (i % 3 == 0){
//                if (number % 10 == 0){
//                    res = hundreds[(number % 10)] + res
//                }else{
//                    res = hundreds[(number % 10)] + " "  + res
//                }
//            }
//        }
//        number /= 10
//
//    }
//    return res.dropLast(1)

}
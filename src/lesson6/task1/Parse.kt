@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

import ru.spbstu.wheels.NullableMonad.filter

// Урок 6: разбор строк, исключения
// Максимальное количество баллов = 13
// Рекомендуемое количество баллов = 11
// Вместе с предыдущими уроками (пять лучших, 2-6) = 40/54

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}


/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
fun dateStrToDigit(str: String): String {
    val month = listOf("", "января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря")
    var list = str.split(" ")
    var res = ""
    var checkyear = false
    println(list)
    println(list.size)
    if (list.size == 3){
        if (list[2].toInt() % 4 == 0 && list[2].toInt() % 100 != 0 || list[2].toInt() % 400 == 0) {
                checkyear = true
        }
    } else{
        res = ""
    }
    if ((list.size != 3) || (month.indexOf(list[1]) == -1) || (checkyear == false && list[0].toInt() > 28 && month.indexOf(list[1]) == 2) || list[0].toInt() > 31 || list[0].toInt() < 1){
        res = ""
    }else {
        res = String.format("%02d.%02d.%d", list[0].toInt(),month.indexOf(list[1]),list[2].toInt())
    }
    println(res)
    return res
}

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String {
    val month = listOf("", "января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря")
    if (!(digital matches Regex("""\d\d\.\d\d\.\d+"""))){
        return ""
    }
    var list = digital.split(".")
//    println("07".toInt())
    var res = ""
    var checkyear = false
    if (list.size == 3){
        if (list[2].toInt() % 4 == 0 && list[2].toInt() % 100 != 0 || list[2].toInt() % 400 == 0) {
            checkyear = true
        }
    } else{
        res = ""
    }
    if ((list.size != 3) || list[1].toInt() > 12 || list[1].toInt() < 1 || (checkyear == false && list[0].toInt() > 28 && list[1].toInt() == 2) || list[0].toInt() > 31 || list[0].toInt() < 1 ){
        res = ""
    }else {
        res = String.format("%d ${month[list[1].toInt()]} %d", list[0].toInt(),list[2].toInt())
    }
    println(res)
    return res

}

/**
 * Средняя (4 балла)
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String {
    var mask = """(\+\d+)?\s*(\(?[\s\-\d]+\)?)?[\s\-\d]*""".toRegex()
    var result = ""
    if (phone matches mask){
        for (ch in 0..phone.length - 1){
            println(phone[ch])
            if (phone[ch].toString() == "+" || phone[ch].toString() matches Regex("""\d""")){
                result += phone[ch]
            }
        }
    } else return ""
    return result
}

/**
 * Средняя (5 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    var list = jumps.split(" ")
    println(list)
    var reslist = mutableListOf<Int>()
    for (i in 0 until list.size){
        if (list[i] matches Regex("""\d+""") || list[i] matches Regex("""\%""") || list[i] matches Regex("""\-""")){
            if (list[i] matches Regex("""\d+""")){
                reslist += list[i].toInt()
            }
        }else return -1
    }
    println(reslist)
    return if (reslist.size == 0){
        -1
    }else reslist.max()

}

/**
 * Сложная (6 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int {
//    var list = jumps.split(" ")
//    var reslist = mutableListOf<Pair<Int, String>>()
//    var result = mutableListOf<Int>()
//    for (i in list.indices){
//        if (i % 2 == 0){
//            reslist[i].first == list[i].toInt()
//        } else{
//            reslist[i].second == list[i]
//        }
//        println(reslist[i])
//    }
//    for (i in 0 until list.size){
//        if (list[i] matches Regex("""\d+""") || list[i] matches Regex("""\%""") || list[i] matches Regex("""\-""")){
//            for ((key, value) in reslist){
//                if (value == "+"){
//                    result += key
//                }
//            }
//        }else return -1
//    }
//
//    println(reslist)
//    println(result)
//    return if (result.size == 0){
//        -1
//    }else result.max()
    TODO()
}

/**
 * Сложная (6 баллов)
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    var str = expression.replace(Regex("""\s+"""), " " )
    var res = 0
    if (!(str matches Regex("""\d+(\s[+-]\s\d+)*"""))){
        throw IllegalArgumentException()
    } else{
        var list = str.split(" ")
        res = list[0].toInt()
        for (i in 0 until list.size){
            if (list[i] == "+"){
                res += list[i + 1].toInt()
            } else if (list[i] == "-"){
                res -= list[i + 1].toInt()
            }
        }
    }
    println(res)
    return res
}

/**
 * Сложная (6 баллов)
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    //"Яблоко упало на ветку с ветки оно упало на на землю"
    var list = str.toLowerCase().split(" ")
    var length = list[0].length
    for (i in 1 until list.size){
//        println(list[i])
//        println(length)
        length += 1 + list[i].length
//        println(length)
        if (list[i] == list[i - 1]){
            return length - 1 - 2 * list[i - 1].length
        }
    }
    return -1
}

/**
 * Сложная (6 баллов)
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше нуля либо равны нулю.
 */
fun mostExpensive(description: String): String {
    var str = description.replace("; ", " " )
    var list = str.split(" ")
    var reslist = mutableMapOf<String, Double>()
    var res = ""
    var maxi = -1
    println(list)
    if (str.isEmpty()){
        return ""
    } else{
        for (i in 0 until list.size step 2){
            reslist += (Pair(list[i],list[i + 1].toDouble()))
        }
    }
    println(reslist)
    for ((key,value) in reslist){
        if (value > maxi){
            maxi = value.toInt()
            res = key
        }

    }
    return res
//        if (list.isEmpty()){
//            return ""
//        } else {
//            if (i % 2 == 1){
//                reslist += list[i].toInt()
//            }
//        }
//    }
}

/**
 * Сложная (6 баллов)
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int {
//    val rom = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
//    val arab = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    TODO()
}

/**
 * Очень сложная (7 баллов)
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()

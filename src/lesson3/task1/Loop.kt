@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.sqrt
import kotlin.math.*
import kotlin.math.pow

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = n
    if (number == 0) return 1
    while (number > 0) {
        number /= 10
        count++
    }
    return count
}


/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fibres = 0
    var fib1 = 1
    var fib2 = 1
    for (i in 3..n) {
        fibres = fib1 + fib2
        fib1 = fib2
        fib2 = fibres
    }
    return if (n == 1 || n == 2) {
        1
    } else {
        fibres
    }
}


//    when (n) {
//        1, 2 -> 1
//        else -> fib(n - 2) + fib(n - 1)
//    }


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    val num = n
    var min = 100000
    for (i in 2..num) {
        if (num % i == 0) {
            min = i
            break
        }
    }
    return min
}


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)
//    val num = n
//    var maxi = -2
//    for (i in 1..num - 1) {
//        if (num % i == 0) {
//            if (maxi <= i) {
//                maxi = i
//            }
//        }
//    }
//    return maxi



/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var x1 = x
    var count = 0
    while (x1 != 1){
        if (x1 % 2 == 0){
            x1 = x1 / 2
        } else x1 = 3 * x1 + 1
        count++
    }
    return count

}


/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
//    for (i in min(m,n)..max(m,n) * max(m,n)){
//         if ((i % m == 0) && (i % n == 0)){
//            return i
//        }
//    }
//    return 1
//    var i = max(m, n)
//    return if (m != n) {
//        while (i % m != i % n ) {
//            i++
//        }
//        i
//    } else m
    var x = m
    var y = n
    var s = 0
    while (x != 0 && y != 0){
        if (x > y){
            x %= y
        } else y %= x
    }
    s = x + y
    return m * n / s
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
//    var m1 = m
//    var n1 = n
//    var nod = 1
//    while (m1 != n1){
//        if (m1 > n1){
//             m1 = m1 - n1
//        } else n1 = n1 - m1
//        nod = m1
//    }
//    return if (nod == 1) {
//        true
//    } else false
    var x = m
    var y = n
    var s = 0
    while (x != 0 && y != 0){
        if (x > y){
            x %= y
        } else y %= x
    }
    return (x + y) == 1

}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var n1 = n
    var res = 0
    var digit = 0
//    while (n1 > 0){
//        n1 = n1 / 10
//        count++
//    }
//    while (n2 > 0){
//        cifra = n2 % 10
//        hod = 10.toFloat().pow(count - 1).toInt() * cifra
//        n2 = n2 / 10
//        count--
//        res += hod
//    }
//    return res
    while (n1 > 0){
        digit = n1 % 10
        res = res * 10 + digit
        n1 /= 10
    }
    return res
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = n == revert(n)
//    val a = n
//    return if (revert(n) == a){
//        true
//    } else false


/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
//    var n1 = n
//    var a0 = 0
//    var a1 = 0
//    var a2 = 0
//    var a3 = 0
//    var a4 = 0
//    var a5 = 0
//    var a6 = 0
//    var a7 = 0
//    var a8 = 0
//    var a9 = 0
//    while (n1 > 0){
//        if (n1 % 10 == 0){
//            a0 = 1
//        } else if (n1 % 10 == 1){
//            a1 = 1
//        }else if (n1 % 10 == 2){
//            a2 = 1
//        }else if (n1 % 10 == 3){
//            a3 = 1
//        }else if (n1 % 10 == 4){
//            a4 = 1
//        }else if (n1 % 10 == 5){
//            a5 = 1
//        }else if (n1 % 10 == 6){
//            a6 = 1
//        }else if (n1 % 10 == 7){
//            a7 = 1
//        }else if (n1 % 10 == 8){
//            a8 = 1
//        }else if (n1 % 10 == 9){
//            a9 = 1
//            }
//        n1 /= 10
//        }
//    return if (a0 + a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 > 1){
//        true
//    } else false
    var k = n / 10
    val c = n % 10
    while (k > 0){
       if (k % 10 == c){
           k /= 10
       } else return true
    }
    return false
}
/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
//    var count = 0
//    var cifraa = 0
//    var res = 0
//    var ii = 0
//    for (i in 1..1000){
//        ii = revert(i*i)
//
//        while (ii > 0){
//            cifraa = ii % 10
//            println(cifraa)
//            ii /= 10
//            count++
//            if (count == n){
//                res = cifraa
//            }
//        }
//    }
//    return res
    var numbersqr = 0
    var numbersqr2 = 0
    var res = 0
    var nomer = 0
    var minus = 0
    var counter = 0
    var result = 0
    for (i in 1..n){
        numbersqr = i * i
        nomer = digitNumber(numbersqr)
        res += nomer
        if (n <= res) {
            minus = res - n
            numbersqr2 = i * i
            counter = 0
            while (numbersqr2 != 0){
                if (counter == minus){
                    result = numbersqr2 % 10
                }
                numbersqr2 /= 10
                counter++
            }
        }
    }


    return result
}

/**
 * Сложная (5 баллов)
 *fvf
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
//    var count = 0
//    var cifraa = 0
//    var res = 0
//    var fibi = 0
//    for (i in 1..1000){
//        fibi = fib(i)
//
//        while (ii > 0){
//            cifraa = ii % 10
//            println(cifraa)
//            ii /= 10
//            count++
//            if (count == n){
//                res = cifraa
//            }
//        }
//    }
//    return res
    var numbersqr = 0
    var numbersqr2 = 0
    var res = 0
    var nomer = 0
    var minus = 0
    var counter = 0
    var result = 0
    for (i in 1..n){
        numbersqr = fib(i)
        nomer = 0
        nomer = digitNumber(numbersqr)
        res += nomer
        if (n <= res) {
            minus = res - n
            numbersqr2 = fib(i)
            counter = 0
            while (numbersqr2 != 0){
                if (counter == minus){
                    result = numbersqr2 % 10
                }
                numbersqr2 /= 10
                counter++
            }
        }
    }


    return result
}

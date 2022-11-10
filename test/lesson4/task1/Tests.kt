package lesson4.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun sqRoots() {
        assertEquals(listOf<Double>(), sqRoots(-1.0))
        assertArrayEquals(listOf(0.0).toDoubleArray(), sqRoots(0.0).toDoubleArray(), 1e-5)
        assertArrayEquals(listOf(-5.0, 5.0).toDoubleArray(), sqRoots(25.0).toDoubleArray(), 1e-5)
    }

    @Test
    @Tag("Example")
    fun biRoots() {
        assertEquals(listOf<Double>(), biRoots(0.0, 0.0, 1.0))
        assertEquals(listOf<Double>(), biRoots(0.0, 1.0, 2.0))
        assertArrayEquals(
            listOf(-2.0, 2.0).toDoubleArray(),
            biRoots(0.0, 1.0, -4.0).toDoubleArray(),
            1e-5
        )
        assertEquals(listOf<Double>(), biRoots(1.0, -2.0, 4.0))
        assertArrayEquals(
            listOf(-1.0, 1.0).toDoubleArray(),
            biRoots(1.0, -2.0, 1.0).toDoubleArray(),
            1e-5
        )
        assertEquals(listOf<Double>(), biRoots(1.0, 3.0, 2.0))
        assertArrayEquals(
            listOf(-2.0, -1.0, 1.0, 2.0).toDoubleArray(),
            biRoots(1.0, -5.0, 4.0).sorted().toDoubleArray(),
            1e-5
        )
    }

    @Test
    @Tag("Example")
    fun negativeList() {
        assertEquals(listOf<Int>(), negativeList(listOf(1, 2, 3)))
        assertEquals(listOf(-1, -5), negativeList(listOf(-1, 2, 4, -5)))
    }

    @Test
    @Tag("Example")
    fun invertPositives() {
        val list1 = mutableListOf(1, 2, 3)
        invertPositives(list1)
        assertEquals(listOf(-1, -2, -3), list1)
        val list2 = mutableListOf(-1, 2, 4, -5)
        invertPositives(list2)
        assertEquals(listOf(-1, -2, -4, -5), list2)
    }

    @Test
    @Tag("Example")
    fun squares() {
        assertEquals(listOf(0), squares(listOf(0)))
        assertEquals(listOf(1, 4, 9), squares(listOf(1, 2, -3)))
    }

    @Test
    @Tag("Example")
    fun squaresVararg() {
        assertArrayEquals(arrayOf(0), squares(0))
        assertArrayEquals(arrayOf(1, 4, 9), squares(1, 2, -3))
    }

    @Test
    @Tag("Example")
    fun isPalindrome() {
        assertFalse(isPalindrome("Барабан"))
        assertTrue(isPalindrome("А роза упала на лапу Азора"))
        assertTrue(isPalindrome("Шалаш"))
    }

    @Test
    @Tag("Example")
    fun buildSumExample() {
        assertEquals("42 = 42", buildSumExample(listOf(42)))
        assertEquals("3 + 6 + 5 + 4 + 9 = 27", buildSumExample(listOf(3, 6, 5, 4, 9)))
    }

    @Test
    @Tag("2")
    fun abs() {
        assertEquals(0.0, abs(listOf()), 1e-5)
        assertEquals(3.0, abs(listOf(3.0)), 1e-5)
        assertEquals(5.0, abs(listOf(3.0, -4.0)), 1e-5)
        assertEquals(8.774964, abs(listOf(4.0, -5.0, 6.0)), 1e-5)
    }

    @Test
    @Tag("2")
    fun mean() {
        assertEquals(0.0, mean(listOf()), 1e-5)
        assertEquals(1.0, mean(listOf(1.0)), 1e-5)
        assertEquals(2.0, mean(listOf(3.0, 1.0, 2.0)), 1e-5)
        assertEquals(3.0, mean(listOf(0.0, 2.0, 7.0, 8.0, -2.0)), 1e-5)
    }

    @Test
    @Tag("3")
    fun center() {
        assertEquals(listOf<Double>(), center(mutableListOf()))
        assertArrayEquals(
            listOf(0.0).toDoubleArray(),
            center(mutableListOf(3.14)).toDoubleArray(),
            1e-5
        )
        assertArrayEquals(
            listOf(1.0, -1.0, 0.0).toDoubleArray(),
            center(mutableListOf(3.0, 1.0, 2.0)).toDoubleArray(),
            1e-5
        )
        assertArrayEquals(
            listOf(-3.0, -1.0, 4.0, 5.0, -5.0).toDoubleArray(),
            center(mutableListOf(0.0, 2.0, 7.0, 8.0, -2.0)).toDoubleArray(),
            1e-5
        )
        val toMutate = mutableListOf(-3.0, -1.0, 4.0, 5.0, -5.0)
        assertTrue(toMutate === center(toMutate)) { "You should mutate an input list, not create a copy" }
    }

    @Test
    @Tag("3")
    fun times() {
        assertEquals(0, times(listOf(), listOf()))
        assertEquals(-5, times(listOf(1, -4), listOf(3, 2)))
        assertEquals(-19, times(listOf(-1, 2, -3), listOf(3, -2, 4)))
    }

    @Test
    @Tag("3")
    fun polynom() {
        assertEquals(0, polynom(listOf(), 1000))
        assertEquals(42, polynom(listOf(42), -1000))
        assertEquals(13, polynom(listOf(3, 2), 5))
        assertEquals(0, polynom(listOf(2, -3, 1), 1))
        assertEquals(45, polynom(listOf(-7, 6, 4, -4, 1), -2))
    }

    @Test
    @Tag("3")
    fun accumulate() {
        assertEquals(listOf<Double>(), accumulate(arrayListOf()))
        assertArrayEquals(
            listOf(3).toIntArray(),
            accumulate(arrayListOf(3)).toIntArray()
        )
        assertArrayEquals(
            listOf(1, 3, 6, 10).toIntArray(),
            accumulate(arrayListOf(1, 2, 3, 4)).toIntArray()
        )
        val toMutate = mutableListOf(-3, -1, 4, 5, -5)
        assertTrue(toMutate === accumulate(toMutate)) { "You should mutate an input list, not create a copy" }
    }

    @Test
    @Tag("3")
    fun factorize() {
        assertEquals(listOf(2), factorize(2))
        assertEquals(listOf(3, 5, 5), factorize(75))
        assertEquals(listOf(2, 3, 3, 19), factorize(342))
    }

    @Test
    @Tag("4")
    fun factorizeToString() {
        assertEquals("2", factorizeToString(2))
        assertEquals("3*5*5", factorizeToString(75))
        assertEquals("2*3*3*19", factorizeToString(342))
        assertEquals("7*7*31*31*151*151", factorizeToString(1073676289))
        assertEquals("1073676287", factorizeToString(1073676287))
        assertEquals(Int.MAX_VALUE.toString(), factorizeToString(Int.MAX_VALUE))
    }

    @Test
    @Tag("3")
    fun convert() {
        assertEquals(listOf(1), convert(1, 2))
        assertEquals(listOf(1, 2, 1, 0), convert(100, 4))
        assertEquals(listOf(1, 3, 12), convert(250, 14))
        assertEquals(listOf(2, 14, 12), convert(1000, 19))
        assertEquals(listOf(0), convert(0, 2))
    }

    @Test
    @Tag("4")
    fun convertToString() {
        assertEquals("1", convertToString(1, 2))
        assertEquals("1210", convertToString(100, 4))
        assertEquals("13c", convertToString(250, 14))
        assertEquals("2ec", convertToString(1000, 19))
        assertEquals("z", convertToString(35, 36))
        assertEquals("a02220281", convertToString(Int.MAX_VALUE, 11))
        assertEquals("0" , convertToString(0, 2))

    }

    @Test
    @Tag("3")
    fun decimal() {
        assertEquals(1, decimal(listOf(1), 2))
        assertEquals(100, decimal(listOf(1, 2, 1, 0), 4))
        assertEquals(250, decimal(listOf(1, 3, 12), 14))
        assertEquals(1000, decimal(listOf(2, 14, 12), 19))
    }

    @Test
    @Tag("4")
    fun decimalFromString() {
        assertEquals(1, decimalFromString("1", 2))
        assertEquals(100, decimalFromString("1210", 4))
        assertEquals(250, decimalFromString("13c", 14))
        assertEquals(1000, decimalFromString("2ec", 19))
        assertEquals(35, decimalFromString("z", 36))
        assertEquals(Int.MAX_VALUE, decimalFromString("a02220281", 11))
    }

    @Test
    @Tag("5")
    fun roman() {
        assertEquals("I", roman(1))
        assertEquals("MMM", roman(3000))
        assertEquals("MCMLXXVIII", roman(1978))
        assertEquals("DCXCIV", roman(694))
        assertEquals("XLIX", roman(49))
        assertEquals("IV", roman(4))
    }
    @Test
    fun firsttrio() {
        assertEquals("триста семьдесят пять тысяч", firsttrio(375))
        assertEquals("шестьсот шесть тысяч", firsttrio(606))
        assertEquals("шестьсот тысяч", firsttrio(600))
        assertEquals("шестьсот шестьдесят две тысячи", firsttrio(662))
        assertEquals("шестьсот девятнадцать тысяч", firsttrio(619))
        assertEquals("шестьсот двадцать тысяч", firsttrio(620))
        assertEquals("пятьсот двенадцать тысяч", firsttrio(512))
        assertEquals("двенадцать тысяч", firsttrio(12))
        assertEquals("одна тысяча", firsttrio(1))
        assertEquals("три тысячи", firsttrio(3))
        assertEquals("двадцать две тысячи", firsttrio(22))




    }
    @Test
    fun secondtrio() {
        assertEquals("триста семьдесят пять", secondtrio(375))
        assertEquals("шестьсот шесть", secondtrio(606))
        assertEquals("шестьсот", secondtrio(600))
        assertEquals("шестьсот шестьдесят два", secondtrio(662))
        assertEquals("шестьсот девятнадцать", secondtrio(619))
        assertEquals("шестьсот двадцать", secondtrio(620))
        assertEquals("пятьсот двенадцать", secondtrio(512))
        assertEquals("двадцать два", secondtrio(22))
        assertEquals("двенадцать", secondtrio(12))
        assertEquals("один", secondtrio(1))
        assertEquals("три", secondtrio(3))

    }


        @Test
    @Tag("7")
    fun russian() {
        assertEquals("триста семьдесят пять", russian(375))
        assertEquals("двадцать две тысячи девятьсот шестьдесят четыре", russian(22964))
        assertEquals("сто девятнадцать тысяч пятьсот восемь", russian(119508))
        assertEquals("две тысячи три", russian(2003))
        assertEquals("двести тысяч два", russian(200002))
        assertEquals("девятьсот тысяч", russian(900000))
        assertEquals("двенадцать", russian(12))
    }
}
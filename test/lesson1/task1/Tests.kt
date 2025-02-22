package lesson1.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.math.PI

class Tests {
    @Test
    @Tag("Example")
    fun sqr() {
        assertEquals(0, sqr(0))
        assertEquals(4, sqr(2))
        assertEquals(9, sqr(-3))
    }

    @Test
    @Tag("Example")
    fun sqrDouble() {
        assertEquals(0.0, sqr(0.0), 1e-13)
        assertEquals(4.0, sqr(2.0), 1e-13)
        assertEquals(9.0, sqr(-3.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun discriminant() {
        assertEquals(0.0, discriminant(0.0, 0.0, 0.0), 1e-13)
        assertEquals(0.0, discriminant(1.0, -2.0, 1.0), 1e-13)
        assertEquals(1.0, discriminant(1.0, 3.0, 2.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun quadraticEquationRoot() {
        assertEquals(2.0, quadraticEquationRoot(1.0, -3.0, 2.0), 1e-13)
        assertEquals(1.0, quadraticEquationRoot(1.0, -2.0, 1.0), 1e-13)
        assertEquals(-3.0, quadraticEquationRoot(1.0, 6.0, 9.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun quadraticRootProduct() {
        assertEquals(1.0, quadraticRootProduct(1.0, -2.0, 1.0), 1e-13)
        assertEquals(9.0, quadraticRootProduct(1.0, 6.0, 9.0), 1e-13)
        assertEquals(2.0, quadraticRootProduct(1.0, 3.0, 2.0), 1e-13)
    }

    @Test
    @Tag("3")
    fun seconds() {
        assertEquals(30035, seconds(8, 20, 35))
        assertEquals(86400, seconds(24, 0, 0))
        assertEquals(13, seconds(0, 0, 13))
    }

    @Test
    @Tag("1")
    fun lengthInMeters() {
        assertEquals(18.98, lengthInMeters(8, 2, 11), 1e-2)
        assertEquals(2.13, lengthInMeters(1, 0, 0), 1e-2)
    }

    @Test
    @Tag("1")
    fun angleInRadian() {
        assertEquals(0.63256, angleInRadian(36, 14, 35), 1e-5)
        assertEquals(PI / 2.0, angleInRadian(90, 0, 0), 1e-5)
    }

    @Test
    @Tag("1")
    fun trackLength() {
        assertEquals(5.0, trackLength(3.0, 0.0, 0.0, 4.0), 1e-5)
        assertEquals(1.0, trackLength(0.0, 1.0, -1.0, 1.0), 1e-5)
        assertEquals(1.41, trackLength(1.0, 1.0, 2.0, 2.0), 1e-2)
    }

    @Test
    @Tag("2")
    fun thirdDigit() {
        assertEquals(8, thirdDigit(3801))
        assertEquals(1, thirdDigit(100))
        assertEquals(0, thirdDigit(1000))
    }

    @Test
    @Tag("2")
    fun travelMinutes() {
        assertEquals(216, travelMinutes(9, 25, 13, 1))
        assertEquals(1, travelMinutes(21, 59, 22, 0))
    }

    @Test
    @Tag("2")
    fun accountInThreeYears() {
        assertEquals(133.1, accountInThreeYears(100, 10), 1e-2)
        assertEquals(1.0, accountInThreeYears(1, 0), 1e-2)
        assertEquals(104.0, accountInThreeYears(13, 100), 1e-2)
    }

    @Test
    @Tag("2")
    fun numberRevert() {
        assertEquals(874, numberRevert(478))
        assertEquals(201, numberRevert(102))
    }

    @Test
    fun myFun() {
        assertEquals(
            2.73,
            myFun(
                """1.5, 2.67, 3.0, 1.4, 5.0
                    |5.2, 7.1, -4.8, 0.0
                    |1.4, 6.0, 2.5, -1.9""".trimMargin(),
                "C1-A3"
            )
        )
    }

    @Test
    fun FormulaOne() {
        assertEquals(
            mapOf(
                "Мерседес" to 20,
                "Феррари" to 11,
                "Ред Булл" to 9,
                "Макларен" to 9
            ),
            FormulaOne(
                """Гран-при Австралии:
                    |Л. Хэмилтон, Мерседес, 8
                    |В. Боттас, Мерседес, 6
                    |Л. Норрис, Макларен, 5
                    |Д. Риккардо, Макларен, 4
                    |Ш. Леклер, Феррари, 3
                    |С. Феттель, Феррари, 2
                    |М. Ферстапен, Ред Булл, 1
                    |
                    |Гран-при России:
                    |А. Албон, Ред Булл, 8
                    |Л. Хэмилтон, Мерседес, 5
                    |С. Феттель, Феррари, 4
                    |Ш. Леклер, Феррари, 2
                    |В. Боттас, Мерседес, 1""".trimMargin()
            )
        )
    }
    @Test
    fun foo() {
        assertEquals("трамвай 3",
            foo("input/foo_in1.txt", "Парк отдыха", "ул. Дворцовая"))
    }
}

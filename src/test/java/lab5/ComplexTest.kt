package lab5

import org.junit.Test

import org.junit.Assert.*

class ComplexTest {
    @Test
    fun `check re is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(5.0, complex.re(), 0.0)
    }

    @Test
    fun `check im is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(10.0, complex.im(), 0.0)
    }

    @Test
    fun `check getMagnitude is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(11.180339887498949, complex.getMagnitude(), 0.0)
    }

    @Test
    fun `check getArgument is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(1.1071487177940904, complex.getArgument(), 0.0)
    }

    @Test
    fun `check operator plus with Complex number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val complex2 = Complex(7.0, 6.0)
        val result = complex1 + complex2
        val resultRight = Complex(12.0, 16.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator plus with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 + 18.0
        val resultRight = Complex(23.0, 10.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator minus with Complex number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val complex2 = Complex(7.0, 6.0)
        val result = complex1 - complex2
        val resultRight = Complex(-2.0, 4.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator minus with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 - 25.0
        val resultRight = Complex(-20.0, 10.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator times with Complex number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val complex2 = Complex(7.0, 6.0)
        val result = complex1 * complex2
        val resultRight = Complex(-25.0, 100.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator times with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 * 2.0
        val resultRight = Complex(10.0, 20.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator unaryPlus is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = +complex1
        val resultRight = Complex(5.0, 10.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }

    @Test
    fun `check operator unaryMinus is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = -complex1
        val resultRight = Complex(-5.0, -10.0)
        assertEquals(resultRight.re(), result.re(), 0.0)
        assertEquals(resultRight.im(), result.im(), 0.0)
    }
}

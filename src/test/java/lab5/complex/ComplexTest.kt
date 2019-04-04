package lab5.complex

import lab5.complex.Complex.Companion.EPS
import org.junit.Test

import org.junit.Assert.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ComplexTest {
    @Test
    fun `check re is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(5.0, complex.re(), EPS)
    }

    @Test
    fun `check im is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(10.0, complex.im(), EPS)
    }

    @Test
    fun `check getMagnitude is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(11.180339887498949, complex.getMagnitude(), EPS)
    }

    @Test
    fun `check getMagnitude with zero is correct`() {
        val complex = Complex(0.0, 0.0)
        assertEquals(0.0, complex.getMagnitude(), EPS)
    }

    @Test
    fun `check getMagnitude with ones is zero is correct`() {
        val complex = Complex(0.0, 13.0)
        assertEquals(13.0, complex.getMagnitude(), EPS)
    }

    @Test
    fun `check getMagnitude with negative number is correct`() {
        val complex = Complex(-5.0, -2.0)
        assertEquals(5.385164807134504, complex.getMagnitude(), EPS)
    }

    @Test
    fun `check getMagnitude with ones is negative is correct`() {
        val complex = Complex(0.0, -13.0)
        assertEquals(13.0, complex.getMagnitude(), EPS)
    }

    @Test
    fun `check getArgument is correct`() {
        val complex = Complex(5.0, 10.0)
        assertEquals(1.1071487177940904, complex.getArgument(), EPS)
    }

    @Test
    fun `check getArgument with real is negative is correct`() {
        val complex = Complex(-5.0, 10.0)
        assertEquals(2.0344439357957027, complex.getArgument(), EPS)
    }

    @Test
    fun `check getArgument with image is negative is correct`() {
        val complex = Complex(5.0, -10.0)
        assertEquals(-1.1071487177940904, complex.getArgument(), EPS)
    }

    @Test
    fun `check getArgument with negative is correct`() {
        val complex = Complex(-5.0, -10.0)
        assertEquals(-2.0344439357957027, complex.getArgument(), EPS)
    }

    @Test
    fun `check getArgument with real is zero is correct`() {
        val complex = Complex(0.0, 10.0)
        assertEquals(1.5707963267948966, complex.getArgument(), EPS)
    }

    @Test
    fun `check getArgument with image is zero is correct`() {
        val complex = Complex(10.0, 0.0)
        assertEquals(0.0, complex.getArgument(), EPS)
    }

    @Test
    fun `check getArgument with zero is correct`() {
        val complex = Complex(0.0, 0.0)
        assertEquals(0.0, complex.getArgument(), EPS)
    }

    @Test
    fun `check operator plus with Complex number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val complex2 = Complex(7.0, 6.0)
        val result = complex1 + complex2
        val resultRight = Complex(12.0, 16.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator plus with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 + 18.0
        val resultRight = Complex(23.0, 10.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator minus with Complex number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val complex2 = Complex(7.0, 6.0)
        val result = complex1 - complex2
        val resultRight = Complex(-2.0, 4.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator minus with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 - 25.0
        val resultRight = Complex(-20.0, 10.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator times with Complex number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val complex2 = Complex(7.0, 6.0)
        val result = complex1 * complex2
        val resultRight = Complex(-25.0, 100.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator times with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 * 2.0
        val resultRight = Complex(10.0, 20.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator div with Complex number is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(4.0, 2.0)
        val result = complex1 / complex2
        val resultRight = Complex(5.0, 0.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator div with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = complex1 / 2.0
        val resultRight = Complex(2.5, 5.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator unaryPlus is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = +complex1
        val resultRight = Complex(5.0, 10.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator unaryMinus is correct`() {
        val complex1 = Complex(5.0, 10.0)
        val result = -complex1
        val resultRight = Complex(-5.0, -10.0)
        assertEquals(resultRight.re(), result.re(), EPS)
        assertEquals(resultRight.im(), result.im(), EPS)
    }

    @Test
    fun `check operator plusAssign with Complex number is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(4.0, 2.0)
        complex1 += complex2
        val resultRight = Complex(24.0, 12.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator plusAssign with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        complex1 += 2.0
        val resultRight = Complex(7.0, 10.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator minusAssign with Complex number is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(4.0, 2.0)
        complex1 -= complex2
        val resultRight = Complex(16.0, 8.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator minusAssign with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        complex1 -= 2.0
        val resultRight = Complex(3.0, 10.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator timesAssign with Complex number is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(4.0, 2.0)
        complex1 *= complex2
        val resultRight = Complex(60.0, 80.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator timesAssign with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        complex1 *= 2.0
        val resultRight = Complex(10.0, 20.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator divAssign with Complex number is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(4.0, 2.0)
        complex1 /= complex2
        val resultRight = Complex(5.0, 0.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator divAssign with Double number is correct`() {
        val complex1 = Complex(5.0, 10.0)
        complex1 /= 2.0
        val resultRight = Complex(2.5, 5.0)
        assertEquals(resultRight.re(), complex1.re(), EPS)
        assertEquals(resultRight.im(), complex1.im(), EPS)
    }

    @Test
    fun `check operator equals with Complex numbers is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(20.0, 10.0)
        assertTrue(complex1 == complex2)
        assertFalse(complex1 != complex2)
    }

    @Test
    fun `check operator not equals with Complex numbers is correct`() {
        val complex1 = Complex(20.0, 10.0)
        val complex2 = Complex(28.0, 14.0)
        assertTrue(complex1 != complex2)
        assertFalse(complex1 == complex2)
    }

    @Test
    fun `check operator equals with Complex and Double numbers is correct`() {
        val complex1 = Complex(20.0, 0.0)
        val number = 20.0
        assertTrue(complex1.equals(number))
        assertFalse(!complex1.equals(number))
    }

    @Test
    fun `check operator not equals with Complex and Double numbers is correct`() {
        val complex1 = Complex(2.0, 0.0)
        val number = 20.0
        assertTrue(!complex1.equals(number))
        assertFalse(complex1.equals(number))
    }

    private val myOut = ByteArrayOutputStream()
    @Test
    fun `check fun write with positive is correct`() {
        System.setOut(PrintStream(myOut))
        val complex = Complex(3.0, 4.0)
        System.out.write(complex)
        val right = "3.0+4.0i"
        assertEquals(right, myOut.toString())
    }

    @Test
    fun `check fun write with negative is correct`() {
        System.setOut(PrintStream(myOut))
        val complex = Complex(-3.0, -4.0)
        System.out.write(complex)
        val right = "-3.0-4.0i"
        assertEquals(right, myOut.toString())
    }

    @Test
    fun `check fun read with Complex positive is correct`() {
        val input = "3+4i"
        val `in` = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        val complex = Complex()
        `in`.read(complex)
        val right = Complex(3.0, 4.0)
        assertEquals(right, complex)
    }

    @Test
    fun `check fun read with Complex negative is correct`() {
        val input = "-3-4i"
        val `in` = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        val complex = Complex()
        `in`.read(complex)
        val right = Complex(-3.0, -4.0)
        assertEquals(right, complex)
    }

    @Test
    fun `check fun read with Double Complex positive is correct`() {
        val input = "3.3+4.4i"
        val `in` = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        val complex = Complex()
        `in`.read(complex)
        val right = Complex(3.3, 4.4)
        assertEquals(right, complex)
    }

    @Test
    fun `check fun read with Double Complex negative is correct`() {
        val input = "-3.3-4.4i"
        val `in` = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        val complex = Complex()
        `in`.read(complex)
        val right = Complex(-3.3, -4.4)
        assertEquals(right, complex)
    }

    @Test
    fun `check fun Double plus Complex is correct`() {
        val double = 2.0
        val complex = Complex(3.0, 6.0)
        val rightNumber = Complex(5.0, 6.0)
        val number = double + complex
        assertEquals(rightNumber.re(), number.re(), EPS)
        assertEquals(rightNumber.im(), number.im(), EPS)
    }

    @Test
    fun `check fun Double minus Complex is correct`() {
        val double = 2.0
        val complex = Complex(3.0, 6.0)
        val rightNumber = Complex(-1.0, 6.0)
        val number = double - complex
        assertEquals(rightNumber.re(), number.re(), EPS)
        assertEquals(rightNumber.im(), number.im(), EPS)
    }

    @Test
    fun `check fun Double times Complex is correct`() {
        val double = 2.0
        val complex = Complex(3.0, 6.0)
        val rightNumber = Complex(6.0, 6.0)
        val number = double * complex
        assertEquals(rightNumber.re(), number.re(), EPS)
        assertEquals(rightNumber.im(), number.im(), EPS)
    }

    @Test
    fun `check fun Double div Complex is correct`() {
        val double = 2.0
        val complex = Complex(2.0, 6.0)
        val rightNumber = Complex(1.0, 6.0)
        val number = double / complex
        assertEquals(rightNumber.re(), number.re(), EPS)
        assertEquals(rightNumber.im(), number.im(), EPS)
    }
}

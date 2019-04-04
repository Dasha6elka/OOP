package lab5

import org.apache.commons.lang3.math.NumberUtils
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class Complex constructor(private var real: Double = 0.0, private var image: Double = 0.0) {
    companion object {
        const val EPS = 10e-15
    }

    fun re(): Double = real

    fun im(): Double = image

    fun getMagnitude(): Double = Math.sqrt(Math.pow(real, 2.0) + Math.pow(image, 2.0))

    fun getArgument(): Double = Math.atan2(image, real)

    operator fun plus(number: Complex): Complex = Complex(real + number.re(), image + number.im())

    operator fun plus(number: Double): Complex = Complex(real + number, image)

    operator fun minus(number: Complex): Complex = Complex(real - number.re(), image - number.im())

    operator fun minus(number: Double): Complex = Complex(real - number, image)

    operator fun times(number: Complex): Complex {
        val factor1 = (real * number.re()) - (image * number.im())
        val factor2 = (real * number.im()) + (image * number.re())
        return Complex(factor1, factor2)
    }

    operator fun times(number: Double): Complex = this * Complex(number)

    operator fun div(number: Complex): Complex {
        val bottom = Math.pow(number.re(), 2.0) + Math.pow(number.im(), 2.0)
        val factor1 = ((real * number.re()) + (image * number.im())) / bottom
        val factor2 = ((image * number.re()) - (real * number.im())) / bottom
        return Complex(factor1, factor2)
    }

    operator fun div(number: Double): Complex = this / Complex(number)

    operator fun unaryPlus() = Complex(real, image)

    operator fun unaryMinus() = Complex(-real, -image)

    operator fun plusAssign(number: Complex) {
        val complex = this + number
        real = complex.re()
        image = complex.im()
    }

    operator fun plusAssign(number: Double) {
        this += Complex(number)
    }

    operator fun minusAssign(number: Complex) {
        val complex = this - number
        real = complex.re()
        image = complex.im()
    }

    operator fun minusAssign(number: Double) {
        this -= Complex(number)
    }

    operator fun timesAssign(number: Complex) {
        val complex = this * number
        real = complex.re()
        image = complex.im()
    }

    operator fun timesAssign(number: Double) {
        val complex = this * number
        real = complex.re()
        image = complex.im()
    }

    operator fun divAssign(number: Complex) {
        val complex = this / number
        real = complex.re()
        image = complex.im()
    }

    operator fun divAssign(number: Double) {
        val complex = this / number
        real = complex.re()
        image = complex.im()
    }

    override operator fun equals(other: Any?): Boolean {
        return when (other) {
            is Complex -> eq(real, other.re()) && eq(image, other.im())
            is Double -> {
                val complex = Complex(other)
                return eq(real, complex.re()) && eq(image, complex.im())
            }
            else -> return false
        }
    }

    private fun eq(left: Double, right: Double): Boolean {
        return Math.abs(left - right) < EPS
    }

    override fun hashCode(): Int {
        var result = real.hashCode()
        result = 31 * result + image.hashCode()
        return result
    }
}

operator fun Double.plus(number: Complex): Complex {
    return Complex(this + number.re(), number.im())
}

operator fun Double.minus(number: Complex): Complex {
    return Complex(this - number.re(), number.im())
}

operator fun Double.times(number: Complex): Complex {
    return Complex(this * number.re(), number.im())
}

operator fun Double.div(number: Complex): Complex {
    return Complex(this / number.re(), number.im())
}

fun OutputStream.write(complex: Complex) {
    val sign = if (complex.im() < 0) '-' else '+'
    val str = "${complex.re()}$sign${Math.abs(complex.im())}i"
    write(str.toByteArray())
}

fun InputStream.read(complex: Complex) {
    val plus = '+'.toInt()
    val minus = '-'.toInt()
    val suffix = 'i'.toInt()

    var input = read()
    val unary =
        if (input == minus) {
            input = read()
            '-'
        } else '+'

    var re = ""
    while (input != plus && input != minus) {
        re += input.toChar()
        input = read()
    }

    val sign = input.toChar()
    input = read()

    var im = ""
    while (input != suffix && input != -1) {
        im += input.toChar()
        input = read()
    }

    if (!NumberUtils.isCreatable(re)) {
        throw IOException("Something is wrong with real part!")
    }
    if (!NumberUtils.isCreatable(im)) {
        throw IOException("Something is wrong with image part!")
    }

    val real = re.toDouble()
    val image = im.toDouble()
    complex += Complex(if (unary == '-') -real else real, if (sign == '-') -image else image)
}

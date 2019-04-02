package lab5

class Complex constructor(private var real: Double = 0.0, private var image: Double = 0.0) {
    fun re(): Double {
        return real
    }

    fun im(): Double {
        return image
    }

    fun getMagnitude(): Double {
        return Math.sqrt(Math.pow(real, 2.0) + Math.pow(image, 2.0))
    }

    fun getArgument(): Double {
        return Math.atan(image/real)
    }

    operator fun plus(number: Complex): Complex {
        return Complex(real + number.re(), image + number.im())
    }

    operator fun plus(number: Double): Complex {
        return Complex(real + number, image)
    }

    operator fun minus(number: Complex): Complex {
        return Complex(real - number.re(), image - number.im())
    }

    operator fun minus(number: Double): Complex {
        return Complex(real - number, image)
    }

    operator fun times(number: Complex): Complex {
        val factor1 = (real * number.re()) - (image * number.im())
        val factor2 = (real * number.im()) + (image * number.re())
        return Complex(factor1, factor2)
    }

    operator fun times(number: Double): Complex {
        return Complex(real * number, image * number)
    }

    operator fun unaryPlus() = Complex(real, image)

    operator fun unaryMinus() = Complex(-real, -image)
}

import com.ddam40.kia.domain.Person

class HelloWorld {
    fun main(args: Array<String>) {
        println("Hello World")
        val p = Person("Jack")
        println(p.name)
    }
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    BLUE(0,255,0),
    GREEN(0,0,255);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getWarmth(color: Color) = when(color) {
    Color.BLUE -> "blue"
    Color.GREEN, Color.ORANGE -> "red"
    else -> "N/A"
}
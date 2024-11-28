fun main() {

    do {

        val inputX: String = getInputOrNull("შეიყვანეთ x ცვლადის მნიშვნელობა: ") ?: break
        val inputY: String = getInputOrNull("შეიყვანეთ y ცვლადის მნიშვნელობა: ") ?: break

        val x: Double = inputX.toDoubleOrZero()
        val y: Double = inputY.toDoubleOrZero()
        val z: Double = x / y

        val displayX: String = x.toDisplayFormat()
        val displayY: String = y.toDisplayFormat()
        val displayZ: String = z.toDisplayFormat()

        println("X($displayX) და Y($displayY) განაყოფი არის: $displayZ")
        val answer: String = getInputOrNull("გსურთ პროგრამის ხელახლა დაწყება <Y/N>? : ") ?: break
        if (answer.uppercase() != "Y") break

    } while (true)


}

fun Double.toDisplayFormat(): String = (if (this % 1 == 0.0) this.toInt() else this).toString()

fun String.toDoubleOrZero(): Double = this.filter { char -> char.isDigit() }.toDoubleOrNull() ?: 0.0

fun getInputOrNull(prompt: String): String? {
    print(prompt)
    return readlnOrNull()
}
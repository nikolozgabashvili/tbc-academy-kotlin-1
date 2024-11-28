fun main() {

    do {
        print("შეიყვანეთ x ცვლადის მნიშვნელობა: ")
        val inputX: String = readlnOrNull() ?: break
        print("შეიყვანეთ y ცვლადის მნიშვნელობა: ")
        val inputY: String = readlnOrNull() ?: break

        val x: Double = inputX.filter { char -> char.isDigit() }.toDoubleOrNull() ?: 0.0
        val y: Double = inputY.filter { char -> char.isDigit() }.toDoubleOrNull() ?: 0.0
        val z: Double = x / y

        val displayX: String = x.toDisplayFormat()
        val displayY: String = y.toDisplayFormat()
        val displayZ: String = z.toDisplayFormat()

        println("X($displayX) და Y($displayY) განაყოფი არის: $displayZ")
        print("გსურთ პროგრამის ხელახლა დაწყება <Y/N>? : ")
        val answer: String = readlnOrNull() ?: break
        if (answer.uppercase() != "Y") break

    } while (true)


}

fun Double.toDisplayFormat(): String = (if (this % 1 == 0.0) this.toInt() else this).toString()
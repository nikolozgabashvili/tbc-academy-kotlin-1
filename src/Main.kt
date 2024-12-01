fun main() {
    val calculator = MyCalculator()
    println(calculator.calculateGcd(0,10))
    startCalculatorApp(calculator)
}

fun startCalculatorApp(calculator: MyCalculator) {

    val input = readInputOrNull(
        """
        |
        | 1. calculate gcd
        | 2. calculate lcm
        | 3. calculate sum of even numbers
        | 4. check input 
        | 5. reverse number
        | 6. is input palindrome
        | 7. exit
        | 
    """.trimMargin()
    )
    val number = input?.toIntOrNull() ?: 7
    val response: Boolean? = when (number) {
        1 -> {
            calculateWithOperation(calculator = calculator, operation = OperationType.GCD)
        }

        2 -> {
            calculateWithOperation(calculator = calculator, operation = OperationType.LCM)
        }

        3 -> {
            sumEvenNumbers(calculator = calculator)
        }

        4 -> {
            checkInput(calculator = calculator)
        }

        5 -> {
            reverseText(calculator = calculator)
        }

        6 -> {
            isInputPalindrome(calculator = calculator)
        }

        else -> return

    }
    if (response == false) {
        println("please enter correct format")

    } else if (response == true) {
        val shouldPlay = readInputOrNull("\nplay again? Y/N ") ?: return
        if (shouldPlay.uppercase() == "Y")
            startCalculatorApp(calculator)
        else return
    }


}

fun isInputPalindrome(calculator: MyCalculator): Boolean? {
    val input = readInputOrNull("enter text: ") ?: return null
    val isPalindrome = calculator.isPalindrome(input)
    println(if (isPalindrome) "$input is palindrome" else "$input is not palindrome")
    return true
}

fun reverseText(calculator: MyCalculator): Boolean? {
    val input = readInputOrNull("enter number: ") ?: return null
    val number = input.toIntOrNull() ?: return false
    println("number $number reversed is ${calculator.reverseNumber(number)}")
    return true
}

fun checkInput(calculator: MyCalculator): Boolean? {
    val input = readInputOrNull("enter text: ") ?: return null
    if (calculator.containsDollarSign(input)) println("text contains char : $") else println("text does not contain char: $")
    return true
}

fun sumEvenNumbers(calculator: MyCalculator): Boolean? {
    val input = readInputOrNull("enter number: ") ?: return null
    val number = input.toIntOrNull() ?: return false
    println("sum of even numbers from 0 to $number is ${calculator.calculateEvenSum(number)}")
    return true
}

fun calculateWithOperation(calculator: MyCalculator, operation: OperationType): Boolean? {
    val function = when (operation) {
        OperationType.LCM -> calculator::calculateLcm
        OperationType.GCD -> calculator::calculateGcd
    }
    val aInput = readInputOrNull("enter first Number: ") ?: return null
    val bInput = readInputOrNull("enter second Number: ") ?: return null
    val a = aInput.toIntOrNull() ?: return false
    val b = bInput.toIntOrNull() ?: return false
    val answer = function(a, b)
    println("${operation.name} of numbers($a,$b) is $answer")
    return true
}

fun readInputOrNull(prompt: String = ""): String? {
    print(prompt)
    return readlnOrNull()
}


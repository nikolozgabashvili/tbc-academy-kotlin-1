import kotlin.math.abs
import kotlin.math.absoluteValue

class MyCalculator {


    fun calculateGcd(x: Int, y: Int): Int {
        return if (y == 0) x.absoluteValue else calculateGcd(y, x % y)
    }

    fun calculateLcm(x: Int, y: Int): Int {
        return if (x * y == 0) 0 else abs(x * y) / calculateGcd(x, y)
    }

    fun calculateEvenSum(number: Int = 100): Int {
        return if (number <= 0) 0 else if (number % 2 == 0) number + calculateEvenSum(number - 1) else calculateEvenSum(
            number - 1
        )
    }

    fun containsSymbol(string: String): Boolean {
        return string.contains('$')

    }

    fun reverseNumber(number: Int) = number.toString().reversed().toInt()

    fun isPalindrome(text: String) = text == text.reversed()


    fun runTests() {

        for (type in TestTypes.entries) {
            val testList = when (type) {
                TestTypes.GCD_TEST -> gcdTests
                TestTypes.LCM_TEST -> lcmTests
            }
            val testFunc = when (type) {
                TestTypes.GCD_TEST -> ::calculateGcd
                TestTypes.LCM_TEST -> ::calculateLcm
            }

            var failedTests = 0

            for (test in testList) {
                val result = testFunc(test.x, test.y)
                if (result != test.answer) {
                    failedTests++
                    println("${type.name}: Failed test: $test, got: $result ,expected ${test.answer}")
                }
            }
            if (failedTests == 0) {
                println("${type.name}: All tests passed")
            } else {
                println("${type.name}: passed ${testList.size - failedTests}/${testList.size} tests")
            }

        }

    }


    private val lcmTests = listOf(
        Test(4, 5, 20),
        Test(0, 7, 0),
        Test(7, 0, 0),
        Test(0, 0, 0),
        Test(6, 6, 6),
        Test(1, 100, 100),
        Test(100, 1, 100),
        Test(13, 29, 377),
        Test(8, 32, 32),
        Test(32, 8, 32),
        Test(-4, 6, 12),
        Test(4, -6, 12),
        Test(-4, -6, 12),
        Test(35, 64, 2240),
        Test(1, 1_000_000_000, 1_000_000_000),
        Test(101, 102, 10302),
        Test(48, 18, 144)
    )

    private val gcdTests = listOf(
        Test(1, 1, 1),
        Test(48, 18, 6),
        Test(0, 7, 7),
        Test(0, 0, 0),
        Test(12, 12, 12),
        Test(100, 1, 1),
        Test(13, 29, 1),
        Test(8, 32, 8),
        Test(123_456_789, 987_654_321, 9),
        Test(-48, 18, 6),
        Test(-48, -18, 6),
        Test(35, 64, 1),
        Test(101, 102, 1),
    )

}
package subtask5

import kotlin.math.max

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val poli = digitString.toCharArray()
        var diffCounter = diffFinder(poli, n)
        if (diffCounter > k) return "-1"
        var changesCounter = k

        while (changesCounter > 0) {
            for (i in 0 until n / 2) {
                if (poli[i] != poli[n - i - 1] && (poli[i] != '9' || poli[n - i - 1] != '9')) {
                    if (changesCounter - diffCounter >= 0 && changesCounter > 2) {
                        poli[i] = '9'
                        poli[n-i-1] = '9'
                        changesCounter -= 2
                        diffCounter--
                    } else {
                        val value = max(poli[i].toInt(), poli[n - i - 1].toInt())
                        poli[i] = value.toChar()
                        poli[n - i - 1] = value.toChar()
                        changesCounter--
                    }
                }
            }
        }
        return poli.joinToString("","","")
    }

    private fun diffFinder(text: CharArray, lenght: Int): Int {
        var diff = 0
        for (i in 0 until lenght / 2) {
            if (text[i] != text[lenght - i - 1]) {
                diff++
            }
        }
        return diff
    }
}

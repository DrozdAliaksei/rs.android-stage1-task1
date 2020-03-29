package subtask4

class StringParser {

    private val opened = charArrayOf('[', '(', '<')
    private val closed = charArrayOf(']', ')', '>')

    fun getResult(inputString: String): Array<String> {
        val text = inputString.toCharArray()
        val subStrings: ArrayList<String> = arrayListOf()
        var openedType = 0
        for (i in 0 until text.size - 1) {
            var startSubstring = 0
            var endSubstring = 0
            var countOfStartBracket = 0
            openedType = isOpened(text[i])
            if (openedType < 4) {
                startSubstring = i + 1
                countOfStartBracket = 1
                for (x in startSubstring until text.size) {
                    if (text[x] == opened[openedType]) {
                        countOfStartBracket++
                        continue
                    } else if(text[x] == closed[openedType]) {
                        if(countOfStartBracket > 1){
                            countOfStartBracket--
                            continue
                        }
                        endSubstring = x
                        subStrings.add(inputString.substring(startSubstring, endSubstring))
                        break
                    }
                }
            }
        }

        return subStrings.toTypedArray()
    }

    private fun isOpened(elem: Char): Int {
        for (i in opened) {
            if (elem == i) return opened.indexOf(i)
        }
        return 4
    }
}

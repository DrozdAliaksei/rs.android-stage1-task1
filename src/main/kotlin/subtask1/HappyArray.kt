package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.size < 3) return sadArray
        val happyArray = sadArray.toMutableList()
        var i = 1
        while (i != happyArray.size - 1) {
            if (happyArray[i + 1] + happyArray[i - 1] < happyArray[i]) {
                happyArray.removeAt(i)
                i = 1
            } else i++
        }

        return happyArray.toIntArray()
    }
}

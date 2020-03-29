package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        input.sort()
        return intArrayOf(minSum(input),maxSum(input))
    }

    private fun minSum(input: IntArray): Int{
        var minSum = 0
        for (i in 0..input.size-2) minSum += input[i]
        return minSum
    }

    private fun maxSum(input: IntArray): Int{
        var maxSum = 0
        for (i in input.size - 1 downTo 1) maxSum += input[i]
        return maxSum
    }
}

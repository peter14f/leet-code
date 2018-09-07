class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        var lookup = HashMap<Int, HashSet<Int>>()
        for (i in nums.indices) {
            val v = nums[i]
            val indices = lookup.getOrDefault(v, HashSet<Int>())
            indices.add(i)
            lookup.put(v, indices)
        }
        for (i in nums.indices) {
            val diff = target - nums[i]
            if (lookup.containsKey(diff)) {
                for (j in lookup.get(diff)!!) {
                    if (j != i) {
                        if (i < j) {
                            return intArrayOf(i, j)
                        } else {
                            return intArrayOf(j, i)
                        }
                    }
                }
            }
        }
        return intArrayOf(-1, -1)
    }
}

fun main(args: Array<String>) {
    val list = intArrayOf(3, 2, 3)
    val sol = Solution()
    val ans = sol.twoSum(list, 6)
    ans.map { n -> println(n) }
}
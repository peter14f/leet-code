import com.sun.org.apache.xpath.internal.operations.Bool

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        }
        if (l2 == null) {
            return l1
        }

        var cur1: ListNode? = l1
        var cur2: ListNode? = l2

        var l3: ListNode? = null
        var cur3: ListNode? = null
        var carry = false

        while (cur1 != null || cur2 != null) {
            var sum = when {
                (cur1 != null && cur2 != null) -> cur1.`val` + cur2.`val`
                (cur1 != null) -> cur1.`val`
                else -> cur2!!.`val`
            }
            if (carry) {
                sum += 1
                carry = false
            }
            if (sum > 9) {
                carry = true
                sum %= 10
            }
            val newNode = ListNode(sum)
            if (cur3 == null) {
                l3 = newNode
                cur3 = newNode
            } else {
                cur3.next = newNode
                cur3 = newNode
            }

            if (cur1 != null) cur1 = cur1.next
            if (cur2 != null) cur2 = cur2.next
        }

        if (carry) {
            val newNode = ListNode(1)
            cur3!!.next = newNode
        }

        return l3
    }
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

fun main(args: Array<String>) {
    val sol = Solution()
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1!!.next!!.next = ListNode(3)

    val l2 = ListNode(3)
    l2.next = ListNode(4)
    l2!!.next!!.next = ListNode(5)

    val l3 = sol.addTwoNumbers(l1, l2)
    println(l3!!.`val`)
}
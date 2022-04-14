fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    val dummyHead: ListNode
    var cur: ListNode?
    var l1 = list1
    var l2 = list2

    if (l1.`val` < l2.`val`) {
        dummyHead = l1
        l1 = l1.next
    } else {
        dummyHead = l2
        l2 = l2.next
    }

    cur = dummyHead
    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            cur?.next = l1
            l1 = l1.next
        } else {
            cur?.next = l2
            l2 = l2.next
        }

        cur = cur?.next
    }

    if (l1 == null) {
        cur?.next = l2
    }
    if (l2 == null) {
        cur?.next = l1
    }

    return dummyHead
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}







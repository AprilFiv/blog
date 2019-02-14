```javascript
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head, pre = slow;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode before = sortList(head);
        ListNode after = sortList(slow);
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (before!=null || after !=null){
            if (before == null){
                cur.next = after;
                after = after.next;
                cur = cur.next;
            } else if (after ==null){
                cur.next = before;
                before = before.next;
                cur = cur.next;
            } else if (before.val<after.val){
                cur.next = before;
                before = before.next;
                cur = cur.next;
            } else {
                cur.next = after;
                after = after.next;
                cur = cur.next;
            }
        }
        return res.next;
    }
}
```
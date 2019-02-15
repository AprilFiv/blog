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
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre = head;
        ListNode tail = new ListNode(0);
        while (head!=null && head.next!=null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        head.next =tail;
        pre.next = null;
        return head;
    }
}
```
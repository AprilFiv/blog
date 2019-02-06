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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastp = head;
        ListNode slowp = head;
        int cal = 0;
        // given n will always be valid, so we can't need to check null for fastp while i-1>0.
        while(n-1>0 ){
            fastp = fastp.next;
            n--;
        }
        // remove head
        if (fastp.next==null){
            return head.next;
        } else {
            fastp = fastp.next;//make slowp point to the (n+1)th node 
        }
        // slowp will be the 
        while(fastp.next!=null){
            fastp = fastp.next;
            slowp = slowp.next;
            cal++;
        }
      
        slowp.next = slowp.next.next;
        return head;
    }
}
```
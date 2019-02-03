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
    public ListNode rotateRight(ListNode head, int k) {
        int length = 1;
        ListNode tail = head;
        ListNode optRoot = head;
        ListNode newHead = null;
        
        //find the tail
        while(tail!=null && tail.next!=null){
            tail = tail.next;
            length++;
        }
        if (head == null ){
            return null;
        }
        if (length == 1){
            return head;
        }
        
        //make the list a circle.
        tail.next= head;
        
        //calculate the opt times;
        int opt = k % length;
        int remain = length - opt;
        
        for (int i = 0; i<remain;i++){
            ListNode temp = optRoot.next;
            if (i ==remain-1){
                newHead = new ListNode(temp.val);
                newHead.next= temp.next;
                optRoot.next =null;
                break;
            }
            optRoot =temp; 
        }
        return newHead;
    }
}
```
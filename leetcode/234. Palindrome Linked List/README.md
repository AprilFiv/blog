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
    public boolean isPalindrome(ListNode head) {
        if (head==null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            list.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        // if fast is equals to null, then the length of list should be satisfied l%2==1;
        if(fast !=null){
            slow = slow.next;    
        }
        while (slow!=null){
            if (list.get(list.size()-1)!=slow.val){
                return false;
            }
            slow = slow.next;
            list.remove(list.size()-1);
        }
        return true;
        
    }
}
```
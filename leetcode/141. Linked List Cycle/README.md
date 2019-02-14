```javascript
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        int res = -1;
        int index = 0;
        while(head!=null){
            if (map.get(head)!=null){
                return true;
            }
            map.put(head,index++);
            head = head.next;
        }
        return false;
    }
}
```
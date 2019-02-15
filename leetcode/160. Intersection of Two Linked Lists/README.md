regular solution
```javascript
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();
        while(headA!=null){
            map.put(headA,1);
            headA = headA.next;
        }
        while(headB!=null){
            if (map.get(headB)!=null){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
```

another solution:traver both list for twice, then they will meet at the intersection.
```javascript
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode currA = headA;
        ListNode currB = headB;
        int count=3;
        while(count >0 && currA!=currB){
            
            if(currA==null || currB==null)
                count--;
            currA = (currA==null)?headB:currA.next;
            currB = (currB==null)?headA:currB.next;
            
            
        }
        if(currA==currB)
            return currA;
        return null;
        
    }
}
```
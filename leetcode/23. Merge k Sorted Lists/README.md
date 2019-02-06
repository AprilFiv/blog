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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        List<ListNode> list = new ArrayList<>(Arrays.asList(lists));
        
        //like merge sort
        while (list.size()>1){
            int start = 0;
            int end = list.size()-1;
            List<ListNode> temp = new ArrayList<>();
            while(start<end){
                temp.add(mergeTwoLists(list.get(start++),list.get(end--)));
                if (start==end){
                    temp.add(list.get(start));
                }
            }
            list.clear();
            list.addAll(temp);
        }
        return list.get(0);
        
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // use a headprev node to start;
        ListNode headprev = new ListNode(-1);
        ListNode pointer = headprev;
        while (l1!=null){
            if (l2!=null){
                if (l1.val > l2.val){
                    ListNode temp = new ListNode(l2.val);
                    pointer.next = temp;
                    pointer = pointer.next;
                    l2 = l2.next;
                } else {
                    ListNode temp = new ListNode(l1.val);
                    pointer.next = temp;
                    pointer = pointer.next;
                    l1 = l1.next;
                }
            } else {
                break;
            }
        }
        
        /**
        * either l1 or l2 can be not null, append the rest of the list.
        */
        while (l1!=null){
            ListNode temp = new ListNode(l1.val);
            pointer.next = temp;
            pointer = pointer.next;
            
            l1 = l1.next;
        }
        while (l2!=null){
            ListNode temp = new ListNode(l2.val);
            pointer.next = temp;
            pointer = pointer.next;
            
            l2 = l2.next;
        }
        return headprev.next;
    }
}
```
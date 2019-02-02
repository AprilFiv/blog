Whether the order of the node is reverse or not, clearly we should just add the number in the same digit, and the outcoming is what we find.

Remember that one of the list will get _null_ first, the other one just link the result before. 

Dont forget to +1 while same digit add to 10 or larger.

source code as follow :

```javascript
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = null;
        ListNode res = null;
        int flag = 0;
        int flag2 = 0;
        while(l1!=null){
            if (l2!=null){
                if (flag !=0){
                    if (flag2 ==1) {
                        if (l1.val+l2.val+flag2>=10){
                             temp.next = new ListNode(l1.val+l2.val-10+1);
                            flag2=1;
                        } else {
                            temp.next = new ListNode(l1.val+l2.val+1);
                            flag2=0;
                        }
                    } else {
                       if (l1.val+l2.val>=10){
                             temp.next = new ListNode(l1.val+l2.val-10);
                                 flag2=1;
                        } else {
                            temp.next = new ListNode(l1.val+l2.val);
                            flag2=0;
                        }  
                    }
                    temp = temp.next;
                } else {
                    if (l1.val+l2.val>=10){
                        flag2 = 1;
                        temp = new ListNode(l1.val+l2.val-10);
                    } else {
                        temp = new ListNode(l1.val+l2.val);
                    }
                    flag ++;
                     res = temp;
                }
            
                l2 = l2.next;
            } else {
                 if (flag !=0){
                     if (flag2==1){
                         if (l1.val+flag2>=10){
                             temp.next = new ListNode(l1.val+1-10);
                             flag2 = 1;
                         } else {
                             temp.next = new ListNode(l1.val+1);
                             flag2 = 0;
                         }
                     } else {
                        flag2 = 0;
                          temp.next = new ListNode(l1.val);
                     }
                      temp= temp.next;

                } else {
                     flag ++;
                    temp = new ListNode(l1.val);
                      res = temp;
                 }
                
            }
            l1 = l1.next;
        } 
       while (l2!=null){
            if (flag !=0){
                      if (flag2==1){
                         if (l2.val+flag2>=10){
                             temp.next = new ListNode(l2.val+1-10);
                             flag2 = 1;
                         } else {
                             temp.next = new ListNode(l2.val+1);
                             flag2 = 0;
                         }
                     } else {
                          flag2 = 0;
                           temp.next = new ListNode(l2.val);
                      }
                temp= temp.next;
                } else {
                     flag ++;
                    temp = new ListNode(l2.val);
             res = temp;
                 }
           
           l2 = l2.next;
       }
        if (flag2 ==1){
            temp.next = new ListNode(1);
        }
        return res;
    }
```
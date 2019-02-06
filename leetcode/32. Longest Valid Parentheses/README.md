```javascript
class Solution {
    public int longestValidParentheses(String s) {
        List<Integer> list = new ArrayList<>();
        
        //use an array to record the longestValidParentheses of the s.substring(0,i+1)
        int[] length = new int[s.length()+1];
        int res = 0;
        for (int i = 0 ; i<s.length();i++){
            if (s.charAt(i)=='(') {
                list.add(i);
            } else if (s.charAt(i)==')'){
                if (list.size()==0){
                    continue;
                } else if (list.size()==1){
                    int prePos = list.get(0);
                    res = Math.max(res,i-prePos+1+length[prePos]);
                    length[i+1]=i-prePos+1+length[prePos];
                    list.remove(0);
                } else { // list.size()>1
                    int prePos = list.get(list.size()-1);
                    res = Math.max(res,i-prePos+1+length[prePos]);
                    length[i+1]=i-prePos+1+length[prePos];
                    list.remove(list.size()-1);
                }
            }
        }
        return res;
    }
}
```
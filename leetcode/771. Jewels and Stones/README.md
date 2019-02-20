```javascript
class Solution {
    public int numJewelsInStones(String J, String S) {
       Set<Character> set = new HashSet<Character>();
        for (int i =0;i<J.toCharArray().length;i++){
            set.add(J.toCharArray()[i]);
        }
        int res = 0;
        for (int i = 0;i<S.toCharArray().length;i++ ){
            if (set.contains(S.toCharArray()[i])){
                res++;
            }
        }
        return res;
    }
}
```
```javascript
class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int res = Integer.MAX_VALUE;
        int[] target = new int[128];
        int[] from = new int[128];
        int targetLen = 0;
        for (int i = 0;i<t.length();i++){
            target[t.charAt(i)] +=1;
            targetLen++;
        }
        int right = 0,left = 0,len = 0;
        while (right<s.length()){
            if (target[s.charAt(right)]!=0){
                from[s.charAt(right)]++;
                if (from[s.charAt(right)]<=target[s.charAt(right)]){
                    len++;
                }
                while (target[s.charAt(left)]==0 || from[s.charAt(left)]>target[s.charAt(left)]){
                    if (target[s.charAt(left)]>0){
                        from[s.charAt(left)]--;
                    }
                    left ++;
                }
                if (len == targetLen && res>right-left+1){
                    res = right-left+1;
                    start = left;
                    end = right+1;
                }
            }
            right ++;
        }
        return s.substring(start,end);
    }
}
```
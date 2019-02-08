```javascript
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n==0){
            list.add(0);
            return list;
        }
        if (n>=1){
            list.add(0);
            list.add(1);
        } 
        while(n>=2) {
            for (int i = list.size() - 1; i >= 0; i--) {
                list.add(list.get(i) + (int)Math.pow(2,n-1));
            }
            n--;
        }
        return list;
    }
}
```
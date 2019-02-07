```javascript
class Solution {
    // we can find that given m,n, we need m-1 rights and n-1 downs to reach 'finish'.
    public int uniquePaths(int m, int n) {
        int columns = m-1 + n-1;
        int base = Math.min(m-1,n-1);
        
        // to prevent res is bigger than 2^32-1
        long res = 1;
        for (int i = 1;i<=base;i++){
            res = res * (columns-(i-1))/i;
        }
        return (int)res;
    }
}
```
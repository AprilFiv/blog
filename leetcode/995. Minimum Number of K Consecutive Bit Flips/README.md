```javascript
class Solution {
    public int minKBitFlips(int[] A, int K) {
        int opt = 0;
        boolean flag= true;
        for (int i = 0;i<A.length-K+1;i++){
            if (A[i]==0){
                flag = false;
                for (int j = i;j<i+K;j++){
                    if (A[j]==0){
                        A[j]=1;
                    } else {
                        A[j]=0;
                    }
                }
                opt++;
            }
        }
        for (int i = 0;i<A.length;i++){
            if (A[i]==0){
                return -1;
            }
        }
            
        return opt;
    }
}
```
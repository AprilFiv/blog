```javascript
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int sum = 0;
        int end = -1;
        int start = 0;
        int res = Integer.MAX_VALUE;
        for (int i =0;i<nums.length;i++){
            sum += nums[i];
            if (sum>=s && end==-1){
                end = i;
                res = Math.min(res,i+1);
            }
            if (i>=end && end!=-1){
                while(sum-nums[start]>=s){
                    sum = sum-nums[start];
                    start++;
                }
                res = Math.min(res,i-start+1);
            }
        }
        if (res==Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }
}
```
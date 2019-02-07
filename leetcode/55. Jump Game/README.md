```javascript
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length+nums[nums.length-1]+1];
        dp[0] = true;
        int i = 0;
        while(dp[i]){
            for (int j= 1 ;j<=nums[i];j++){
                if (i+j>=nums.length){
                    break;
                }
                dp[i+j]=true;
            }
            i++;
            if (i==nums.length){
                break;
            }
        }
        return dp[nums.length-1];
    }
}   
```

other solution by greedy algorithm, based on the accessibility same.
```javascript
 public boolean canJump(int[] nums) {
        int N = nums.length;
        int longest = 0, curr = 0;
        for (int i =0; i < N; i++) {
            longest = Math.max(nums[i] + i, longest);
            if (i == curr) {
                curr = longest;
            }
        }
        return curr >= N -1;
    }  
```
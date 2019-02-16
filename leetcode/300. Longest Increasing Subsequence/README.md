```javascript
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length+1];
        int curMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        dp[0] = 0;
        int max = 0;
        int j = 1;
        while(j<=nums.length){
        for (int i = j;i<=nums.length;i++){
            if (nums[i-1]>curMax){
                dp[i]=dp[i-1]+1;
                secMax = curMax;
                curMax = nums[i-1];
            } else if (nums[i-1]>secMax){
                curMax = nums[i-1];
                dp[i]=dp[i-1];
            } else {
                dp[i]=dp[i-1];
            }
        }
            j++;
            System.out.println(dp[nums.length]);
            max= Math.max(max,dp[nums.length]);
            curMax = Integer.MIN_VALUE;
            secMax = Integer.MIN_VALUE;
            Arrays.fill(dp,0);
        }
    return max;
        
    }
}
```

another solution with O(nlogn)
```javascript
private int method_binarySearch(int [] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int [] minTails = new int[nums.length];
        int len = 1;
        minTails[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            // value is greater then the tail min, so sequence will get bigger
            if(nums[i] > minTails[len-1]) {
                minTails[len] = nums[i];
                len++;
            } else if(nums[i] < minTails[0]) {
                // value is smallest then the lowest tail min, so update the value;
                minTails[0] = nums[i];
            } else {
                // in the middle.  Find where it should be and update the tail min 
                int insertionIndex = Arrays.binarySearch(minTails, 0, len-1, nums[i]);
                // binary search return -1 of where it should be inserted
                if(insertionIndex < 0) {
                    insertionIndex = -(insertionIndex+1);
                    minTails[insertionIndex] = nums[i];
                }
            }
            //System.out.print("minLen:" + len + " minTails:");
            //print(minTails);
        }
        
        return len;
    }
```
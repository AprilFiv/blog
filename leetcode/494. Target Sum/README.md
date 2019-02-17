```javascript
class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        pushBack(nums,S,0,0);
        return res;
    }
    public void pushBack(int[] nums,int S,int sum,int index){
        if (index==nums.length ){
            if (S==sum){
                res++;
                return ;
            } else{
                return;
            }
        }
        //only two cases.
        pushBack(nums,S,sum+nums[index],index+1);
        pushBack(nums,S,sum-nums[index],index+1);
        
    }
}
```
```javascript
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1;i<nums.length;i++){
            int var1 = nums[i];
            int var2 = nums[i]*max;
            int var3 = nums[i]*min;
            max = Math.max(Math.max(var1,var2),var3);
            min = Math.min(Math.min(var1,var2),var3);
            res = Math.max(max,res);
        }
        return res;
    }
}
```
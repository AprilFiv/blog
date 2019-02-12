```javascript
class Solution {
    public int[] searchRange(int[] nums, int target) {
        /* 
        * use a java default binarySearch.
        * be carefull that it's not always return the minimum index.
        */
        int start = Arrays.binarySearch(nums,target);
        if (start < 0 ){
            return new int[]{-1,-1};
        } else {
            int end = start;
            for (int i=start+1;i<nums.length;i++){
                if (nums[i]==target){
                    end++;
                }
            }
            for (int i=start-1;i>=0;i--){
                if (nums[i]==target){
                    start--;
                }
            }
            return new int[]{start,end};
        }
    }
}
```
```javascript
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        boolean startFlag = false;
        boolean endFlag = false;
        for (;;){
            for (int i = start+1 ;i<nums.length;i++){
                if (!startFlag && nums[i]<nums[start]){
                    startFlag = true;
                }
            }
            for (int i = end-1;i>=0;i--){
                if (!endFlag && nums[i]>nums[end]){
                    endFlag = true;
                }
            }
            
            if (startFlag && endFlag){
                break;
            }
            if (start >= end){
                break;
            }
            if (!startFlag){
                start++;
            }
            if (!endFlag){
                end--;
            }
        }
        return !startFlag && !endFlag?0:end-start+1;
    }
}
```
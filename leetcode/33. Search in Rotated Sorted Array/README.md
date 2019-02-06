```javascript
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while(start<end){
            int mid = (end+start)/2;
            double num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target)
                start = mid + 1;
            else if (num > target)
                end = mid;
            else
                return mid;
        }
        return -1;
    }

}
```
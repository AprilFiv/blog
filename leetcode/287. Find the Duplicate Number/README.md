```javascript
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}
```


because the range of nums is between 0 to n, which are the index of the array also.
```javascript
class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0 ;i<nums.length;i++){
            if (nums[Math.abs(nums[i])]<0){
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i])] *= -1;
            }
        }
        return 0;
    }
}
```
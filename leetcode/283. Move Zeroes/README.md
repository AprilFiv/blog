```javascript
class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = nums.length-1;
        for (int i = 0 ;i<pointer;i++){
            if (nums[i]==0){
                for (int j  =i ;j<pointer;j++) {
                    nums[j] = nums[j+1];
                }
                nums[pointer--] = 0;
                i--;
            }        
        }
    }
}
```


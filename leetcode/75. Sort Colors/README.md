```javascript
class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        //totally nums.length times operation.
        //if find nums[i]==0 put it in the head.
        //if find nums[i]==2 put it in the tail.
        for (int i =0,c=0 ;c<nums.length;c++){
            if (nums[i]==0){
                int temp = nums[i];
                for (int j=i;j>0;j--){
                    nums[j] =nums[j-1];
                }
                i++;
                nums[start] = temp;
            } else if (nums[i]==2){
                int temp = nums[i];
                for (int j=i;j<nums.length-1;j++){
                    nums[j] =nums[j+1];
                }
                nums[end] = temp;
            } else {
                i++;
            }
        }
    }
}
```
As a obvious thought, 
we should find the first a(i)>a(i-1) in a reverse order. 
If exists, exchange the a(i-1) and the minimum one larger than a(i-1), 
then reverse the arr[i...length-1], 
or just reverse the total array.

source code as follow :

```javascript
    public void nextPermutation(int[] nums) {
        int flag = -1;
        for (int i = nums.length-2 ;i >=0;i-- ){
            if (nums[i]<nums[i+1]){
                flag = i;
                break;
            }
        }
        if (flag==-1){
            for (int i =0 ;i<nums.length/2;i++){
                int temp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = temp;
            }
            return ;
        }
        for (int i = flag+1 ; i<nums.length;i++){
            if (nums[i]>nums[flag] && (i == nums.length-1 || nums[i+1] <= nums[flag])){
                int temp = nums[flag];
                nums[flag] = nums[i];
                nums[i] = temp;
                break;
            } 
        }
        for (int i =flag+1 ;i<(nums.length-flag-1)/2+flag+1;i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i+flag+1];
            nums[nums.length-1-i+flag+1] = temp;
        }
        
    }
```
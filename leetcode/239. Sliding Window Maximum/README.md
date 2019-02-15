at very first time, it's obvious to get an solution with o(n*k)
```javascript
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return nums;
        }
        int[] res = new int[nums.length-k+1];
        for (int i = 0;i<res.length;i++){
            int max = Integer.MIN_VALUE;
            for (int j = 0;j<k;j++){
                if (nums[i+j]>max){
                    max = nums[i+j];
                }
            }
            res[i]=max;
        }
        return res;
    }
}
```
then i try to use a priorityqueue to improve my algorithm to o(n);
```javascript
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return nums;
        }
        int[] res = new int[nums.length-k+1];
       Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
		});
        for (int i  =0 ;i<k;i++){
            queue.add(nums[i]);
        }
        res[0]=queue.peek();
        for (int i = 1;i<res.length;i++){
            queue.remove(nums[i-1]);
            queue.add(nums[i+k-1]);
            res[i] = queue.peek();
        }
        return res;
    }
}
```
```javascript
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        Queue<Integer> priorityQueue = new PriorityQueue<>(k);
        int temp ;
        for (int i = 0 ;i<length;i++){
            if (i<k){
                priorityQueue.offer(nums[i]);
            } else {
                if ((temp=priorityQueue.peek())<nums[i]){
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                } 
            }
        }
        return priorityQueue.poll();
    }
}
```
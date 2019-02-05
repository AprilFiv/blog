```javascript
 public int maxArea(int[] height) {
        int end = height.length-1;
        int start = 0;
        int res = 0;
        /**
         * while wide is depend on end-start, and it's decreasing with each operation.
         * the only way to make res larger is to get the lower one more higher.
         */
        while(start<end){
            res = Math.max(res,(end-start)*Math.min(height[start],height[end]));
            if (height[start]<height[end]){
                start++;
            }else {
                end--;
            }
        }
        return res;
    }
```
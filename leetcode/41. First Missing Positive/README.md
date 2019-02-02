This problem is pretty simple, while the length of the array is given by the input, we can quickly find the outcoming in O(nlog2n) with binarysearch.

source code as follow :

```javascript
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        Arrays.sort(nums);
        for (;;){
            i++;
            int pos = Arrays.binarySearch(nums,i);
            if (pos<0){
                return i;
            }
        }
    }
```
pay attention to the _sort()_ function, you should make the array in order before using binarysearch, or something can go wrong.

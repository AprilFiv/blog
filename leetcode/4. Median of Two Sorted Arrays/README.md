```javascript
class Solution{
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int mid = length/2;
        int pointer1 = 0;
        int pointer2 = 0;
        int before = 0;
        int after = 0;
        while (pointer1+pointer2+1<=mid){
            if (pointer1==nums1.length){
                before = nums2[pointer2];
                pointer2++;
            } else if (pointer2 == nums2.length){
                before = nums1[pointer1];
                pointer1++;
            } else if (nums1[pointer1]<nums2[pointer2]){
                before = nums1[pointer1];
                pointer1++;
            } else {
                before = nums2[pointer2];
                pointer2++;
            }
        }
        if (pointer1==nums1.length){
            after = nums2[pointer2];
            pointer2++;
        } else if (pointer2 == nums2.length){
            after = nums1[pointer1];
            pointer1++;
        } else if (nums1[pointer1]<nums2[pointer2]){
            after = nums1[pointer1];
            pointer1++;
        } else {
            after = nums2[pointer2];
            pointer2++;
        }
        if (length%2 ==0){
            return (before+after)/2.0;
        }
        return after;
    }

    
}
```
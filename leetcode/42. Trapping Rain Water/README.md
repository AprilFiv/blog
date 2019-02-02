This problem can be solved like a game called tetris, which is a classic game from Russia.

Using a var called _current_ to represent the removed height, and find the gap between elements in same height.

source code as follow :
```javascript
    public int trap(int[] height) {
        int res = 0;
        int current = 0;
        for (;;){
            boolean flag = false;
            for (int i =0 ; i<height.length-1;i++){
                if (height[i]>=current){
                    flag = true;
                }
                if (height[i]-current>0 && height[i+1]-current<=0){
                    for (int j = i+2 ; j<height.length;j++){
                        if (height[j]-current>0 ){
                            res += j-i-1;
                            break;
                        }
                    }
                }
            }
            if (!flag){
                return res;
            }
            current++;
        }

    }
```
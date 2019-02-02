Exchange the elements in the second quadrant in a order with the first quadrant,
the fourth quadrant, the third quadrant.
elemnts in the coordinate should be treated specially.

(Faster enough than any other solutions.)

source code as follow : 

```javascript
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n==0){
            return ;
        }
        double center = ((double)(n-1))/2;
        for (int i =0 ; i< center;i++){
            for (int j = 0;j<center;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }

        for (int i =0 ; i< center;i++){
            for (int j = 0;j<center;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = temp;
            }
        }

        for (int i =0 ; i< center;i++){
            for (int j = 0;j<center;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }

        if (n%2!=0){
            for (int i = 0 ; i<center;i++){
             int temp = matrix[i][(int)center];
                matrix[i][(int)center] = matrix[(int)center][i];
                matrix[(int)center][i] = matrix[n-1-i][(int)center];
                matrix[n-1-i][(int)center] = matrix[(int)center][n-1-i] ;
                matrix[(int)center][n-1-i] = temp;
                
            }
        }
    }
```
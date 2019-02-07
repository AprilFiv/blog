At first time, i used a java stack to record the element in board that i have visited, but end up time limit exceeded.
```javascript
public boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0 ;i<board.length;i++){
            for (int j = 0 ;j<board[i].length;j++){
                if (board[i][j]==word.charAt(0)){
                    Stack<String> stack = new Stack<>();
                    stack.push(String.valueOf(i)+j);
                    result = find(stack,board,i,j,word);
                    if (result){
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public boolean find(Stack<String> stack, char[][] board,int m, int n,String word){
        boolean result = false;
        if (stack.size()==word.length()){
            result = true;
            return result;
        }

        if (checkValid(board,m-1,n)){
            if (board[m-1][n] == word.charAt(stack.size())&& !stack.contains(String.valueOf(m-1)+(n))){
                stack.push(String.valueOf(m-1)+n);
                result = find(stack,board,m-1,n,word);
                if (result){
                    return result;
                }
                stack.pop();
            }
        }
        if (!result && checkValid(board,m+1,n) && !stack.contains(String.valueOf(m+1)+(n))){
            if (board[m+1][n] == word.charAt(stack.size())){
                stack.push(String.valueOf(m+1)+n);
                result = find(stack,board,m+1,n,word);
                if (result){
                    return result;
                }
                stack.pop();
            }
        } if (!result && checkValid(board,m,n-1) && !stack.contains(String.valueOf(m)+(n-1))){
            if (board[m][n-1] == word.charAt(stack.size())){
                stack.push(String.valueOf(m)+(n-1));
                result = find(stack,board,m,n-1,word);
                if (result){
                    return result;
                }
                stack.pop();
            }
        } if (!result && checkValid(board,m,n+1) && !stack.contains(String.valueOf(m)+(n+1))){
            if (board[m][n+1] == word.charAt(stack.size())){
                stack.push(String.valueOf(m)+(n+1));
                result = find(stack,board,m,n+1,word);
                if (result){
                    return result;
                }
                stack.pop();
            }
        }
        return result;
    }

    public boolean checkValid(char[][] board,int i,int j ){
        if (i<0 || j<0){
            return false;
        }
        return i < board.length && j < board[0].length;
    }
```
then I found up a intelligent method to record those visited element, a ~ operator.
```javascript
public boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0 ;i<board.length;i++){
            for (int j = 0 ;j<board[i].length;j++){
                if (board[i][j]==word.charAt(0)){
                    board[i][j]=(char)(~board[i][j]);
                    result = find(1,board,i,j,word);
                    board[i][j]=(char)(~board[i][j]);
                    if (result){
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public boolean find(int length, char[][] board,int m, int n,String word){
        boolean result = false;
        if (length==word.length()){
            result = true;
            return result;
        }

        if (checkValid(board,m-1,n)){
            if (board[m-1][n] == word.charAt(length)){
                board[m-1][n]=(char)(~board[m-1][n]);
                result = find(length+1,board,m-1,n,word);
                board[m-1][n]=(char)(~board[m-1][n]);
                if (result){
                    return result;
                }
            }
        }
        if (!result && checkValid(board,m+1,n) ){
            if (board[m+1][n] == word.charAt(length)){
                board[m+1][n]=(char)(~board[m+1][n]);
                result = find(length+1,board,m+1,n,word);
                if (result){
                    return result;
                }
                board[m+1][n]=(char)(~board[m+1][n]);

            }
        } if (!result && checkValid(board,m,n-1) ){
            if (board[m][n-1] == word.charAt(length)){
                board[m][n-1]=(char)(~board[m][n-1]);

                result = find(length+1,board,m,n-1,word);
                if (result){
                    return result;
                }
                board[m][n-1]=(char)(~board[m][n-1]);

            }
        } if (!result && checkValid(board,m,n+1) ){
            if (board[m][n+1] == word.charAt(length)){
                
                //to remove visited index.
                board[m][n+1]=(char)(~board[m][n+1]);
                
                result = find(length+1,board,m,n+1,word);
                if (result){
                    return result;
                }
                board[m][n+1]=(char)(~board[m][n+1]);
            }
        }
        return result;
    }

    public boolean checkValid(char[][] board,int i,int j ){
        if (i<0 || j<0){
            return false;
        }
        return i < board.length && j < board[0].length;
    }
```
dfs
```javascript
class Solution {
     public int numTrees(int n) {
        return dfs(1, n);
    }
    
    private int dfs(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int count = 0;
        // while n is alway in order, left and rig
        for (int i = start; i <= end; i++) {
            int left = dfs(start, i - 1);
            int right = dfs(i + 1, end);
            count += left * right;
        }
        return count;
    }
}
```

dp
```javascript
public static int numTrees(int n) {
    int[] trees = new int[n+1];
    trees[0] = 1;
    trees[1] = 1;
    for (int i = 2; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            trees[i] += trees[j] * trees[i-1-j];
        }
    }
    return trees[n];
}
```

catalan number
```javascript
public static int numTrees(int n) {
    long tree = 1;
    for (int i = 0; i < n; i++) {
        tree = tree * 2 * (2 * i + 1) / (i + 2);
    }
    return (int) tree;
}
```
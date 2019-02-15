```javascript
class Trie {

    //name 'trie' indicates a solution this question should consider.
    private class Node {
        Node[] children;
        boolean isEnd = false;

        public Node() {
            children = new Node[26];
        }
    }

    private Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node node = head;
        char[] w = word.toCharArray();
        for (char c : w) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Node();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] w = word.toCharArray();
        Node node = head;
        for (char c : w) {
            int i = c - 'a';
            node = node.children[i];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] w = prefix.toCharArray();
        Node node = head;
        for (char c : w) {
            int i = c - 'a';
            node = node.children[i];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```
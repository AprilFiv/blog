```javascript
class LRUCache {
    
    private Map<Integer,Integer> map ;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer,Integer>(capacity,1f,true){
            @Override
	        public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){ 
		        return size()>capacity;
	        } 
        };
        
    }
    
    public int get(int key) {
        if (map.get(key)!=null){
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
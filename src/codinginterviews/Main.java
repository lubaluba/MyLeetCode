package codinginterviews;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	    	try(Scanner sc = new Scanner(System.in)){
	    		int size =sc.nextInt();
	    		LRUCache1 cache = new LRUCache1(size);
	    		while(sc.hasNext()) {
	    			String s = sc.next();
	    			if (s.contains("p")) {
	    				int i = sc.nextInt();
	    				int j = sc.nextInt();
	    				cache.put(i,j);
	    			} else if(s.contains("g")) {
	    				System.out.println(cache.get(sc.nextInt()));
	    			}
	    		}
	    	}
	    }
	}
	
	class LRUCache1{
	    private final int MAX_CACHE_SIZE;
	    int max;
	    int maxKey;
	    int size = 0;
	    private HashMap<Integer, Integer> map ;
	    private HashMap<Integer, Integer> mapCount;
	    public LRUCache1(int cacheSize) {
	        MAX_CACHE_SIZE = cacheSize;
	        map = new HashMap<>();
	        mapCount = new HashMap<>();
	        max = 0;
	        maxKey = 0;
	    }

	    public void put(Integer key, Integer value) {
	    	if (size == MAX_CACHE_SIZE) {
	    		remove();
	    	}
	       if ( ! map.containsKey(key) || map.get(key) == -1) {
	    	   size ++;
	    	   map.put(key, value);
		       mapCount.put(key, 0);
		       maxKey = key;
	       }else {
	    	   map.put(key, value);
	       }
	    }

	    private void remove() {
	    	map.put(maxKey, -1);
	    	size--;
		}

		public Integer get(Integer key) {
	        if(! map.containsKey(key)) {
	        	return -1;
	        } else {
	        	mapCount.put(key, mapCount.get(key) +1);
	        	return map.get(key);
	        }
	    }

	}
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Map myMap = new HashMap();
		
		myMap.put("keyh1", "value1");
		myMap.put("keyh2", "value2");
		myMap.put("keyh3", "value3");
		myMap.put("keyh4", "value4");
		myMap.put("keyh5", "value5");
		myMap.put("keyh6", "value6");
		myMap.put("keyh6", "value7");
		myMap.put("keyh7", "value8");
		myMap.put("keyh8", "value9");
		myMap.put("keyh9", "value10");
		myMap.put("keyh10", "value11");
		myMap.put("keyh11", "value12");
		
		
		System.out.println(myMap);
		System.out.println("keyh1 is not inserted or updated again in below example");
	    myMap.putIfAbsent("keyh1","value13");
	    System.out.println(myMap);
	    
	    myMap.remove("keyh2");
	    System.out.println("remove An entry i.e key value pair using key");
	    System.out.println(myMap);
	    
	    
	    myMap.remove("keyh3", "value4");
	    System.out.println("remove by specifying key and value pair, this method first checks "
	    		+ "whether same value is present at that specified key and only then deletes and returns true "
	    		+ "or else it returns false");
	    System.out.println(myMap);
		
	    System.out.println(myMap.entrySet());
	    Set entrySet = myMap.entrySet();
	    Iterator itr = entrySet.iterator();
	    
	    Map map2 = new HashMap();
	    
	    // putting entry from one map into other map by typecasting into  Map.Entry
	    while(itr.hasNext()) {
	    	System.out.println(itr.next());
	    	map2.put(((Map.Entry)itr.next()).getKey(),((Map.Entry)itr.next()).getValue());
	    }
	    
		
		
		
	}

}

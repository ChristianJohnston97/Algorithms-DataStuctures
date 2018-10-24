import java.util.*;
import java.lang.*;

public class Hashmap
{

	
	private class Entry
	{
		String key;
	  Integer value;
	  
	  	public Entry(String key, Integer value)
	  	{
            this.key = key;
            this.value = value;
      	}
	}

	LinkedList<Entry>[] table;   //Array of linked lists of entry.
    int capacity = 4;  //Initial capacity of HashMap


	public Hashmap()
	{
       table = new LinkedList[capacity];
    }


    public void put(String newKey, Integer data)
    {
       if(newKey==null)
           return;  
      
       //calculate hash of key.
       int hash=hash(newKey);

       //create new entry.
       Entry newEntry = new Entry(newKey, data);

      	if (table[hash] == null) 
     	{
     		table[hash] = new LinkedList<Entry>();
     		table[hash].add(newEntry);
  		}
  		else
  		{
  			table[hash].add(newEntry);
  		}     
    }


    public Integer get(String key)
    {
    	int hash = hash(key);
    	LinkedList<Entry> list =  table[hash];
    	for(Entry entry: list)
    	{
    		if(entry.key == key)
    		{
    			return entry.value;
    		}
    	}
    	return -1;
    }


    //stores entries in buckets according to their key
    public int hash(String key)
    {
        return Math.abs(key.hashCode()) % capacity;
    }

    public static void main(String[] args)
    {
    	Hashmap hashMapCustom = new Hashmap();
    	hashMapCustom.put("21", 12);
        hashMapCustom.put("33", 15);
        hashMapCustom.put("35", 89);


        int val = hashMapCustom.get("35");
        System.out.println(val);
    }




// Common methods on normal HashMaps

    public static void printMap(Map map) 
    {
      Iterator it = map.entrySet().iterator();
       while (it.hasNext()) 
       {
          Map.Entry pair = (Map.Entry)it.next();
          System.out.println(pair.getKey() + pair.getValue());
          it.remove();
      }
    }



  class ValueComparator implements Comparator<String> 
  {
    Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) 
    {
      this.map = map;
    }
    public int compare(String a, String b) 
    {
      if (map.get(a) >= map.get(b)) 
      {
         return -1;
      } 
      else 
      {
         return 1;
      } // returning 0 would merge keys
   }
  }

  public void sortMapByValue(HashMap<String, Integer> map)
  {
    ValueComparator vc = new ValueComparator(map);
    TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
      
    sortedMap.putAll(map);
  }
}


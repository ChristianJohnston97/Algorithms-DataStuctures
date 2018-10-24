import java.util.*;
import java.util.Map.*;


public class SortHashMapByValue
{
    public class ValueComparator implements Comparator<String> 
    {
        Map<String, Integer> base;
     
        public ValueComparator(Map<String, Integer> base) 
        {
            this.base = base;
        }
     
        public int compare(String a, String b) 
        {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }


    public void sort()
    {
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();

        ValueComparator vc =  new ValueComparator(countMap);

        TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
         
        sortedMap.putAll(countMap);  
    } 
}



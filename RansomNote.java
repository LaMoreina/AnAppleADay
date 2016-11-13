import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Question: Will "HELP" and "help" map to the same index?
//If so, need to account for the difference in case for this problem.

public class RansomNoteProb {
	
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String note = "";
    
    //helper function to populate hashmaps
    public Map populateMap(String str, Map map){
    	
    	map = new HashMap<String, Integer>();
    	
    	String[]words = str.split(" "); //makes sure to account for "." at the end of last word
    	for(String w: words) {
    		
    		if(map.containsKey(w)) {
    			//System.out.println("not reaching?");
    			int tempVal = (int) map.get(w);
    			tempVal++;
    			Integer i = new Integer(tempVal);
    			map.put(w, i);
    		}
    		else {
    			//System.out.println("code reaches here.");
    			map.put(w, 1);
    		}
    	}
    	
    	
		    //Pretty cool code! uncomment to print the contents of the hashmap 
			Set set = map.entrySet(); 
			Iterator i = set.iterator();
		 
			// Display elements 
			while(i.hasNext()) { 
				Map.Entry me = (Map.Entry)i.next(); //whoa! SOS! 
				System.out.print(me.getKey() + ": "); 
				System.out.println(me.getValue()); 
			}
		 
    	
    	return map;
    }
    
    public RansomNoteProb(String magazine, String note) {
    	
    	//populate maps with words and word frequencies from respective strings
    	noteMap = populateMap(note, noteMap);
    	System.out.println("\n\n");
    	magazineMap = populateMap(magazine, magazineMap);
    	this.note = note;
    	
    }
    
    public boolean solve() {
    	//if word from note is found in magazine Hashmap,
    	//then decrease the frequency by 1
    	String[]noteWords = note.split(" "); //makes sure to account for "." at the end of last word
    	for(String w: noteWords) {
    		if (magazineMap.containsKey(w)) {
    			if(magazineMap.get(w) > 0) {
    				int tempVal = (int) magazineMap.get(w);
    				tempVal--;
    				magazineMap.put(w, tempVal);
    			}
    			else {
    				return false;
    			}
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	
    	String m = "Give me one grand today night";
    	String n = "give one Grand today";
    	
    	RansomNoteProb rn = new RansomNoteProb(m,n);
    	System.out.println(rn.solve()); 
    	
    	//Map<String, Integer> mappy = new HashMap<String, Integer>();
    	//populateMap(m, mappy);
    	
    }
    
	
}
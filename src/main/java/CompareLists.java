import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.google.common.collect.Lists;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class CompareLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
		
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("2", "5", "a", "b", "1", "d", "c", "3", "f", "e"));
        Collections.reverse(listTwo);
        
        ArrayList<String> listThree = new ArrayList<>(listTwo);
        ArrayList<String> allMinor = new ArrayList<>();
        
        /*listTwo.removeAll(listOne);
        System.out.println(listTwo);
        ArrayList<String> listFour = new ArrayList<>(listOne);
        for (String value : listTwo) {
        	if(listThree.indexOf(value) == 0 || !listOne.contains(listThree.get(listThree.indexOf(value) -1))) {
        		listFour.add(listThree.indexOf(value), value);
        	} else {
        		listFour.add(listFour.indexOf(listThree.get(listThree.indexOf(value) - 1))+1, value);
        	}
        	
        }
        System.out.println(listFour);*/
        int countAddtnl = 0;
        
        for(String milestoneMnr : listOne){
			
			allMinor.add(milestoneMnr);
		
		if (listOne.contains(milestoneMnr) ) {
				continue;
			} 
		
		countAddtnl++ ;
		if(allMinor.size()>1){
			
			int pos = listOne.indexOf(allMinor.get(allMinor.size()-2));
			listOne.add(pos+1, milestoneMnr);
		}
		else{
			listOne.add(0, milestoneMnr);
		}
			
	}
        System.out.println("ALL MINOR :"+allMinor);
        
        System.out.println("Rule engine MINOR :"+listOne);
	}

}

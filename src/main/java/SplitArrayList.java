import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.suman.vsib.vsibmilestonenotification.object.model.MilestoneAttributes;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class SplitArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(10, -2, 23, 5, -11, 287, 5, -99);
		
		List<List<Integer>> result = list.stream().collect(
		    () -> Arrays.asList(new ArrayList<>(), new ArrayList<>()),
		    (l,i) -> { l.get(0).add(Math.max(0, i)); l.get(1).add(Math.min(0, i)); },
		    (a,b) -> { a.get(0).addAll(b.get(0)); a.get(1).addAll(b.get(1)); });

		System.out.println(result.get(0));
		System.out.println(result.get(1));
		
		List<MilestoneAttributes> attributeList = new ArrayList<>();
		MilestoneAttributes attrib = new MilestoneAttributes();
		attrib.setName("Type");
		attrib.setName("EVC");
		attributeList.add(attrib);
		attrib = new MilestoneAttributes();
		attrib.setName("Start");
		attrib.setName("Start001");
		attributeList.add(attrib);
		attrib = new MilestoneAttributes();
		attrib.setName("End");
		attrib.setName("End 001");
		attributeList.add(attrib);
		attrib = new MilestoneAttributes();
		attrib.setName("Start");
		attrib.setName("Start 002");
		attributeList.add(attrib);
		attrib = new MilestoneAttributes();
		attrib.setName("End");
		attrib.setName("End 002");
		attributeList.add(attrib);
	}

}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suman.test.ordermilestone.CircuitDetails;
import com.suman.test.ordermilestone.CircuitDetailsObjectModel;
import com.suman.test.ordermilestone.CustomerNotification;
import com.suman.test.ordermilestone.MinorMilestoneDetails;
import com.suman.test.ordermilestone.ErrorDetails;
import com.suman.test.ordermilestone.ErrorNotification;
import com.suman.test.ordermilestone.MilestoneAttributes;
import com.suman.test.ordermilestone.OrderMilestoneInfoObjectModel;
import com.suman.test.ordermilestone.OrderMilestoneObjectModel;
import com.suman.test.ordermilestone.VlanDetails;
import com.suman.test.ordermilestone.VlanObjectModel;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class ObjectToJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VlanObjectModel vlanObjModel = new VlanObjectModel();
		OrderMilestoneObjectModel orderMilestoneObjModel = new OrderMilestoneObjectModel();
		OrderMilestoneInfoObjectModel orderMilestoneInfoModel = new OrderMilestoneInfoObjectModel();
		CustomerNotification customerNotification = new CustomerNotification();
		ErrorDetails errDetails = new ErrorDetails();
		CircuitDetailsObjectModel cctModel = new CircuitDetailsObjectModel();
		
		List<VlanObjectModel> vlanArr = new ArrayList<VlanObjectModel>();
		vlanArr.add(vlanObjModel);
		cctModel.setCustomerEndVlan(vlanArr);
		
		List<CircuitDetailsObjectModel> cctModelList = new ArrayList<CircuitDetailsObjectModel>();
		cctModelList.add(cctModel);
		
		customerNotification.setCircuitDetails(cctModelList);
		
		List<ErrorDetails> errorList = new ArrayList<ErrorDetails>();
		errorList.add(errDetails);
		
		List<MilestoneAttributes> milestoneAttribList = new ArrayList<>();
		MilestoneAttributes milestoneAttributes = new MilestoneAttributes();
		
		milestoneAttributes.setName("Accepted Order Date");
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		milestoneAttributes.setValue(strDate);
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Accepted Order Date");
		date = Calendar.getInstance().getTime();
		strDate = dateFormat.format(date);
		milestoneAttributes.setValue(strDate);
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Rejected Order Date");
		date = Calendar.getInstance().getTime();
		strDate = dateFormat.format(date);
		milestoneAttributes.setValue(strDate);
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Scheduled Order Date");
		date = Calendar.getInstance().getTime();
		strDate = dateFormat.format(date);
		milestoneAttributes.setValue(strDate);
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Completed Order Date");
		date = Calendar.getInstance().getTime();
		strDate = dateFormat.format(date);
		milestoneAttributes.setValue(strDate);
		milestoneAttribList.add(milestoneAttributes);
		
		MinorMilestoneDetails minorMilestoneDetails = new MinorMilestoneDetails();
//		minorMilestoneDetails.setMilestoneAttributes(milestoneAttribList);
//		minorMilestoneDetails.setMilestoneAttributes(null); //(milestoneAttribList);
//		minorMilestoneDetails.getMilestoneAttributeList().add(milestoneAttribList);
		
		
		/**
		 * POPULATE ERROR SCENARIO
		 */
		milestoneAttribList = new ArrayList<>();
		ErrorNotification errorNotification = new ErrorNotification();
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("type");
		milestoneAttributes.setValue("Error");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Supp Indicator");
		milestoneAttributes.setValue("Y");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Error Code");
		milestoneAttributes.setValue("01");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Error Description");
		milestoneAttributes.setValue("Error Description1");
		milestoneAttribList.add(milestoneAttributes);
		/*errorNotification.setMilestoneAttribList(milestoneAttribList);
		minorMilestoneDetails.getErrorNotifications().add(errorNotification);*/
		minorMilestoneDetails.getMilestoneAttributeList().add(milestoneAttribList);
		
		milestoneAttribList = new ArrayList<>();
		errorNotification = new ErrorNotification();
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("type");
		milestoneAttributes.setValue("Error");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Supp Indicator");
		milestoneAttributes.setValue("N");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Error Code");
		milestoneAttributes.setValue("02");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Error Description");
		milestoneAttributes.setValue("Error Description2");
		milestoneAttribList.add(milestoneAttributes);
		
		/*errorNotification.setMilestoneAttribList(milestoneAttribList);
		minorMilestoneDetails.getErrorNotifications().add(errorNotification);
		minorMilestoneDetails.setErrorNotifications(null);*/
		minorMilestoneDetails.getMilestoneAttributeList().add(milestoneAttribList);
		/**
		 * ERROR SCENARIO ENDS
		 */
		
		/**
		 * POPULATE CIRCUIT DETAILS
		 */
		//******************UNI*************************//
		milestoneAttribList = new ArrayList<>();
		CircuitDetails circuitDetails = new CircuitDetails();
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Type");
		milestoneAttributes.setValue("UNI");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Circuit Id");
		milestoneAttributes.setValue("01");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Customer Circuit Id");
		milestoneAttributes.setValue("custCiruit UNI");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Service Order");
		milestoneAttributes.setValue("Service Order UNI");
		milestoneAttribList.add(milestoneAttributes);
				
		/*circuitDetails.setMilestoneAttribList(milestoneAttribList);
		circuitDetails.setVlanDetails(null);
		minorMilestoneDetails.getCircuitDetails().add(circuitDetails);*/
//		minorMilestoneDetails.setMilestoneAttributes(milestoneAttribList);
//		minorMilestoneDetails.getMilestoneAttributeList().add(milestoneAttribList);

		
		//******************EVC*************************//
		circuitDetails = new CircuitDetails();
		milestoneAttribList = new ArrayList<>();
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Type");
		milestoneAttributes.setValue("EVC");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Circuit Id");
		milestoneAttributes.setValue("02");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Customer Circuit Id");
		milestoneAttributes.setValue("custCiruit EVC");
		milestoneAttribList.add(milestoneAttributes);
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Service Order");
		milestoneAttributes.setValue("Service Order EVC");
		milestoneAttribList.add(milestoneAttributes);
				
//		circuitDetails.setMilestoneAttribList(milestoneAttribList);
//		minorMilestoneDetails.getMilestoneAttributeList().add(milestoneAttribList);
		
		milestoneAttribList = new ArrayList<>();
		VlanDetails vlanDetails = new VlanDetails();
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("type");
		milestoneAttributes.setValue("vlan");
		milestoneAttribList.add(milestoneAttributes);
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Start");
		milestoneAttributes.setValue("001");
		milestoneAttribList.add(milestoneAttributes);
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("End");
		milestoneAttributes.setValue("200");
		milestoneAttribList.add(milestoneAttributes);
		
		
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("Start");
		milestoneAttributes.setValue("201");
		milestoneAttribList.add(milestoneAttributes);
		milestoneAttributes = new MilestoneAttributes();
		milestoneAttributes.setName("end");
		milestoneAttributes.setValue("500");
		milestoneAttribList.add(milestoneAttributes);
//		minorMilestoneDetails.getMilestoneAttributeList().add(milestoneAttribList);
		
		/*vlanDetails.setMilestoneAttribList(milestoneAttribList);
		circuitDetails.getVlanDetails().add(vlanDetails);
		
		minorMilestoneDetails.getCircuitDetails().add(circuitDetails);*/
		
		/**
		 * END CIRCUIT DETAILS
		 */
		
		customerNotification.setMinorMilestoneDetails(minorMilestoneDetails);
		
		orderMilestoneInfoModel.setCustomerNotification(customerNotification);
		orderMilestoneInfoModel.setErrorDetails(errorList);
		orderMilestoneObjModel.setBillingAccount("0123456789");
		List<OrderMilestoneInfoObjectModel> milestoneInfoList = new ArrayList<OrderMilestoneInfoObjectModel>();
		milestoneInfoList.add(orderMilestoneInfoModel);
		orderMilestoneObjModel.setOrderMilestoneInfo(milestoneInfoList);
		/*Map<String, String> customerAttributes = new HashedMap<>();
		customerAttributes.put("attribue 1", "attrb1");
		customerAttributes.put("attribue 2", "attrb2");
		customerAttributes.put("attribue 3", "attrb3");
		customerAttributes.put("attribue 4", "attrb4");
		customerAttributes.put("attribue 5", "attrb5");
		orderMilestoneObjModel.setCustomerAttributes(customerAttributes);*/
		
		String jsonInString = "";
		try {
			jsonInString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(orderMilestoneObjModel);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonInString);

	}

}

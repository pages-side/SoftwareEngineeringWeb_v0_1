package com.commands;

import java.util.ArrayList;

import com.beans.CustomerBean;
import com.business.Customer;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCustomer;
import com.dataaccess.select.SelectCustomer;

/**
 * This class returns a list of all customers who meet a query
 *
 */
public class CustomerCommand {
	
	ArrayList<Customer> resultList = null;
	CustomerBean bean = new CustomerBean();
	SelectCustomer select = null;
	InsertCustomer insert = null;
	private int cno = -1;
	private String cName;
	private String phone;
	private String sMemberStatus;
	private String mode;
	
	String forwardingPage = null;
	
	/**
	 * an empty constructor!
	 */
	public CustomerCommand(){
		
	}
	/**feeds the query to SelectCustomer -> DbAccessor -> DbConn
	 * @return a value to tell the program its ok to move on
	 */
	public boolean execute(){
		boolean isSuccess = false;
		if("search".equals(mode)){
			select = new SelectCustomer();
			select.setCno(cno);
			select.setcName(cName);
			select.setPhone(phone);
			select.setsMemberStatus(sMemberStatus);
			
			if(!select.execute()){
				System.out.println(select.getErrorMessage());
				forwardingPage = "error.jsp";
				return false;
			}else{
				resultList = select.getCustomerList();
				bean.setCustomerList(resultList);
				for(int ii=0; ii<resultList.size(); ii++){
					System.out.println(resultList.get(ii).toString());
				}
				isSuccess = true;
			}
			if(select.isAll()){
				forwardingPage = "showCustomers.jsp";
			}else{
				forwardingPage = "showCustomerSearch.jsp";
			}
		}else{
			insert = new InsertCustomer();
			insert.setCno(cno);
			insert.setcName(cName);
			insert.setMemberStatus(sMemberStatus);
			
			if(!insert.execute()){
				System.out.println(insert.getErrorMessage());
				forwardingPage = "error.jsp";
				return false;
			}else{
				resultList = insert.getCustomerList();
				bean.setCustomerList(resultList);
				for(int ii=0; ii<resultList.size(); ii++){
					System.out.println(resultList.get(ii).toString());
				}
				isSuccess = true;
			}
			
			forwardingPage = "showCustomerSearch.jsp";
			
		}
		return isSuccess;
	}
	/**This method uses a for loop and the CommandParameter to get needed attributes from the database
	 * @param params
	 */
	public void setParameters(ArrayList<CommandParameter>params){
		if(params != null && !params.isEmpty()){
			for(int ii=0; ii< params.size(); ii++){
				if("cno".equals(params.get(ii).getName())){
					cno = Integer.parseInt(params.get(ii).getValue());
				}
				if("cName".equals(params.get(ii).getName())){
					cName = params.get(ii).getValue();
				}
				if("phone".equals(params.get(ii).getName())){
					phone = params.get(ii).getValue();
				}
				if("memberStatus".equals(params.get(ii).getName())){
					sMemberStatus = params.get(ii).getValue();
				}
				if("mode".equals(params.get(ii).getName())){
					mode = params.get(ii).getValue();
				}
			}
		}
	}
	/**
	 * @return the cno
	 */
	public int getCno() {
		return cno;
	}
	/**
	 * @param cno the cno to set
	 */
	public void setCno(int cno) {
		this.cno = cno;
	}
	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}
	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the sMemberStatus
	 */
	public String getsMemberStatus() {
		return sMemberStatus;
	}
	/**
	 * @param sMemberStatus the sMemberStatus to set
	 */
	public void setsMemberStatus(String sMemberStatus) {
		this.sMemberStatus = sMemberStatus;
	}
	
}

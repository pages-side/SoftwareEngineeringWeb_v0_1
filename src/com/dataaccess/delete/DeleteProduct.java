package com.dataaccess.delete;

import com.dataaccess.DbAccessor;

public class DeleteProduct extends DbAccessor{
	
	String pno = null;
	
	public DeleteProduct(){}
	
	public DeleteProduct(String pno){
		this.pno = pno;
	}
	
	public boolean execute(){
		StringBuilder sb = new StringBuilder("");
		sb.append("delete from s_product where pno='");
		sb.append(this.pno);
		sb.append("'");
		setQuery(sb.toString());
		return super.execute();
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}
	
	
}

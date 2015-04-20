package com.command.parameters;

/**
 * This class is used in a for loop for all queries and .jsps to set parameters 
 *
 */
public class CommandParameter {

	private String name = null;
	private String value = null;
	
	public CommandParameter(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * A string builder for developers use
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandParameter [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
	
}

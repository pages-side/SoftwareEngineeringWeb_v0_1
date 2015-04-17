package com.gui;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

		public class MyModel extends DefaultTableModel 
		{

		private ArrayList<ArrayList<Boolean>> editable_cells;
		   
		public MyModel(Object[] objects, int i) 
		   {
		      super(objects, i);
		      this.editable_cells = new ArrayList<ArrayList<Boolean>>();
		   }

		    public boolean isCellEditable(int row, int column) {
		    	return this.editable_cells.get(row).get(column);
		    }
		    
		    public void addCell(int row, int col, boolean value){
		    	this.editable_cells.add(new ArrayList<Boolean>());
		    	this.editable_cells.get(row).add(col, value);
		    }
		    public void setCellEditable(int row, int col, boolean value) {
		    	System.out.println("" + row + col + value);
		        this.editable_cells.get(row).set(col, value);
		        this.fireTableCellUpdated(row, col);
		    }
		}
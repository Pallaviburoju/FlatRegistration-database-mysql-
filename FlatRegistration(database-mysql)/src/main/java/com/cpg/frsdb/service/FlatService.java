package com.cpg.frsdb.service;

import java.util.ArrayList;

import com.cpg.frsdb.dao.FlatDAO;
import com.cpg.frsdb.dao.IFlatDAO;
import com.cpg.frsdb.dto.FlatDTO;
import com.cpg.frsdb.utility.CustomAmountException;
import com.cpg.frsdb.utility.CustomizedException;

public class FlatService implements IFlatService{
	 FlatDTO dto=new FlatDTO();
	 IFlatDAO dao=new FlatDAO();
	 boolean value;
		
		//validation method
		public boolean validation(int ownerId, int deposit,int rent) {
			value=true;
			int count=0;
			ArrayList<Integer> array=new ArrayList<Integer>();
			array=dao.getAllOwnerIds();
			

			//checking the entered ownerid with the ownerid present in the map
			for(int i=0;i<array.size();i++) {
				if((array.get(i) == ownerId)){
					count++;
				}
			}
			//if there is no ownerid exception is thrown
			if(count == 0) {
				try {
					value=false;
					throw new CustomizedException();
				} catch (CustomizedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			//if deposit amount is less than the rent exception is throw
			
			if(deposit<rent) {
				try {
					value=false;
					throw new CustomAmountException();
				} catch (CustomAmountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return value;
		}
		
		public ArrayList<Integer> getAllOwnerIds() {
			
			return dao.getAllOwnerIds();
		}
		
		public FlatDTO registerFlat(FlatDTO flat) {
			// TODO Auto-generated method stub
			return dao.registerFlat(flat);
		}
		
}

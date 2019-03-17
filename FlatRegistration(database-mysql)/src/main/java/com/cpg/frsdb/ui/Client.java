package com.cpg.frsdb.ui;

import java.util.Scanner;

import com.cpg.frsdb.dto.FlatDTO;
import com.cpg.frsdb.service.FlatService;
import com.cpg.frsdb.service.IFlatService;

public class Client {
	static FlatDTO dto=new FlatDTO();
	static FlatDTO pojo=new FlatDTO();
	static IFlatService service=new FlatService();
	static FlatService fs=new FlatService();
		
		public static void main(String args[]) {
			do {
			Scanner scan=new Scanner(System.in);
			System.out.println("1. Register Flat\n2. Exit");
			int ch;
			ch=scan.nextInt();
			
			switch(ch) {
				case 1:	 //displaying existing owner ids
						System.out.println("Existing owner ids are:"+service.getAllOwnerIds());
						//taking field values from user
						System.out.println("please enter owner id from above list:");
				        dto.setOwner_id(scan.nextInt());
				        System.out.println("Select FlatType (1-1BHK, 2-2BHK)");
				        dto.setFlat_type(scan.nextInt());
				        System.out.println("Enter Flat area in sq. ft");
				        dto.setFlat_area(scan.nextInt());
				        System.out.println("Enter desired rent amount Rs:");
				        dto.setRent_amount(scan.nextInt());
				        System.out.println("Enter desired deposit amount Rs:");
				        dto.setDeposit_amount(scan.nextInt());
				       
				        /*calling validation method to check whether the owner is present or not and
				        to check if deposit amount is more than rent amount*/
				        
				         boolean y= fs.validation(dto.getOwner_id(),dto.getDeposit_amount(),dto.getRent_amount());
				        
						 //calling this method to store details and return registration id
				         
				         if(y) {
				        	 
				        	 pojo=service.registerFlat(dto);
				         }
				         System.out.println("Flat successfully registered. Registration id:" + pojo.getFlat_reg_no());
				        break;
				case 2:	System.exit(0);
				        break;
			}
			
			}while(true);
		}
}

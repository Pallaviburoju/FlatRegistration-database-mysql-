package com.cpg.frsdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cpg.frsdb.dto.FlatDTO;
import com.cpg.frsdb.utility.DatabaseConnection;

public class FlatDAO implements IFlatDAO {
	FlatDTO flat=new FlatDTO();
	DatabaseConnection data=new DatabaseConnection();
	Connection con=data.connect();
	
	
	public ArrayList<Integer> getAllOwnerIds() {
		ArrayList<Integer> arraylist=new ArrayList<Integer>();
	try {
			PreparedStatement ts=con.prepareStatement("select OWNER_ID from FLAT_OWNERS");
			ResultSet rs=ts.executeQuery();
			while(rs.next()) {
				arraylist.add(rs.getInt(1));
			}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return arraylist;
	}
	
	public FlatDTO registerFlat(FlatDTO flat) {
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into Flat_Registration "
					+ "(OWNER_ID,FLAT_TYPE,FLAT_AREA,RENT_AMOUNT,DEPOSIT_AMOUNT)"
					+ "values(?,?,?,?,?);");
			
			ps.setInt(1, flat.getOwner_id());
			ps.setInt(2, flat.getFlat_type());
			ps.setInt(3, flat.getFlat_area());
			ps.setInt(4, flat.getRent_amount());
			ps.setInt(5, flat.getDeposit_amount());
			int x=ps.executeUpdate();
			
			if(x==1) {
			PreparedStatement ps1 = con.prepareStatement("select FLAT_REG_NO from Flat_Registration where OWNER_ID=?");
			
			ps1.setInt(1, flat.getOwner_id());
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
			    flat.setFlat_reg_no((rs1.getInt(1)));
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flat;
		
	}
}

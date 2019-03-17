package com.cpg.frsdb.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.cpg.frsdb.dto.FlatDTO;

class FlatDAOTest {
    
	FlatDAO dao=new FlatDAO();
    FlatDTO dto=new FlatDTO();
    
	@Test
	void testGetAllOwnerIds() {
		ArrayList arraylist=new ArrayList();
		arraylist.add(1);
		arraylist.add(2);
		arraylist.add(3);
		assertEquals(arraylist,dao.getAllOwnerIds());        
	}

	@Test
	void testRegisterFlat() {
		dto.setDeposit_amount(2000);
		dto.setFlat_area(100);
		dto.setFlat_type(1);
		dto.setOwner_id(1);
		dto.setRent_amount(1000);
		assertEquals(1028,dao.registerFlat(dto).getFlat_reg_no());
	}

}

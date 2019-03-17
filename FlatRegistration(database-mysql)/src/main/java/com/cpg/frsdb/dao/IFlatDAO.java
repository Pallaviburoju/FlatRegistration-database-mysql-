package com.cpg.frsdb.dao;

import java.util.ArrayList;

import com.cpg.frsdb.dto.FlatDTO;

public interface IFlatDAO {
	FlatDTO registerFlat(FlatDTO flat);
	ArrayList<Integer> getAllOwnerIds();
}

package com.cpg.frsdb.service;

import java.util.ArrayList;

import com.cpg.frsdb.dto.FlatDTO;

public interface IFlatService {
	FlatDTO registerFlat(FlatDTO flat);
	ArrayList<Integer> getAllOwnerIds();
}

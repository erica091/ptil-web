package com.pactera.ptil.web.service.modules.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pactera.ptil.web.dto.OwnerDto;
import com.pactera.ptil.web.dto.PetsDto;
import com.pactera.ptil.web.service.modules.PetsService;
import com.pactera.ptil.web.utils.Constants;

@Service
public class PetsServiceImpl implements PetsService {

	/**
	 * 
	* <p>Title: getCatsList</p>  
	* <p>Description: Output a list of all the cats in alphabetical order under a heading of the gender of their owners</p>  
	* @param ownerList
	* @return  
	 */
	@Override
	public Map<String, List<String>> getCatsList(OwnerDto[] ownerList) {
		Map<String, List<String>> catsMap = new HashMap<>();
		List<String> maleCatsList = new ArrayList<>();
		List<String> femaleCatsList = new ArrayList<>();
		for (int i = 0; i < ownerList.length; i++) {
			if (ownerList[i].getPets() != null && !ownerList[i].getPets().isEmpty()) {
				for (PetsDto pet : ownerList[i].getPets()) {
					if (Constants.CAT.equals(pet.getType()) && Constants.MALE.equals(ownerList[i].getGender())) {
						maleCatsList.add(pet.getName());
					}
					if (Constants.CAT.equals(pet.getType()) && Constants.FEMALE.equals(ownerList[i].getGender())) {
						femaleCatsList.add(pet.getName());
					}
				}
			}
		}
		if(!maleCatsList.isEmpty()) {
			//In alphabetical order
			Collections.sort(maleCatsList, String.CASE_INSENSITIVE_ORDER);
			catsMap.put(Constants.MALE, maleCatsList);
 
		}
		if(!femaleCatsList.isEmpty()) {
			//In alphabetical order
			Collections.sort(maleCatsList, String.CASE_INSENSITIVE_ORDER);
			catsMap.put(Constants.FEMALE, femaleCatsList);
		}
		return catsMap;
	}

}

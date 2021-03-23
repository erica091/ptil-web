package com.pactera.ptil.web.service.modules;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pactera.ptil.web.PtilWebApplication;
import com.pactera.ptil.web.dto.OwnerDto;
import com.pactera.ptil.web.dto.PetsDto;
import com.pactera.ptil.web.utils.Constants;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = PtilWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PetsServiceTest {

	@Autowired
	private PetsService petsService;
	
	OwnerDto[] ownerList = new OwnerDto[3];
	
	@Before
	public void init(){
		
		OwnerDto ownerDto1 = new OwnerDto();
		ownerDto1.setName("Bob");
		ownerDto1.setAge(20);
		ownerDto1.setGender("Male");
		List<PetsDto> pets1 = new ArrayList<>();
		PetsDto petsDto1= new PetsDto();
		petsDto1.setName("Molly");
		petsDto1.setType("cat");
		pets1.add(petsDto1);
		PetsDto petsDto2= new PetsDto();
		petsDto2.setName("Bob");
		petsDto2.setType("cat");
		pets1.add(petsDto2);
		ownerDto1.setPets(pets1);
		ownerList[0] = ownerDto1;
		
		OwnerDto ownerDto2 = new OwnerDto();
		ownerDto2.setName("Amy");
		ownerDto2.setAge(20);
		ownerDto2.setGender("Female");
		List<PetsDto> pets2 = new ArrayList<>();
		PetsDto petsDto21= new PetsDto();
		petsDto21.setName("Angle");
		petsDto21.setType("cat");
		pets2.add(petsDto21);
		PetsDto petsDto22= new PetsDto();
		petsDto22.setName("fff");
		petsDto22.setType("dog");
		pets2.add(petsDto22);
		ownerDto2.setPets(pets2);
		ownerList[1] = ownerDto2;
		
		OwnerDto ownerDto3 = new OwnerDto();
		ownerDto3.setName("Ares");
		ownerDto3.setAge(20);
		ownerDto3.setGender("Male");
		List<PetsDto> pets3 = new ArrayList<>();
		PetsDto petsDto31= new PetsDto();
		petsDto31.setName("Tigger");
		petsDto31.setType("cat");
		pets3.add(petsDto31);
		ownerDto3.setPets(pets3);
		ownerList[2] = ownerDto3;
    }
	
	@Test
	public void getCatsListTest() {
		
		Map<String, List<String>> catsMap = petsService.getCatsList(ownerList);
		
		Map<String, List<String>> expectResult = new HashMap<>();
		List<String> maleList = new ArrayList<>();
		maleList.add("Bob");
		maleList.add("Molly");
		maleList.add("Tigger");
		expectResult.put(Constants.MALE, maleList);
		List<String> femaleList = new ArrayList<>();
		femaleList.add("Angle");
		expectResult.put(Constants.FEMALE, femaleList);
		
		assertEquals(expectResult, catsMap);  
	}


}

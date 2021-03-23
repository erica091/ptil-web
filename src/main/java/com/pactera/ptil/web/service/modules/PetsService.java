package com.pactera.ptil.web.service.modules;

import java.util.List;
import java.util.Map;

import com.pactera.ptil.web.dto.OwnerDto;

public interface PetsService {

	Map<String, List<String>> getCatsList(OwnerDto[] ownerList);


}

package com.web.portal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.portal.entity.Station;
import com.web.portal.model.response.StationResponse;
import com.web.portal.repository.StationRepository;

@Service
public class StationMasterService {
	
	@Autowired
	StationRepository stationRepo;
	
	public List<StationResponse> getAllStations(){
		
		List<Station> stationList = stationRepo.findAll();
		return stationList.stream().map(x -> createStationList(x)).collect(Collectors.toList());
	}
	
	private StationResponse createStationList(Station station) {
		StationResponse response = new StationResponse();
		response.setLabel(station.getStationName());
		response.setValue(station.getStationName());
		return response;
	}
}

package com.web.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.web.portal.constants.Endpoints;
import com.web.portal.model.response.StationResponse;
import com.web.portal.service.StationMasterService;

@RestController
@Controller
public class TicketController {
	
	@Autowired
	StationMasterService stationMasterService;
	
	/* Get list of all station */
	@GetMapping(path = Endpoints.API_ROOT + "/stations")
	public List<StationResponse> getStationList() {
		return stationMasterService.getAllStations();
	}
	
	
}

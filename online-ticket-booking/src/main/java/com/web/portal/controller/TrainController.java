package com.web.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.portal.constants.Endpoints;
import com.web.portal.model.request.TrainRequest;
import com.web.portal.model.response.TrainResponse;
import com.web.portal.service.TrainMasterService;

@RestController
@Controller
public class TrainController {
	
	@Autowired
	TrainMasterService trainMasterService; 
	
	/* Get the details of all train to and from */
	@PostMapping(path = Endpoints.API_ROOT + "/getTrains")
	public List<TrainResponse> getTrainDetails( @RequestBody TrainRequest trainRequest){
		return trainMasterService.getTrainDetais(trainRequest);
	}
}

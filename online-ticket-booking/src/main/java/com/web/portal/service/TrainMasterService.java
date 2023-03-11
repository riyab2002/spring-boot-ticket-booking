package com.web.portal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.portal.constants.DaysOfWeek;
import com.web.portal.entity.TrainSchedule;
import com.web.portal.model.request.TrainRequest;
import com.web.portal.model.response.TrainResponse;
import com.web.portal.repository.StationRepository;
import com.web.portal.repository.TrainMasterRepository;
import com.web.portal.repository.TrainScheduleRepository;
import com.web.portal.repository.TrainTimingsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrainMasterService {
	
	@Autowired
	TrainMasterRepository trainMasterRepo;
	
	@Autowired
	TrainScheduleRepository trainScheduleRepo;
	
	@Autowired
	TrainTimingsRepository trainTimingRepository;
	
	@Autowired
	StationRepository stationRepo;
	
	public List<TrainResponse> getTrainDetais(TrainRequest trainRequest) {
		LocalDateTime date = trainRequest.getDate();
		Map<String,String> days = DaysOfWeek.getDaysOfWeek();
		String day = days.get(date.getDayOfWeek().name().toString());
		List<TrainSchedule> trainList = trainScheduleRepo.findAll();
		//log.info(trainList.toString());
		//log.info("DAY: "+day);
		List<Integer> activeTrains = getTrainNumbersActive(trainList,day);
		//log.info("TRAINS ACTIVE: "+activeTrains);
		int toId = stationRepo.findByStationName(trainRequest.getTo()).getId();
		int fromId = stationRepo.findByStationName(trainRequest.getFrom()).getId();
		log.info("********");
		List<TrainResponse> availableTrains = new ArrayList<>();
		if(toId > fromId) {
			activeTrains.stream().forEach(trainNo -> {
				TrainResponse train = new TrainResponse();
				train.setTrainnNo(trainNo);
				log.info("********1");
				train.setArrival(trainTimingRepository.findByStationId(trainNo,toId).getUpTime());
				log.info("********2");
				train.setDept(trainTimingRepository.findByStationId(trainNo,fromId).getUpTime());
				log.info("********3");
				train.setTrainName(trainMasterRepo.findByTrainNo(trainNo).getTrain_name());
				log.info("********4");
				availableTrains.add(train);
				log.info(train.toString());
			});
			return availableTrains;
		}
		else {
			activeTrains.stream().forEach(trainNo -> {
				TrainResponse train = new TrainResponse();
				train.setTrainnNo(trainNo);
				train.setArrival(trainTimingRepository.findByStationId(trainNo,fromId).getDownTime());
				train.setDept(trainTimingRepository.findByStationId(trainNo,toId).getDownTime());
				train.setTrainName(trainMasterRepo.findByTrainNo(trainNo).getTrain_name());
				availableTrains.add(train);
			});
			return availableTrains;
		}
	}
	
	private List<Integer> getTrainNumbersActive(List<TrainSchedule> trainList, String day){
		List<Integer> activeTrains = new ArrayList<>();
		trainList.stream().forEach(train -> {
			Map<String,Integer> daysActive = new HashMap<>();
			daysActive.put("mon", train.getMon());
			daysActive.put("tue", train.getTue());
			daysActive.put("wed", train.getWed());
			daysActive.put("thur", train.getThur());
			daysActive.put("fri", train.getFri());
			daysActive.put("sat", train.getSat());
			daysActive.put("sun", train.getSun());
			if(daysActive.get(day)==1) {
				activeTrains.add(train.getTrain_no());
			}
		});
		return activeTrains;
	}
}

package com.web.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.portal.entity.TrainTimings;

public interface TrainTimingsRepository extends JpaRepository<TrainTimings, Integer> {
	
	@Query(value="Select * from train_timings t where t.train_no = ?1 and t.station_id = ?2",nativeQuery = true)
	public TrainTimings findByStationId(Integer trainNo, Integer stationId);
}


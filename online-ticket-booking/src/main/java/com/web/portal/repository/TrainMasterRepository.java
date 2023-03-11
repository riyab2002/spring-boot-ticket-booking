package com.web.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.portal.entity.TrainMaster;

public interface TrainMasterRepository extends JpaRepository<TrainMaster, Integer>{

	public TrainMaster findByTrainNo(Integer trainNo);
}

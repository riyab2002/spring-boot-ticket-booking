package com.web.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.portal.entity.TrainSchedule;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Integer> {
}

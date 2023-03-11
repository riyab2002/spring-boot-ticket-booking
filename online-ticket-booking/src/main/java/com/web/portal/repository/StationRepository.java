package com.web.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.portal.entity.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

	List<Station> findAll();

	Station findByStationName(String stationName);
}

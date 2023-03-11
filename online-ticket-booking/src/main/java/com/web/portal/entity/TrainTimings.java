package com.web.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "train_timings")
public class TrainTimings {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "train_no")
	private int trainNo;
	
	@Column(name = "station_id")
	private int stationId;
	
	@Column(name = "up_time")
	private String upTime;
	
	@Column(name = "down_time")
	private String downTime;
}

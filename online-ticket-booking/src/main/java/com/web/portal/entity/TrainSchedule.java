package com.web.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "train_schedule")
public class TrainSchedule {
	
	@Id
	@Column(name ="train_no")
	private int train_no;
	
	@Column(name ="mon")
	private int mon;
	
	@Column(name ="tue")
	private int tue;
	
	@Column(name ="wed")
	private int wed;
	
	@Column(name ="thur")
	private int thur;
	
	@Column(name ="fri")
	private int fri;
	
	@Column(name ="sat")
	private int sat;
	
	@Column(name ="sun")
	private int sun;
	
}

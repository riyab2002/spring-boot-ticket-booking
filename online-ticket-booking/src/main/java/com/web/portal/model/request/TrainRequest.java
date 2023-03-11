package com.web.portal.model.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TrainRequest {
	private String to;
	private String from;
	private LocalDateTime date;
}

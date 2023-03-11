package com.web.portal.constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DaysOfWeek {
	
	public static Map<String,String> getDaysOfWeek() {
		return Stream.of(new String[][] {
			  { "MONDAY","mon" }, 
			  { "TUESDAY","tue" }, 
			  { "WEDNESDAY","wed"},
			  { "THURSDAY","thur"},
			  { "FRIDAY","fri"},
			  {"SATURDAY","sat"},
			  {"SUNDAY","sun"}
			}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
	}
}

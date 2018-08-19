package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

public class TimeConverterImpl implements TimeConverter{

	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
		// this list will contain splitted time in hours : minutes :seconds
		List<Integer> timeParts = new ArrayList<Integer>();
		for(String time : aTime.split(":"))
		{
			timeParts.add(Integer.parseInt(time));
		}
		String seconds = getSeconds(timeParts.get(2));
		String firstLineHours = getFirstLineHours(timeParts.get(0));
		String secondLineHours = getSecondLineHours(timeParts.get(0));
		String firstLineMinutes = getFirstLineMinutes(timeParts.get(1));
		String secondLineMinutes = getSecondLineMinutes(timeParts.get(1));
		
		String berlinClockString = seconds.concat("\n").concat(firstLineHours).concat("\n").
				concat(secondLineHours).concat("\n").concat(firstLineMinutes).concat("\n").concat(secondLineMinutes);
		return berlinClockString;
	}
	
	private int getTopSignals(int value)
	{
		return (value - (value % 5)) / 5;
	}
	
	private String checkOnOffStatus(int lights, int signals)
	{
		return checkOnOffStatus( lights,  signals, "R");
	}
	
	private String checkOnOffStatus(int lights, int signals, String signalValue)
	{
		String value = "" ;
		for(int i=0; i<signals ; i++)
		{
			value +=signalValue;
		}
		for(int i =0 ; i < (lights- signals); i++)
		{
			value +="O";
		}
		return value ;
	}
	
	public String getSeconds(int secondsNumner)
	{
		if(secondsNumner %2 == 0){
			return "Y";
		}
		else{
			return "O";
		}
	}
	
	public String getFirstLineHours(int hoursNumber)
	{
		 return checkOnOffStatus(4, getTopSignals(hoursNumber)) ;
	}
	
	public String getSecondLineHours(int hoursNumber)
	{
		 return checkOnOffStatus(4, hoursNumber % 5) ;
	}
	
	public String getFirstLineMinutes(int minutesNumber)
	{
		 return checkOnOffStatus(11, getTopSignals(minutesNumber), "Y").replaceAll("YYY", "YYR");
	}
	
	public String getSecondLineMinutes(int minutesNumber)
	{
		return checkOnOffStatus(4, minutesNumber % 5, "Y");
	}

}

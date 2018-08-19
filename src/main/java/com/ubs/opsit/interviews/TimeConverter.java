package com.ubs.opsit.interviews;

public interface TimeConverter {

    String convertTime(String aTime);
    String getSeconds(int secondsNumner);
    String getFirstLineHours(int hoursNumber);
    String getSecondLineHours(int hoursNumber);
    String getFirstLineMinutes(int minutesNumber);
    String getSecondLineMinutes(int minutesNumber);
}

package com.example.study.utils;

import java.sql.Timestamp;

public class Date2Timestamp {
	public static Timestamp getTimestamp(int year,int month,int day,int hour,int minute,int second)
	{
		String timestampString = date2String(year, month, day, hour, minute, second);
		Timestamp timestamp = Timestamp.valueOf(timestampString);
		return timestamp;
	}
	private static String date2String(int year,int month,int day,int hour,int minute,int second)
    {
    	StringBuffer string = new StringBuffer();
    	string.append(year);
    	string.append("-");
    	string.append(dealWithNumber(month));
    	string.append("-");
    	string.append(dealWithNumber(day));
    	string.append(" ");
    	string.append(dealWithNumber(hour));
    	string.append(":");
    	string.append(dealWithNumber(minute));
    	string.append(":");
    	string.append(dealWithNumber(second));
    	return string.toString();
    }
	private static String dealWithNumber(int number)
    {
    	if(number>9)
    	{
    		return number + "";
    	}
    	else {
			return "0" + number;
		}
    }
}

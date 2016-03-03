package com.wisc.cs.klay2.k2calendar;

import java.util.Calendar;
//608 280 2522 natalie
/**
 * Created by klay2 on 3/3/16.
 */
public class Event implements Comparable<Event>{
    private String name;
    private Calendar dateTime;
    //extra functionality maybe type like school/work/social etc change color of day


    public Event(){
        this.name = null;
        this.dateTime = null;
    }
    public Event(String nameIn, Calendar dateTimeIn){
        this.name = nameIn;
        this.dateTime = dateTimeIn;

    }

    public void setName(String nameIn){
        this.name = nameIn;
    }

    public void setDateTime(Calendar dateTimeIn){
        this.dateTime = dateTimeIn;
    }

    public String toString(){
        return name + " at " + dateTime.getTime();
    }



    @Override
    public int compareTo(Event another) {
       // TODO: implement event compareto by comparing dates and check for nulls
        return 0;
    }
}

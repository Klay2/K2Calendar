package com.wisc.cs.klay2.k2calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class CalendarActivity extends AppCompatActivity {
    ArrayList<List<Event>> daysEvents;
    //an array  list 366 large one slot for each day of the year
    //each slot can hold a list of events

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        daysEvents = new ArrayList<List<Event>>(366);

    }

    //TODO:  handle user selects a day and clicks view day goto viewdayactivity

    //TODO: method to delete a selected event

    //TODO: method to edit a selected event

    //method to add a new event to a selected day.  gets passed in
    //a calendar date time so it doesnt have to hadle specific parsing/input etc
    public void createEvent(String name,Calendar dateTime){
        int day = dateTime.get(Calendar.DAY_OF_YEAR);
        Event eventNew = new Event(name,dateTime);
        if(daysEvents.get(day) == null){//empty day, create new event list
            List<Event> EventsNew = new ArrayList<Event>();
            EventsNew.add(eventNew);
            daysEvents.add(day,EventsNew);
        }
        else{//day already has events add and sort
            List<Event> EventsPresent;
            EventsPresent = daysEvents.get(day);
            EventsPresent.add(eventNew);
            Collections.sort(EventsPresent);

        }

    }
}

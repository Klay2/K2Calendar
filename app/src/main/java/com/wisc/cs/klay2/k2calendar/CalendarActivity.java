package com.wisc.cs.klay2.k2calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class CalendarActivity extends AppCompatActivity {
    ArrayList<ArrayList<Event>> daysEvents;
    //an array  list 366 large one slot for each day of the year
    //each slot can hold a list of events

    CalendarView myCalender;
    Calendar selectedDay;
    Button viewDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        daysEvents = new ArrayList<ArrayList<Event>>(366);
        myCalender = (CalendarView) findViewById(R.id.calendarView);
        selectedDay = Calendar.getInstance();
        viewDay = (Button) findViewById(R.id.view_day_button);


        myCalender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();

                selectedDay.set(year, month, dayOfMonth);

            }
        });

        View.OnClickListener viewDayClick = new View.OnClickListener(){
            public void onClick(View v){
            startViewDayActivity();//


            }

        }

        ;

    }




    //returns a list of events for either day on startup or user selected day
    //can return null if there have been no events created... just fyi
    public List<Event> getEvents(){
        List<Event> listOfEvents;
        listOfEvents = daysEvents.get(selectedDay.get(Calendar.DAY_OF_YEAR));
        return listOfEvents;

    }
    //TODO:  handle user selects a day and clicks view day goto viewdayactivity

    //TODO: method to delete a selected event
    //somehow get selected item from array list in fragment in onclick listener

    //TODO: method to edit a selected event

    public void startViewDayActivity(){
        Intent go = new Intent(this,ViewDayActivity.class);
        startActivityForResult(go);//TODO: finish the start activity for result

    }

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

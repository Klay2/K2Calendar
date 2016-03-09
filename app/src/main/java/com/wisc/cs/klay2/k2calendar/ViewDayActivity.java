package com.wisc.cs.klay2.k2calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;

import java.util.List;

//view events for this day in a fragment or call up create/edit/delete event fragment

//make this a child activity of calendaractivity then getparent to call methods
public class ViewDayActivity extends AppCompatActivity {
    List<Event> Events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_day);


        Fragment viewDay;
        Fragment createEvent;



        viewDay = new Fragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.view_day_frag_frame,viewDay)
                .addToBackStack(null)
                .commit();
    }
}

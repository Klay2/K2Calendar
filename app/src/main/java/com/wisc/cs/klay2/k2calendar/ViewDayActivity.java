package com.wisc.cs.klay2.k2calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//view events for this day in a fragment or call up create/edit/delete event fragment

//make this a child activity of calendaractivity then getparent to call methods
public class ViewDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_day);
    }
}

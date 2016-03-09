package com.wisc.cs.klay2.k2calendar;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.GregorianCalendar;
//608 280 2522 natalie call when meds are prescribed
/**
 * Created by klay2 on 3/3/16.
 */
public class Event implements Parcelable,Comparable<Event> {
    private String name;
    int dayOfYear;
    int year;
    int monthOfYear;
    int dayOfMonth;
    int hour;
    int minute;

    //extra functionality maybe type like school/work/social etc change color of day


    public Event(){
        this.name = null;
        this.dayOfYear = -1;
        this.monthOfYear = -1;
        this.dayOfMonth = -1;
        this.year = -1;
        this.hour = -1;
        this.minute = -1;
    }

    public Event(String nameIn, int year,int month,int dayOfMonth, int hour, int minute){
        this.name = nameIn;
        this.year = year;
        this.monthOfYear = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.minute = minute;
        Calendar tempCal = new GregorianCalendar();
        tempCal.set(year,month,dayOfMonth);
        dayOfYear = tempCal.get(Calendar.DAY_OF_YEAR);



    }




    protected Event(Parcel in) {
        name = in.readString();
        dayOfYear = in.readInt();
        year = in.readInt();
        monthOfYear = in.readInt();
        dayOfMonth = in.readInt();
        hour = in.readInt();
        minute = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public void setName(String nameIn){
        this.name = nameIn;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMonth(int month){
        this.monthOfYear = month;
        Calendar tempCal = new GregorianCalendar();
        tempCal.set(year,monthOfYear,dayOfMonth);
        dayOfYear = tempCal.get(Calendar.DAY_OF_YEAR);
    }

    public void setDay(int day){
        this.dayOfMonth = day;
        Calendar tempCal = new GregorianCalendar();
        tempCal.set(year,monthOfYear,dayOfMonth);
        dayOfYear = tempCal.get(Calendar.DAY_OF_YEAR);

    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public void setMinute(int minute){
        this.minute = minute;
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }





    public String toString(){
        return name + " at " + hour +":"+minute ;
    }



    @Override
    public int compareTo(Event another) {
       // TODO: implement event compareto by comparing dates and check for nulls
        int hourDiff;
        int minuteDiff;
        hourDiff = hour - another.getHour();
        minuteDiff = minute - another.getMinute();
        if(hourDiff == 0){
            return minuteDiff;
        }else {
            return hourDiff;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeInt(dayOfYear);
        dest.writeInt(year);
        dest.writeInt(monthOfYear);
        dest.writeInt(dayOfMonth);
        dest.writeInt(hour);
        dest.writeInt(minute);

    }

    public static final Parcelable.Creator<Event> CREATOR
            = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return new Event[size];
        }
    };



}

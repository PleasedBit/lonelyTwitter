package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */

public abstract class Mood {
    private Date date;

    //Constructors
    public Mood() {
        this.date = new Date(); //No date given, create a new Date object to get today's date.
    }

    public Mood(Date date) {
        this.date = date; //date given
    }

    //Date getter/setter
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getMood();

}

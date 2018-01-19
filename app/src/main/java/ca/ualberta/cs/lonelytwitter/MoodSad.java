package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */

public class MoodSad extends Mood {

    public MoodSad() {
        super();
    }

    public MoodSad(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        return "Sad";
    }
}

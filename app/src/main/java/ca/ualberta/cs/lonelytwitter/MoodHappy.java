package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */

public class MoodHappy extends Mood {

    public MoodHappy() {
        super();
    }

    public MoodHappy(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        return "Happy";
    }
}

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */

public class NormalTweet extends Tweet {

    public NormalTweet(String msg) {
        super(msg);
    }

    public NormalTweet(String msg, Date date) {
        super(msg, date);
    }


    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}

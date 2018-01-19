package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */

public class ImportantTweet extends Tweet {

    public ImportantTweet(String msg) {
        super(msg);
    }

    public ImportantTweet(String msg, Date date) {
        super(msg, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }


}

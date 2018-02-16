package ca.ualberta.cs.lonelytwitter;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Craig on 2018-02-15.
 */

public class tweetComparator implements Comparator<Tweet> {
    public int compare(Tweet t1, Tweet t2) {
        return t1.getDate().compareTo(t2.getDate());
    }
}

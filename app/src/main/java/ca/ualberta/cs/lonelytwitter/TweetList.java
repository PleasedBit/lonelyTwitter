package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Craig on 2018-02-15.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException(); //Lab assignment
        }
        tweets.add(tweet);
    }

    public Boolean hasTweet(Tweet tweet) {

        for (Tweet each: tweets) {
            if (each.equals(tweet)) { return Boolean.TRUE; }
        }

        return Boolean.FALSE;
        // lab Assignment

        //return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public ArrayList<Tweet> getTweets() {

        ArrayList<Tweet> sortedTweets = new ArrayList<Tweet>();
        Collections.sort(sortedTweets, new tweetComparator());
        return sortedTweets;
    }

    public int getCount() {
        return tweets.size();
    }
}

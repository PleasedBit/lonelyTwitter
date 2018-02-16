package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by Craig on 2018-02-15.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        //assertTrue(Boolean.FALSE); //Always fails

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(tweet.getDate(), returnedTweet.getDate());
    }


    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        tweets.add(tweet);
        Tweet tweet2 = new NormalTweet("Test tweet2");
        tweets.add(tweet2);

        ArrayList<Tweet> returnedTweetList = tweets.getTweets();

        assertTrue(returnedTweetList.get(0).equals(tweet));
        assertTrue(returnedTweetList.get(1).equals(tweet2));
    }

    public void testgetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        tweets.add(tweet);
        assertTrue(tweets.getCount() == 1);

        Tweet tweet2 = new NormalTweet("Test tweet");
        tweets.add(tweet2);
        assertTrue(tweets.getCount() == 2);
    }
}

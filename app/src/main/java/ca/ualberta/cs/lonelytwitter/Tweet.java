package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */
public abstract class Tweet implements Tweetable {
    private String msg;
    private Date date;
    private Mood[] moods;


    // Constructors
    public Tweet(String msg){
        this.msg = msg;
        this.date = new Date();

        // Because I can, preload the mood array with the moods I have created
        this.moods = new Mood[2];
        this.moods[0] = new MoodHappy();
        this.moods[1] = new MoodSad();
    }

    public Tweet(String msg, Date date){
        this.msg = msg;
        this.date = date;

        // Because I can, preload the mood array with the moods I have created
        this.moods = new Mood[2];
        this.moods[0] = new MoodHappy();
        this.moods[1] = new MoodSad();
    }


    // DATE
    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }


    // Message
    public String getMsg(){
        return this.msg;
    }

    public void setMsg(String msg) throws TweetTooLongException {
        if (msg.length() > 140) {
            throw new TweetTooLongException();
        } else {
            this.msg = msg;
        }
    }

    public abstract Boolean isImportant();
}
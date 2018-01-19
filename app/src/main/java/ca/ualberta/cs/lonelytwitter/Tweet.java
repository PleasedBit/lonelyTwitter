package ca.ualberta.cs.lonelytwitter;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;

/**
 * Created by Craig on 2018-01-18.
 */
public abstract class Tweet implements Tweetable{
    private String msg;
    private Date date;

    // Constructors
    public Tweet(String msg){
        this.msg = msg;
    }

    public Tweet(String msg, Date date){
        this.msg = msg;
        this.date = date;
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
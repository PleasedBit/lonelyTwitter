package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweet_list.sav";
	private EditText bodyText;
	private ListView oldTweetsList;


	// ADDED
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	//
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Log.d("MyDebug", "save Ran");
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				//ADDED
				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				//

				saveInFile();

			}
		});

		// Added for exercise
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.d("MyDebug", "clear Ran");
                //tweetList = new ArrayList<Tweet>();
                tweetList.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
				bodyText.setText("");
			}
		});
		//End
	}

	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>( this, R.layout.list_item, tweetList);

		oldTweetsList.setAdapter(adapter);


		/* Depricated
        NormalTweet normalTweet = new NormalTweet("");
        try {
            normalTweet.setMessage("Hello World!");
//            normalTweet.setMessage("aaaaaaaa123904ifkdjfhirhtiorhtherihgtjkerhgjkhergtjkherjkh49ryhui4thg754tdfjlsdkhioerhgiohruioghejiogfuioerhgfiohrjkfhasdjkhgiuhgiorgjkdfhgidfgsdkljfkldsjfklsdjklfjdklsfjkldghsk");
        }
        catch (TweetTooLongException e) {
            Log.e("Error ---->", "Tweet message too long");

        }


        ImportantTweet importantTweet1 = new ImportantTweet("Hello World! This is important");
        ImportantTweet importantTweet2 = new ImportantTweet("This is another important tweet");

        NormalTweet normalTweet1 = new NormalTweet("This is not that important");
        NormalTweet normalTweet2 = new NormalTweet("This is not that important either");

        ArrayList <Tweet> tweetList = new ArrayList<Tweet>();
        tweetList.add(normalTweet);
        tweetList.add(normalTweet1);
        tweetList.add(normalTweet2);
        tweetList.add(importantTweet1);
        tweetList.add(importantTweet2);

        for (Tweet t:
                tweetList) {
            Log.d("Tweet Polymorphism", t.isImportant().toString());

        }


        ArrayList <Tweetable> tweetableList = new ArrayList<Tweetable>();
        tweetableList.add(normalTweet);
        tweetableList.add(normalTweet1);
        tweetableList.add(normalTweet2);
        tweetableList.add(importantTweet1);
        tweetableList.add(importantTweet2);

        String messageOnScreen = "";
        for (Tweetable t:
             tweetableList) {
            messageOnScreen += t.getMessage() + "\n";
        }
        Toast.makeText(this, messageOnScreen, Toast.LENGTH_SHORT).show();
		*/
	}

	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			// Added
			Gson gson = new Gson();
			//taken from stack overflow as in class 2018-01-25
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

			/* Depricated
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}
			*/

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private void saveInFile() {        //String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			// Added
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();
			//
			/* Depricated
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
			*/
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}


	private void clearEverything(){

	}

}
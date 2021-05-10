package hu.kormany.milan.roomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WordRoomDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                WordRoomDatabase.class,
                "word_database"
        ).allowMainThreadQueries()
                .build();

        WordDao dao = db.wordDao();
        dao.deleteAll();

        Word word = new Word("Hello");
        dao.insert(word);

        word = new Word("world");
        dao.insert(word);

        List<Word> words= dao.getAlphabetizedWords();

        for(Word w : words){
            Log.d(TAG,w.getMWord());
        }
    }
}
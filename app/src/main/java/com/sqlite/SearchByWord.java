package com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchByWord extends AppCompatActivity {
    private EditText etWord;
    private Button btnSearch;
    private ListView lvOutput;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_word);

        etWord = findViewById(R.id.etWord);
        lvOutput = findViewById(R.id.lvOutput);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    LoadWord();
            }
        });

    }

    private void LoadWord() {
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Word> wordList = new ArrayList<>();
        wordList = myHelper.GetWordByName(etWord.getText().toString(),sqLiteDatabase);
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            hashMap.put(wordList.get(i).getWord(), wordList.get(i).getMeaning());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        lvOutput.setAdapter(stringArrayAdapter);


    }





}

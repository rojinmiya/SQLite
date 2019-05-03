package com.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class SearchByWord extends AppCompatActivity {
    private EditText etWord;
    private Button btnSearch;
    private ListView lvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_word);
    }

    //public List<Word> GetWordBy




}

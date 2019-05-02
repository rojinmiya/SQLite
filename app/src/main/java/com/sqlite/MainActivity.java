package com.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etWord=findViewById(R.id.etWord);
        final EditText etMeaning=findViewById(R.id.etMeaning);
        Button btnAddWord=findViewById(R.id.btnAddWord);

        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long id=myHelper.InsertData(etWord.getText().toString(),etMeaning.getText().toString(),sqLiteDatabase);
                if(id>0){
                    Toast.makeText(MainActivity.this,"Successfull"+id,Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();

                }
//                if(myHelper.InsertData(etWord.getText().toString(),etMeaning.getText().toString(),sqLiteDatabase))
//                {
//                    Toast.makeText(MainActivity.this,"succesafull", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
//                }
            }
        });

    }
}

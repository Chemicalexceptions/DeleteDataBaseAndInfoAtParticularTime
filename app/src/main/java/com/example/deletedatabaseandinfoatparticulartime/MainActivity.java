package com.example.deletedatabaseandinfoatparticulartime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.deletedatabaseandinfoatparticulartime.database.DatabaseHelper;
import com.example.deletedatabaseandinfoatparticulartime.util.AlarmUtil;
import com.example.deletedatabaseandinfoatparticulartime.util.InternalDataUtil;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDb();

        //Adding a record in the data base
        for (int i = 0 ;i<100;i++){

           dbHelper.addContact("Ankit","9911993221");

        }



    }

    private void initDb() {

        dbHelper = new DatabaseHelper(this);

    }
}

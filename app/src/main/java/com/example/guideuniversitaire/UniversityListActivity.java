package com.example.guideuniversitaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniversityListActivity extends AppCompatActivity {

    UniversitesDBAdaptateur db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_list);

        db = new UniversitesDBAdaptateur(this);
        ArrayList<HashMap<String, String>> univerliteList = db.getUniversities();

        listView = findViewById(R.id.universite_list);
        ListAdapter adapter = new SimpleAdapter(UniversityListActivity.this, univerliteList, R.layout.list_row,
                new String[] {"id", "université", "ville"}, new int[] {R.id.id, R.id.universite, R.id.ville});

        listView.setAdapter(adapter);
    }
}
package com.example.guideuniversitaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addBtn, deleteBtn, listBtn, quitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addUnivBtn);
        deleteBtn = findViewById(R.id.deleteUnivBtn);
        listBtn = findViewById(R.id.listUnivBtn);
        quitBtn = findViewById(R.id.quitterBtn);
    }

    public void goToList(View v) {
        Intent intent = new Intent(this, UniversityListActivity.class);
        startActivity(intent);
    }

    public void addUniversity(View v) {
        Intent intent = new Intent(this, AddUniversityActivity.class);
        startActivity(intent);
    }

    public void deleteUniversity(View v) {
        Intent intent = new Intent(this, DeleteUniversityActivity.class);
        startActivity(intent);
    }

    public void quitter(View v) {
        finish();
        System.exit(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.addMenu) {
            Intent intent = new Intent(this, AddUniversityActivity.class);
            startActivity(intent);
            return true;
        }
        else
            if(id == R.id.deleteMenu) {
                Intent intent = new Intent(this, DeleteUniversityActivity.class);
                startActivity(intent);
                return true;
            }
        else
            if(id == R.id.listMenu) {
                Intent intent = new Intent(this, UniversityListActivity.class);
                startActivity(intent);
                return true;
            }
        else {
                finish();
                System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}
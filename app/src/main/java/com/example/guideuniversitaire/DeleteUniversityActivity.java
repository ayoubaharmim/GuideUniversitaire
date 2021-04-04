package com.example.guideuniversitaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class DeleteUniversityActivity extends AppCompatActivity {

    UniversitesDBAdaptateur db;
    Button delete;
    EditText idInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_university);

        delete = findViewById(R.id.deleteUniversityBtn);
        idInput = findViewById(R.id.idInput);

        db = new UniversitesDBAdaptateur(this);
    }

    public void deleteUniversity(View v) {
        String id = idInput.getText().toString();
        int deleted = -1;

        if(id.equals(""))
            Toast.makeText(this, "Veuillez remplir un identifiant de l'université", Toast.LENGTH_LONG).show();
        else {
            deleted = db.deleteUniversity(Integer.parseInt(id));
            if(deleted == 0)
                Toast.makeText(this, "l'université n'existe pas à la base de données", Toast.LENGTH_LONG).show();
            if(deleted == 1) {
                Toast.makeText(this, "l'université a été supprimé", Toast.LENGTH_LONG).show();
                finish();
            }
            else
                Toast.makeText(this, "Un problème est survenu, veuillez réessayer plus tard", Toast.LENGTH_LONG).show();
        }
    }
}
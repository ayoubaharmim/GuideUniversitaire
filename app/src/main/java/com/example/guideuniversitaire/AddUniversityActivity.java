package com.example.guideuniversitaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUniversityActivity extends AppCompatActivity {

    UniversitesDBAdaptateur db;

    EditText nomUniversite, ville;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_university);

        db = new UniversitesDBAdaptateur(this);

        nomUniversite = findViewById(R.id.nameInput);
        ville = findViewById(R.id.cityInput);
        addBtn = findViewById(R.id.addBtn);
    }

    public void addUniversity(View v) {
        String universite = nomUniversite.getText().toString();
        String nomVille = ville.getText().toString();

        if(universite.equals(""))
            Toast.makeText(this, "Veuillez remplire le nom de l'université", Toast.LENGTH_SHORT).show();
        else if (nomVille.equals(""))
            Toast.makeText(this, "Veuillez remplire le nom de la ville", Toast.LENGTH_SHORT).show();
        else {
            boolean instered = db.insertData(universite, nomVille);

            if (instered) {
                Toast.makeText(this, "L'université est ajouté", Toast.LENGTH_LONG).show();
                finish();
            }
            else
                Toast.makeText(this, "Veuillez ressayer", Toast.LENGTH_SHORT).show();
        }
    }
}
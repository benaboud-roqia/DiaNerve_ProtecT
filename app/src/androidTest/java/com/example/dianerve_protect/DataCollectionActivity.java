package com.example.dianerve_protect;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DataCollectionActivity extends AppCompatActivity {

    // Déclaration des vues
    private TextView titleData, subtitleData;
    private EditText etAge, etDuree, etPoids;
    private Spinner spinnerSex, spinnerTypeDiabete;
    private Button btnNextData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);  // Assure-toi que le nom du fichier XML correspond

        // Initialisation des vues
        titleData = findViewById(R.id.titleData);
        subtitleData = findViewById(R.id.subtitleData);
        etAge = findViewById(R.id.etAge);
        etDuree = findViewById(R.id.etDuree);
        etPoids = findViewById(R.id.etPoids);
        spinnerSex = findViewById(R.id.spinnerSex);
        spinnerTypeDiabete = findViewById(R.id.spinnerTypeDiabete);
        btnNextData = findViewById(R.id.btnNextData);

        // Peupler le Spinner pour le sexe
        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this,
                R.array.sex_options, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(sexAdapter);

        // Peupler le Spinner pour le type de diabète
        ArrayAdapter<CharSequence> diabetesAdapter = ArrayAdapter.createFromResource(this,
                R.array.diabetes_types, android.R.layout.simple_spinner_item);
        diabetesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeDiabete.setAdapter(diabetesAdapter);

        // Action au clic sur le bouton "Suivant"
        btnNextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les données des champs
                String age = etAge.getText().toString();
                String duree = etDuree.getText().toString();
                String poids = etPoids.getText().toString();
                String sexe = spinnerSex.getSelectedItem().toString();
                String typeDiabete = spinnerTypeDiabete.getSelectedItem().toString();

                // Valider les champs
                if (age.isEmpty() || duree.isEmpty() || poids.isEmpty()) {
                    Toast.makeText(DataCollectionActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    // Traiter les données (enregistrer, envoyer au serveur, etc.)
                    String message = "Âge: " + age + "\nDurée du Diabète: " + duree + " ans\nPoids: " + poids + " kg\nSexe: " + sexe + "\nType Diabète: " + typeDiabete;
                    Toast.makeText(DataCollectionActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

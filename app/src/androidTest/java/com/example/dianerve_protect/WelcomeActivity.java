package com.example.dianerve_protect;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);  // Assurez-vous que c'est le bon fichier XML

        // Initialiser le bouton "Suivant"
        Button btnNext = findViewById(R.id.btnNext);

        // Définir un OnClickListener pour le bouton
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à réaliser lorsque le bouton est cliqué
                Toast.makeText(WelcomeActivity.this, "Vous avez cliqué sur Suivant!", Toast.LENGTH_SHORT).show();
                // Vous pouvez ajouter d'autres actions ici, comme naviguer vers une autre activité.
            }
        });
    }
}

package com.example.dianerve_protect;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    // Déclaration des éléments de l'interface
    private TextView titleInfo, textDefinition, textSymptoms, textPrevention;
    private ImageView imgInfo;
    private Button btnNextInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);  // Assurez-vous que le layout est bien défini

        // Initialisation des vues
        titleInfo = findViewById(R.id.titleInfo);
        textDefinition = findViewById(R.id.textDefinition);
        textSymptoms = findViewById(R.id.textSymptoms);
        textPrevention = findViewById(R.id.textPrevention);
        imgInfo = findViewById(R.id.imgInfo);
        btnNextInfo = findViewById(R.id.btnNextInfo);

        // EventListener pour le bouton Suivant
        btnNextInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vous pouvez ajouter une action de redirection vers une autre activité ici
                Intent intent = new Intent(InfoActivity.this, InfoActivity.class);  // Remplacez NextActivity par l'activité suivante
                startActivity(intent);
            }
        });
    }
}

package com.example.dianerve_protect;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    // Déclaration des éléments de l'interface
    private EditText emailEditText, passwordEditText;
    private Button registerButton, loginButton;

    // Instance de FirebaseAuth pour l'authentification
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);  // Remplacez par le nom de votre fichier XML

        // Initialisation des vues
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);

        // Initialisation de FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Bouton d'inscription
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les données entrées par l'utilisateur
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(AuthActivity.this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Créer un nouvel utilisateur avec Firebase Authentication
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(AuthActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // L'inscription a réussi
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(AuthActivity.this, "Inscription réussie.", Toast.LENGTH_SHORT).show();
                                // Vous pouvez rediriger l'utilisateur vers une autre activité après l'inscription
                            } else {
                                // L'inscription a échoué
                                Toast.makeText(AuthActivity.this, "Inscription échouée. Essayez à nouveau.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        // Bouton de connexion
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les données entrées par l'utilisateur
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(AuthActivity.this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Connexion avec Firebase Authentication
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(AuthActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // La connexion a réussi
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(AuthActivity.this, "Connexion réussie.", Toast.LENGTH_SHORT).show();
                                // Vous pouvez rediriger l'utilisateur vers une autre activité après la connexion
                            } else {
                                // La connexion a échoué
                                Toast.makeText(AuthActivity.this, "Échec de la connexion. Vérifiez vos informations.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Vérifier si l'utilisateur est déjà connecté
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // Si l'utilisateur est déjà connecté, redirigez-le vers l'écran principal
            // Par exemple, commencez l'activité principale ici
            // Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            // startActivity(intent);
            // finish();
        }
    }
}

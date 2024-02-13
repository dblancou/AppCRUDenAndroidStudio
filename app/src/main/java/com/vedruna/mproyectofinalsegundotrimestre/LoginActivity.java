package com.vedruna.mproyectofinalsegundotrimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextPassword;
    private Button botonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextNombre = findViewById(R.id.inputUser);
        editTextPassword = findViewById(R.id.inputPassword);
        botonLogin = findViewById(R.id.button4);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar las credenciales
                String nombre = editTextNombre.getText().toString();
                String password = editTextPassword.getText().toString();

                if (nombre.equals("admin") && password.equals("admin")) {
                    // Credenciales correctas
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Pasar a la pantalla del contador
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("usuario", nombre);
                    startActivity(intent);
                } else {
                    // Credenciales incorrectas
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

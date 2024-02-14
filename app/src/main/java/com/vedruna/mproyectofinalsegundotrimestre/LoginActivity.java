package com.vedruna.mproyectofinalsegundotrimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Actividad que maneja el proceso de inicio de sesión.
 */
public class LoginActivity extends AppCompatActivity {

    // Declaración de variables
    private EditText editTextNombre;
    private EditText editTextPassword;
    private Button botonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicialización de los elementos de la interfaz de usuario
        editTextNombre = findViewById(R.id.inputUser);
        editTextPassword = findViewById(R.id.inputPassword);
        botonLogin = findViewById(R.id.button4);

        // Configuración del listener para el botón de inicio de sesión
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar las credenciales ingresadas por el usuario
                String nombre = editTextNombre.getText().toString();
                String password = editTextPassword.getText().toString();

                // Comprobar si las credenciales son correctas
                if (nombre.equals("admin") && password.equals("admin")) {
                    // Credenciales correctas, mostrar mensaje de éxito
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Pasar a la pantalla principal (MainActivity) con el usuario como extra
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("usuario", nombre); // Enviar el nombre de usuario como extra
                    startActivity(intent);
                } else {
                    // Credenciales incorrectas, mostrar mensaje de error
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

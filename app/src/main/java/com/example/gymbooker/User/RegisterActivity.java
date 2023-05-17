package com.example.gymbooker.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymbooker.MainActivity;
import com.example.gymbooker.R;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    private TextView txtnombre,txttelefono,txtcorreo,txtcedula,txtfnacimiento,txtapellido;
    private Button btmcontinuar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtnombre = findViewById(R.id.ed_nombre);
        txttelefono = findViewById(R.id.ed_telefono);
        txtcorreo = findViewById(R.id.ed_correo);
        txtcedula = findViewById(R.id.ed_cedula);
        txtfnacimiento = findViewById(R.id.ed_nacimiento);
        txtapellido = findViewById(R.id.ed_apellido);
        btmcontinuar = findViewById(R.id.btn_registrar);
    }

    public void onClickGuardar(View view){

        HelperPersona bInstance = new HelperPersona();
        User u = new User();
        u.setNombre(txtnombre.getText().toString());
        u.setApellido(txtapellido.getText().toString());
        u.setTelefono(Long.parseLong(txttelefono.getText().toString()));
        u.setCorreo(txtcorreo.getText().toString());
        u.setCedula(Long.parseLong(txtcedula.getText().toString()));
        u.setFechaNacimiento(txtfnacimiento.getText().toString());
        int response=bInstance.guardarPersona(u);
        if(response==200){
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            preferences=getSharedPreferences("gym-booker",MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences.edit();
            editor.putInt("logged",1);
            editor.putString("ccUsuario",u.getCedula().toString());
            editor.apply();
            Intent i=new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);

        }else if(response==201){
            Toast.makeText(this, "Error al Conectar", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "No carga", Toast.LENGTH_SHORT).show();
        }

    }

    public static class validacionTelefono {
        private String resultadoValidacion;

        public String getResultadoValidacion() {
            return resultadoValidacion;
        }

        public void setResultadoValidacion(String resultadoValidacion) {
            this.resultadoValidacion = resultadoValidacion;
        }

        public boolean validarTelefono(String telefono) {
            // Patrón para validar un número de teléfono (10 dígitos numéricos)
            String patron = "^[0-9]{10}$";

            // Validar el número de teléfono utilizando el patrón
            boolean esValido = Pattern.matches(patron, telefono);

            // Establecer el resultado de la validación en la propiedad resultadoValidacion
            if (esValido) {
                setResultadoValidacion("El número de teléfono es válido");
            } else {
                setResultadoValidacion("El número de teléfono es inválido");
            }

            return esValido;
        }

        public static void main(String[] args) {
            validacionTelefono proyecto = new validacionTelefono();
            String telefono = "1234567890";

            // Validar el número de teléfono
            boolean esValido = proyecto.validarTelefono(telefono);
            String resultadoValidacion = proyecto.getResultadoValidacion();

        }
    }


    public static class validacionCedula {
        private String resultadoValidacion;

        public String getResultantValidation() {
            return resultadoValidacion;
        }

        public void setResultadoValidacion(String resultadoValidacion) {
            this.resultadoValidacion = resultadoValidacion;
        }

        public boolean validarCedula(String cedula) {
            // Patrón para validar una cédula colombiana (solo números de 8 o 10 dígitos)
            String patron = "^[0-9]{8,10}$";

            // Validar la cédula utilizando el patrón
            boolean esValida = Pattern.matches(patron, cedula);

            // Establecer el resultado de la validación en la propiedad resultadoValidacion
            if (esValida) {
                setResultadoValidacion("La cédula es válida");
            } else {
                setResultadoValidacion("La cédula es inválida");
            }

            return esValida;
        }

        public static void main(String[] args) {
            validacionCedula proyecto = new validacionCedula();
            String cedula = "12345678";

            // Validar la cédula
            boolean esValida = proyecto.validarCedula(cedula);
            String resultadoValidacion = proyecto.getResultantValidation();
        }
    }


    public static class ValidarCorreo {
        private String resultadoValidacion;

        public String getResultadoValidacion() {
            return resultadoValidacion;
        }

        public void setResultadoValidacion(String resultadoValidacion) {
            this.resultadoValidacion = resultadoValidacion;
        }

        public boolean validarCorreo(String correo) {
            // Patrón para validar una dirección de correo electrónico
            String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            // Validar el correo utilizando el patrón
            boolean esValido = Pattern.matches(patron, correo);

            // Establecer el resultado de la validación en la propiedad resultadoValidacion
            if (esValido) {
                setResultadoValidacion("La dirección de correo es válida");
            } else {
                setResultadoValidacion("La dirección de correo es inválida");
            }

            return esValido;
        }
        public static void main(String[] args) {
            ValidarCorreo proyecto = new ValidarCorreo();
            String correo = "ejemplo@example.com";

            // Validar la dirección de correo
            boolean esValido = proyecto.validarCorreo(correo);
            String resultadoValidacion = proyecto.getResultadoValidacion();

        }
    }
}


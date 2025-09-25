package com.example.mariaeduardajardimcalculodemedia;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nota1, nota2, nota3, nota4, numeroFaltas;
    private Button btnCalcular;
    private TextView resultado;
    private String nome;
    
    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initComponentes();

        btnCalcular.setOnClickListener(view -> {
            validaCampos();
            calculaMedia();
            resultado.setText("Você clicou no botão calcular");
        });
    }

    private void calculaMedia() {
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());

        double media = (n1 + n2 + n3 + n4)/ 4;
        double faltas = Double.parseDouble(numeroFaltas.getText().toString());

        if (media > 7){
            if (faltas < 20){
                resultado.setTextColor(Color.parseColor("#437845"));
                resultado.setText("Aluno aprovado com media " + media);
            } else {
                resultado.setTextColor(Color.parseColor("#f44336"));
                resultado.setText("Excesso de falta " + faltas);
            }
        } else {
            resultado.setTextColor(Color.parseColor("f44336"));
            resultado.setText("Aluno retido com media " + media);
        }
    }

    private void validaCampos() {
        if (TextUtils.isEmpty(nota1.getText())){
            //campo está vazio ou tem apenas espaços em branco
            // exiba a mensagem de erro para os usuários
            nota1.setError("Este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota2.getText())) {
            nota2.setError("Este campo não pode estar vazio");
        } else if (TextUtils.isEmpty(nota3.getText())) {
            nota3.setError("Este campo não pode estar vazio");
        } else if (TextUtils.isEmpty(nota4.getText())) {
            nota4.setError("Este campo não pode estar vazio");
        }
    }

    private boolean valideCampos2(){
        boolean camposValidados=true;
        if (nota1.getText().toString().isEmpty()){
            camposValidados = false;
        } else if (nota2.getText().toString().isEmpty()) {
            camposValidados = false;
        } else if (nota3.getText().toString().isEmpty()) {
            camposValidados = false;
        } else if (nota4.getText().toString().isEmpty()) {
            camposValidados = false;
        }
        return camposValidados;
    }

    private boolean validaCampos3(){
        return nota1.getText().toString().isEmpty()
                && nota2.getText().toString().isEmpty()
                && nota3.getText().toString().isEmpty()
                && nota4.getText().toString().isEmpty();
    }

    private void initComponentes() {
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        numeroFaltas = findViewById(R.id.faltas);
        btnCalcular = findViewById(R.id.btn_calcular);
        resultado = findViewById(R.id.resultado);
    }


}
package com.example.djalmacunha.aulatwo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {

    //declaracao de todas as variaveis
    private RadioGroup porc;
    private RadioButton op1, op2, op3;
    private Button vai;
    private EditText put;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //colocando os ID's referentes a cada coisa
        porc = (RadioGroup) findViewById(R.id.radioGroup);
        vai = (Button) findViewById(R.id.button);
        put = (EditText) findViewById(R.id.insere);
        op1 = (RadioButton) findViewById(R.id.quarenta);
        op2 = (RadioButton) findViewById(R.id.quarentaCinco);
        op3 = (RadioButton) findViewById(R.id.cinquenta);

        //para executar quando apertar o botao
        vai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checa o valor digitado e o valor no radio
                double var1 = Double.parseDouble(put.getText().toString());
                double var2 = 0;
                boolean checked = ((RadioButton) v).isChecked();
                //porc.getCheckedRadioButtonId();
                switch(porc.getCheckedRadioButtonId()) {
                    case R.id.quarenta:
                        if (checked)
                            var2 = 1.40;
                            break;
                    case R.id.quarentaCinco:
                        if (checked)
                            var2 = 1.45;
                        break;
                    case R.id.cinquenta:
                        if (checked)
                            var2 = 1.50;
                            break;
                }

                //faz a conta
                double resp = var1 * var2;
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Resultado");

                //imprime a resposta
                alerta.setMessage("O resultado é " + resp);
                alerta.setNeutralButton("OK", null);
                alerta.show();
            }

        });
    }
}



package br.edu.ifsp.hto.aula0219;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btSomar = (Button) findViewById(R.id.btSomar);
        btSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSomar(v);
            }
        });
        Button btSubtrair = (Button) findViewById(R.id.btSubtrair);
        btSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSubtrair(v);
            }
        });
        Button btDividir = (Button) findViewById(R.id.btDividir);
        btDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDividir(v);
            }
        });
        Button btMulplicar = (Button) findViewById(R.id.btMultiplicar);
        btMulplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMultiplicar(v);
            }
        });
    }

    public void onClickSomar(View v){
        EditText tNum1 = (EditText) findViewById(R.id.tNum1);
        EditText tNum2 = (EditText) findViewById(R.id.tNum2);

        String sNum1 = tNum1.getText().toString();
        String sNum2 = tNum2.getText().toString();

        double num1 = Double.parseDouble(sNum1);
        double num2 = Double.parseDouble(sNum2);
        double resultado = num1 + num2;
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        String sResultado = Double.toString(resultado);
        tvResultado.setText(getString(R.string.resultado) + " : " + sResultado);
    }

    public void onClickSubtrair(View v){
        EditText tNum1 = (EditText) findViewById(R.id.tNum1);
        EditText tNum2 = (EditText) findViewById(R.id.tNum2);

        String sNum1 = tNum1.getText().toString();
        String sNum2 = tNum2.getText().toString();

        double num1 = Double.parseDouble(sNum1);
        double num2 = Double.parseDouble(sNum2);
        double resultado = num1 - num2;
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        String sResultado = Double.toString(resultado);
        tvResultado.setText(getString(R.string.resultado) +" : "+ sResultado);
    }

    public void onClickDividir(View v){
        EditText tNum1 = (EditText) findViewById(R.id.tNum1);
        EditText tNum2 = (EditText) findViewById(R.id.tNum2);

        String sNum1 = tNum1.getText().toString();
        String sNum2 = tNum2.getText().toString();

        double num1 = Double.parseDouble(sNum1);
        double num2 = Double.parseDouble(sNum2);
        double resultado = num1/num2;
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        String sResultado = Double.toString(resultado);
        tvResultado.setText(getString(R.string.resultado) +" : "+ sResultado);
    }

    public void onClickMultiplicar(View v){
        EditText tNum1 = (EditText) findViewById(R.id.tNum1);
        EditText tNum2 = (EditText) findViewById(R.id.tNum2);

        String sNum1 = tNum1.getText().toString();
        String sNum2 = tNum2.getText().toString();

        double num1 = Double.parseDouble(sNum1);
        double num2 = Double.parseDouble(sNum2);

        double resultado = num1*num2;
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        String sResultado = Double.toString(resultado);
        tvResultado.setText(getString(R.string.resultado) +" : "+ sResultado);

    }
}

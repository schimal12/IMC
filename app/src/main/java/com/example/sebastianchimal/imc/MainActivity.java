package com.example.sebastianchimal.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public EditText nombreEdit;
    public EditText heightEdit;
    public EditText weightEdit;
    public CheckBox male;
    public CheckBox female;
    public Button IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreEdit = (EditText)findViewById(R.id.nombre);
        heightEdit = (EditText)findViewById(R.id.height);
        weightEdit = (EditText)findViewById(R.id.weight);
        IMC = (Button)findViewById(R.id.imc);
        male = (CheckBox)findViewById(R.id.male);
        female = (CheckBox)findViewById(R.id.female);
    }

    private int VALOR_SUBACTIVIDAD = 5007;

    public void calcularIMC(View view){
        final Intent it = new Intent(this,IMCActivity.class);
        String nombre = nombreEdit.getText().toString();
        String height = heightEdit.getText().toString();
        String weight = weightEdit.getText().toString();

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(((CheckBox)v).isChecked()){
                    String male = "male";
                    it.putExtra("genre",male);
                }else{
                    String female = "female";
                    it.putExtra("genre",female);
                }
            }
        });
        it.putExtra("nombre",nombre);
        it.putExtra("height",height);
        it.putExtra("weight",weight);
        startActivityForResult(it, VALOR_SUBACTIVIDAD);
    }
}

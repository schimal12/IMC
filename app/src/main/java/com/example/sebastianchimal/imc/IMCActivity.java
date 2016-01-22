package com.example.sebastianchimal.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IMCActivity extends AppCompatActivity {
    private String nombreIMC;
    private Double IMC;
    private Double weightIMC;
    private Double heightIMC;
    private String genre;
    private String pesoIdeal;
    private String energia;

    private TextView IMCOriginal;
    private TextView NombreIMC;
    private TextView pesoIMC;
    private TextView pesoIdealIMC;
    private TextView Energy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        IMCOriginal = (TextView)findViewById(R.id.textView2);
        NombreIMC = (TextView)findViewById(R.id.textView3);
        pesoIMC = (TextView)findViewById(R.id.textView6);
        pesoIdealIMC = (TextView)findViewById(R.id.textView4);
        Energy = (TextView)findViewById(R.id.textView5);


        weightIMC = Double.parseDouble(getIntent().getStringExtra("weight"));
        heightIMC = Double.parseDouble(getIntent().getStringExtra("height"));
        IMC = (weightIMC/((heightIMC)*(heightIMC)));
        IMCOriginal.setText("IMC: "+IMC.toString());

        nombreIMC = getIntent().getStringExtra("nombre");
        NombreIMC.setText("Nombre: "+nombreIMC);

        pesoIMC.setText("Peso: "+weightIMC.toString());

       genre = getIntent().getStringExtra("genre");

        if(genre.equals("male")){
            if(heightIMC > 1.52){
                pesoIdeal = ""+50+(Math.floor(heightIMC/5)*2.3);
            }else{
                pesoIdeal = ""+50;
            }
        }else{
            if(heightIMC > 1.52){
                pesoIdeal = ""+45+(Math.floor(heightIMC/5)*2.3);
            }else{
                pesoIdeal = ""+45;
            }
        }

        pesoIdealIMC.setText(pesoIdeal);

        if(genre.equals("male")){
            Double tmp = 66+(13.7*weightIMC)+(5*heightIMC)-(6.8*22)
            energia =""+tmp;
        }else{
            Double tmp = 655+(9.6*weightIMC)+(1.8*heightIMC)-(4.7*22)
            energia =""+tmp;
        }

        Energy.setText(energia);





    }
}
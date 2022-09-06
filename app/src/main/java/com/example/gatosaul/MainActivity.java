package com.example.gatosaul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private boolean jugador;
    private int[] valores1 ={R.id.button,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,
            R.id.button8,R.id.button9};
    private int[] resultado = {0,0,0,0,0,0,0,0,0};
    private int ganador=0,c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Button buttonI = findViewById(R.id.button10);
        Button button = null;
        textView.setTextSize(50);
        textView.setText("Turno: O");
        buttonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rein();
            }
        });
        jugador = false;
        for(int valor : valores1){
            button =findViewById(valor);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c++;
                    if(jugador){
                        ((Button)v).setText("X");
                        jugador = false;
                        if(c!=9){
                            textView.setText("Turno: O");
                        }
                    }else{
                        ((Button)v).setText("O");
                        jugador = true;
                        if(c!=9){
                            textView.setText("Turno: X");
                        }
                    }
                    ((Button)v).setEnabled(false);

                    resultado();
                    for(int i=0;i<valores1.length;i+=3){
                        if(resultado[i]==resultado[i+1]&&resultado[i]==resultado[i+2]){
                            if(resultado[i]==1){
                                ganador=1;
                            }
                            if(resultado[i]==2){
                                ganador=2;
                            }

                        }
                    }
                    for(int j=0;j<3;j++){
                        if (resultado[j] == resultado[j + 3] && resultado[j]==resultado[j + 6]) {
                            if(resultado[j]==1){
                                ganador=1;
                            }
                            if(resultado[j]==2){
                                ganador=2;
                            }

                        }
                    }
                    if(resultado[0]==resultado[4] && resultado[0]==resultado[8]){
                            if(resultado[0]==1){
                                ganador=1;
                            }
                            if(resultado[0]==2){
                                ganador=2;
                            }
                    }
                    if(resultado[2]==resultado[4] && resultado[2]==resultado[6]){
                            if(resultado[2]==1){
                                ganador=1;
                            }
                            if(resultado[2]==2){
                                ganador=2;
                            }
                    }

                    if(ganador==1){
                        textView.setText("Hay ganador X");
                        desh();
                    }
                    if(ganador==2){
                        textView.setText("Hay ganador O");
                        desh();
                    }
                    if(c==9 && ganador==0){
                        textView.setText("Empate");
                    }
                }
            });
        }

    }
    public void rein(){
        c=0;
        resultado= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        ganador=0;
        Button button = null;
        for(int m=0;m<valores1.length;m++){
            button=findViewById(valores1[m]);
            button.setEnabled(true);
            button.setText("");
            TextView textview = findViewById(R.id.textView);
            textview.setText("Inicie el juego");
        }
    }
    public void desh(){
        Button button = null;
        for(int m=0;m<valores1.length;m++){
            button=findViewById(valores1[m]);
            button.setEnabled(false);
        }
    }
    public void resultado(){
        Button button = null;
        for(int i=0;i<valores1.length;i++){
            button = findViewById(valores1[i]);
                if("X".equals(button.getText().toString()))
                    resultado[i]=1;
                if("O".equals(button.getText().toString()))
                    resultado[i]=2;
        }

    }
}
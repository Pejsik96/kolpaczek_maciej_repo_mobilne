package com.example.inf04_01_2201;

import androidx.appcompat.app.AppCompatActivity;

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
        Button button = findViewById(R.id.button);
        TextView tekst = findViewById(R.id.textView5);
        EditText mail = findViewById(R.id.editTextTextPersonName);
        EditText haslop1 = findViewById(R.id.editTextTextPassword);
        EditText haslop2 = findViewById(R.id.editTextTextPassword2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mail.getText().toString();
                String haslo1=haslop1.getText().toString();
                String haslo2=haslop2.getText().toString();
                tekst.setTextSize(28);
                tekst.setTextColor(R.color.teal_200);
                androidx.constraintlayout.widget.ConstraintLayout.setBackgroundResource(R.color.purple_500);
                if(email.contains("@")){
                    if(haslo1==haslo2){
                        tekst.setText("Witaj "+email);
                    }
                    else{
                        tekst.setText("Hasła się różnią");
                    }
                }
                else{
                    tekst.setText(("Nieprawidłowy adres e-mail"));
                }
            }
        });
    }
}
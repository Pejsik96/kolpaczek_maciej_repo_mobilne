package com.example.wlasnyprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button buttons = findViewById(R.id.button2);
        Button buttonl = findViewById(R.id.button3);
        Button buttonu = findViewById(R.id.button4);
        TextView tekst = findViewById(R.id.textView);
        TextView tekstu = findViewById(R.id.textView2);
        Context context = this;
        MainActivityViewModel model=new ViewModelProvider(this).get(MainActivityViewModel.class);
        tekst.setText(model.liczba);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.addNumber();
                tekst.setText(model.liczba);
            }
        });
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(model.liczba>=100){
                    model.liczba-=100;
                    model.addUpgrade();
                    tekstu.setText("Current: "+model.upgrade+" clicks");
                    button.setText("ADD +"+model.upgrade);
                }
            }
        });
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "wynik";
                File file = new File(context.getFilesDir(), filename);
                int wynik = model.liczba;
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(wynik);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String filename = "wynik";
                    File file = new File(context.getFilesDir(), filename);
                    Scanner sc = new Scanner(file);
                    while(sc.hasNext()){
                        model.liczba += sc.nextInt();
                    }
                    tekst.setText(model.liczba);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
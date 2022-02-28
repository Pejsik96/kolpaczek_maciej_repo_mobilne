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
    int liczba=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button buttons = findViewById(R.id.button2);
        Button buttonl = findViewById(R.id.button3);
        TextView tekst = findViewById(R.id.textView);
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
                String filename = "wynik";
                File file = new File(context.getFilesDir(), filename);
                int wynik = liczba;
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
                    int liczba =0;
                    String filename = "wynik";
                    File file = new File(context.getFilesDir(), filename);
                    Scanner sc = new Scanner(file);
                    while(sc.hasNext()){
                        liczba += sc.nextInt();
                    }
                    tekst.setText(liczba);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
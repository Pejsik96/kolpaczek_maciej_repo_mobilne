package com.example.wlasnyprojekt;
import androidx.lifecycle.ViewModel;

class MainActivityViewModel extends ViewModel {
    int liczba =0;
    int upgrade=1;
    void addNumber(){
        liczba+=upgrade;
    }
    void addUpgrade(){ upgrade++; }
}

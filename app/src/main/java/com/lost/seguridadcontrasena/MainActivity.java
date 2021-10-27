package com.lost.seguridadcontrasena;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import com.lost.seguridadcontrasena.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onTextChangedListener();
    }

    private void onTextChangedListener(){

        binding.etPass.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //changeColor(charSequence);
                changeColor(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void changeColor(String pass){

        boolean isLowerCase = false;

        for(int i = 0; i < pass.length(); i++){

            if(Character.isLowerCase(pass.charAt(i))){
                isLowerCase = true;
            }

            else{
                isLowerCase = false;
                break;
            }
        }

        if(pass.length()<6){
            binding.etPass.setBackgroundColor(Color.RED);
        }
        else if(pass.length()>=6 && isLowerCase){
            binding.etPass.setBackgroundColor(Color.YELLOW);
        }
        else{
            binding.etPass.setBackgroundColor(Color.GREEN);
        }

    }


    private void changeColor(CharSequence pass){

        boolean isLowerCase = false;
        ArrayList<Boolean> arreglo = new ArrayList<>();
        Pattern pt = Pattern.compile("[a-z]");
        Matcher mt;


        for(int i = 0; i< pass.length(); i++){

            mt = pt.matcher(String.valueOf(pass.charAt(i)));
            arreglo.add(mt.matches());
        }

        for(Boolean value: arreglo){

            if(value){
                isLowerCase = true;
            }
            else{
                isLowerCase = false;
                break;
            }
        }

        if(pass.length()<6){
            binding.etPass.setBackgroundColor(Color.RED);
        }
        else if(pass.length()>=6 && isLowerCase){
            binding.etPass.setBackgroundColor(Color.YELLOW);
        }
        else{
            binding.etPass.setBackgroundColor(Color.GREEN);
        }

    }

}
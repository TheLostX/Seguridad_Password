package com.lost.seguridadcontrasena;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import com.google.android.material.textfield.TextInputLayout;
import com.lost.seguridadcontrasena.databinding.ActivityMainBinding;
import com.lost.seguridadcontrasena.presentador.Presenter;
import com.lost.seguridadcontrasena.vista.IView;

public class MainActivity extends AppCompatActivity implements IView {

    ActivityMainBinding binding;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new Presenter(this);

        setupListener();
    }

    private void setupListener() {

        binding.etPass.addTextChangedListener(new TextWatcher() {
            
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.procesarPassword(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @Override
    public void showBackgroundRed() {
        binding.etPass.setBackgroundColor(Color.RED);
    }

    @Override
    public void showBackgroundYellow() {
        binding.etPass.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void showBackgroundGreen() {
        binding.etPass.setBackgroundColor(Color.GREEN);
    }

    @Override
    public void clearBackground() {
        binding.etPass.setBackgroundColor(Color.WHITE);
    }
}
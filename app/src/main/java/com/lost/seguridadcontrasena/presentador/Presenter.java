package com.lost.seguridadcontrasena.presentador;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;

import com.lost.seguridadcontrasena.databinding.ActivityMainBinding;
import com.lost.seguridadcontrasena.vista.IView;

public class Presenter implements IPresenter {

    private IView view;

    public Presenter(IView view) {
        this.view = view;
    }
/*
    @Override
    public void setupListener() {

        binding.etPass.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                changeBackgroundColor(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
*/

    @Override
    public boolean isLowerCase(String pass) {

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

        return isLowerCase;
    }

    @Override
    public void procesarPassword(String pass) {

        if(pass.isEmpty()){
            view.clearBackground();
            return;
        }

        boolean flag = isLowerCase(pass);

        if(pass.length()<6){
            view.showBackgroundRed();
        }
        else if(pass.length()>=6 && flag){
            view.showBackgroundYellow();
        }
        else{
            view.showBackgroundGreen();
        }


    }
}
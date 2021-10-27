package com.lost.seguridadcontrasena.presentador;

import com.lost.seguridadcontrasena.databinding.ActivityMainBinding;

public interface IPresenter {

    boolean isLowerCase(String pass);
    void procesarPassword(String pass);
}

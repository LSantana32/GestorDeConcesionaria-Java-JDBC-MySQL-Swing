package com.github.lsantana32.concesionaria;

import com.github.lsantana32.concesionaria.idu.Principal;
import com.github.lsantana32.concesionaria.persistencia.Conexion;


public class Concesionaria {

    public static void main(String[] args) {

        Conexion conexion = new Conexion();

        //Llamamos y hacemos visible a nuestra IGU
        Principal principal = new Principal();

        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}




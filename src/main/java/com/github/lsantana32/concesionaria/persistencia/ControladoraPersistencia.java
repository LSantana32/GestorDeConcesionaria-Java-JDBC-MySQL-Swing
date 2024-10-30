package com.github.lsantana32.concesionaria.persistencia;


import com.github.lsantana32.concesionaria.logica.Automovil;

public class ControladoraPersistencia {

    Conexion conexion = new Conexion();
    
    public void agregarAutomovil(Automovil auto) {
        conexion.darDeAlta(auto);
    }

    public Automovil consultarAutomovil(Automovil unAuto) {
        return conexion.consultar(unAuto);
    }

    public void editarAutomovil(Automovil auto) {
        conexion.editarAutimovil(auto);
    }
}

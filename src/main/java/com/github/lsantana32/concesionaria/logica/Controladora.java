package com.github.lsantana32.concesionaria.logica;


import com.github.lsantana32.concesionaria.persistencia.ControladoraPersistencia;

public class Controladora {

    private ControladoraPersistencia cp = new ControladoraPersistencia();

    public void agregarAutomovil(String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);

        cp.agregarAutomovil(auto);
    }
    
}

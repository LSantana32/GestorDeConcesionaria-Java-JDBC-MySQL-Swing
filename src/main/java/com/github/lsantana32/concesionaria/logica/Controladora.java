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
    
    public Automovil consultarAutomovil (String unaPatente){
        Automovil auto = new Automovil();
        auto.setPatente(unaPatente);
        return cp.consultarAutomovil(auto);
    }

    public void editarAutomovil(String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        cp.editarAutomovil(auto);
    }

    public void eliminarAutomovil(String unaPatente) {
        Automovil auto = new Automovil();
        auto.setPatente(unaPatente);
        cp.eliminarAutomovil(auto);
    }
    
    
    
}

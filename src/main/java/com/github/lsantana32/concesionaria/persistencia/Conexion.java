package com.github.lsantana32.concesionaria.persistencia;

import com.github.lsantana32.concesionaria.logica.Automovil;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Conexion {

    Dotenv config = Dotenv.configure().load();
    final String URL = config.get("URL");
    final String USER = config.get("USER");
    final String PASSWORD = config.get("PASSWORD");


    public void darDeAlta(Automovil auto) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement state = conexion.prepareStatement("INSERT INTO automoviles (modelo,marca,motor,color,patente,cantPuertas) VALUES (?,?,?,?,?,?)")) {
            state.setString(1, auto.getModelo());
            state.setString(2, auto.getMarca());
            state.setString(3, auto.getMotor());
            state.setString(4, auto.getColor());
            state.setString(5, auto.getPatente());
            state.setInt(6, auto.getCantPuertas());
            state.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public Automovil consultar(Automovil unAuto) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conexion.prepareStatement("SELECT * FROM automoviles WHERE patente=?")
        ) {
            ps.setString(1, unAuto.getPatente());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    String modelo = rs.getString("modelo");
                    String marca = rs.getString("marca");
                    String motor = rs.getString("motor");
                    String color = rs.getString("color");
                    int cantPuertas = rs.getInt("cantPuertas");
                    unAuto.setModelo(modelo);
                    unAuto.setMarca(marca);
                    unAuto.setMotor(motor);
                    unAuto.setColor(color);
                    unAuto.setCantPuertas(cantPuertas);
                } else{
                    throw new SQLException("La patente ingresada no existe");
                }
            }
            return unAuto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarAutimovil(Automovil auto) {
        try(Connection conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement ps = conexion.prepareStatement("UPDATE automoviles SET modelo=? , marca=? , motor=? , color = ? , cantPuertas=? WHERE patente=?")){
            ps.setString(1, auto.getModelo());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getMotor());
            ps.setString(4, auto.getColor());
            ps.setInt(5, auto.getCantPuertas());
            ps.setString(6, auto.getPatente());
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
            
    }

    public void eliminarAutomovil(Automovil auto) {
        try(Connection conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM automoviles WHERE patente = ?")) {
            ps.setString(1, auto.getPatente());
            ps.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Dog;

/**
 *
 * @author sa
 */
public class DogDao {
    
    public ArrayList<Dog> listarDogs() throws ExceptionDao, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Dog> dogs = new ArrayList<>();
        try {
            st = con.prepareStatement("SELECT * FROM dog");
            rs = st.executeQuery();
            while (rs.next()) {
                Dog d = new Dog();
                d.setIdDog(rs.getInt("idDog"));
                d.setNomeDog(rs.getString("nomeDog"));
                dogs.add(d);
            }
            return dogs;
        } catch (SQLException e) {
            throw new ExceptionDao("Erro ao listar veterinario" + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public ArrayList<Dog> listarDogs(String vet) throws ExceptionDao, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Dog> dogs = new ArrayList<>();
        try {
            st = con.prepareStatement("SELECT v.nome,v.crvm FROM vet.dog as d, vet.veterinario as v where d.idDog=v.id_dog and v.nome = '%" + vet + "%'");
            rs = st.executeQuery();
            while (rs.next()) {
                Dog d = new Dog();
                d.setNomeDog(rs.getString("nomeDog"));
                d.setNomeDog(rs.getString("nomeDog"));
                dogs.add(d);
            }
            return dogs;
        } catch (SQLException e) {
            throw new ExceptionDao("Erro ao listar veterinario" + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}

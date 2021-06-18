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
import model.Fornecedor;

/**
 *
 * @author sa
 */
public class FornecedorDao {

//    public Fornecedor BuscaFornecedor(int id) throws SQLException {
//
//        Connection con = new ConnectionFactory().getConnection();
//        Fornecedor f = new Fornecedor();
//        PreparedStatement st = con.prepareStatement("SELECT nomeForn FROM vet.fornecedor WHERE idForn = '%" + id + "%'");
//        ResultSet rs = st.executeQuery();
//        try {
//            if (rs.next()) {
//                f.setNomeForn(rs.getString("nomeForn"));
//            }
////            System.out.println("f" + f);
////            System.out.println("f nome" + f.getNomeForn());
//            return f;
//        } catch (SQLException e) {
//
//        }
//        return null;
//
//    }

//    public String BuscaForn(int id) throws SQLException {
//
//        Connection con = new ConnectionFactory().getConnection();
//        String nome = null;       
//        
////        System.out.println("rs"+rs.getString("nomeForn"));
//        try {
//            PreparedStatement st = con.prepareStatement("SELECT nomeForn FROM vet.fornecedor WHERE idForn = '%" + id + "%'");
//            ResultSet rs = st.executeQuery();
//             while (rs.next()) {
//                nome = rs.getString("nomeForn");
//             }
//            
//            System.out.println("f" + nome);
//            System.out.println("aqui");
//            return nome;
//        } catch (SQLException e) {
//
//        }
//        return null;
//
//    }

    public ArrayList<Fornecedor> listarFornecedores() throws ExceptionDao {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        try {
            st = con.prepareStatement("SELECT * FROM fornecedor");
            rs = st.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setIdForn(rs.getInt("idForn"));
                f.setNomeForn(rs.getString("nomeForn"));
                fornecedores.add(f);
            }
            return fornecedores;
        } catch (SQLException e) {
            throw new ExceptionDao("Erro ao listarfornecedores" + e);
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

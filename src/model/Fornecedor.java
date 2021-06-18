/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FornecedorDao;
import java.sql.SQLException;

/**
 *
 * @author sa
 */
public class Fornecedor {
    private int idForn;
    private String nomeForn;

    public int getIdForn() {
        return idForn;
    }

    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    public String getNomeForn() {
        return nomeForn;
    }

    public void setNomeForn(String nomeForn) {
        this.nomeForn = nomeForn;
    }

//    public Fornecedor buscaFornecedor(int id) throws SQLException {
//        return new FornecedorDao().BuscaFornecedor(id);
//    }
//    
//    public String buscaForn(int id) throws SQLException {
//        return new FornecedorDao().BuscaForn(id);
//    }
  
}

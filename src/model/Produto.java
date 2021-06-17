/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ExceptionDao;
import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sa
 */
public class Produto {

    private int idProd;
    private String nomeProd;
    private String codBarrasProd;
    private double valorProd;
    private String ncmProd;
    private int codFornecedor;

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getCodBarrasProd() {
        return codBarrasProd;
    }

    public void setCodBarrasProd(String codBarrasProd) {
        this.codBarrasProd = codBarrasProd;
    }

    public double getValorProd() {
        return valorProd;
    }

    public void setValorProd(double valorProd) {
        this.valorProd = valorProd;
    }

    public String getNcmProd() {
        return ncmProd;
    }

    public void setNcmProd(String ncmProd) {
        this.ncmProd = ncmProd;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }
    
    public ArrayList<Produto> listarProdutos(String nome) throws ExceptionDao, SQLException{
        return new ProdutoDao().listarProdutos(nome);
    }
    
}

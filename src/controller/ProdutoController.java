/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExceptionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author sa
 */
public class ProdutoController {

    public ArrayList<Produto> listarProdutos(String nome) throws ExceptionDao, SQLException {
        Produto prod = new Produto();
        return prod.listarProdutos(nome);

    }

    public ArrayList<Produto> listarProdutosPorFornecdor(String nomeFornecedor) throws ExceptionDao, SQLException {
        Produto prod = new Produto();
        return prod.listarProdutosPorFornecedor(nomeFornecedor);
    }

    public ArrayList<Produto> listarProdutos() throws ExceptionDao, SQLException {
        Produto prod = new Produto();
        return prod.listarProdutos();
    }
}

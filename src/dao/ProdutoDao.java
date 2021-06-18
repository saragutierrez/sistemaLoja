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
import model.Produto;

/**
 *
 * @author sa
 */
public class ProdutoDao {

    public ArrayList<Produto> listarProdutos() throws ExceptionDao, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            st = con.prepareStatement("SELECT * FROM produto order by nomeProd");
            rs = st.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProd(rs.getInt("idProd"));
                    p.setNomeProd(rs.getString("nomeProd"));
                    p.setCodBarrasProd(rs.getString("codBarrasProd"));
                    p.setValorProd(rs.getDouble("valor"));
                    p.setCodFornecedor(rs.getInt("idFornecedor"));
                    p.setNcmProd(rs.getString("ncmProd"));
                    listaProdutos.add(p);
                }
            }
            return listaProdutos;
        } catch (SQLException e) {
            throw new ExceptionDao("Erro buscar veterinario específico" + e);
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

    public ArrayList<Produto> listarProdutos(String nome) throws ExceptionDao, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            st = con.prepareStatement("SELECT * FROM produto where nomeProd like '%" + nome + "%' order by nomeProd");
            rs = st.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProd(rs.getInt("idProd"));
                    p.setNomeProd(rs.getString("nomeProd"));
                    p.setCodBarrasProd(rs.getString("codBarrasProd"));
                    p.setValorProd(rs.getDouble("valor"));
                    p.setCodFornecedor(rs.getInt("idFornecedor"));
                    p.setNcmProd(rs.getString("ncmProd"));
                    listaProdutos.add(p);
                }
            }
            return listaProdutos;
        } catch (SQLException e) {
            throw new ExceptionDao("Erro buscar veterinario específico" + e);
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

    public ArrayList<Produto> listarProdutosPorFornecedor(String nome) throws ExceptionDao, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            st = con.prepareStatement("SELECT * FROM vet.produto as p, vet.fornecedor as f where f.idForn = p.idFornecedor and f.nomeForn like '%" + nome + "%' order by p.nomeProd");
            rs = st.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProd(rs.getInt("idProd"));
                    p.setNomeProd(rs.getString("nomeProd"));
                    p.setCodBarrasProd(rs.getString("codBarrasProd"));
                    p.setValorProd(rs.getDouble("valor"));
                    p.setCodFornecedor(rs.getInt("idFornecedor"));
                    p.setNcmProd(rs.getString("ncmProd"));
                    listaProdutos.add(p);
                    System.out.println("CodBarrasProd"+p.getCodBarrasProd());
                    System.out.println("ncm"+p.getNcmProd());
                    System.out.println("valor"+p.getValorProd());
                    System.out.println("id"+p.getIdProd());
                    System.out.println("codForn"+p.getCodFornecedor());
                }
            }
            return listaProdutos;
        } catch (SQLException e) {
            throw new ExceptionDao("Erro buscar veterinario específico" + e);
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

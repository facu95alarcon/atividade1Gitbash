/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
    boolean verifier = true;    
    try{
            conectaDAO conexao = new conectaDAO();
            conexao.conectar();
            String sql = "INSERT INTO produtos(nome,valor,status) VALUES (?,?,?);";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, produto.getNome());
            query.setInt(2,produto.getValor());
            query.setString(3,produto.getStatus());
            
            
            query.execute();
            conexao.desconectar();
            verifier = true;
        }catch(SQLException se){
          JOptionPane.showMessageDialog(null,"Erro ao cadastrar registro no banco de dados!.");
           verifier = false;
           
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}


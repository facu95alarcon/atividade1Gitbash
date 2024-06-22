

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
     boolean verifier;
    
    public void cadastrarProduto (ProdutosDTO produto){
        
       
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
        ArrayList<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();
         try{
            conectaDAO conexao = new conectaDAO();
            conexao.conectar();
            String sql = "SELECT * FROM produtos";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();
            
            while(resposta.next()){
                ProdutosDTO p = new ProdutosDTO();
                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("nome"));
                p.setValor(resposta.getInt("valor"));
                p.setStatus(resposta.getNString("status"));
               
                lista.add(p);
            }
            conexao.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao listar os PRODUTOS do Banco de Dados, por favor, tente novamente. ");
        }
        return lista;
    }
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
        ArrayList<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();
        try{
            conectaDAO conexao = new conectaDAO();
            conexao.conectar();
            String sql = "SELECT * FROM produtos WHERE status='vendido'";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();
            
            while(resposta.next()){
                ProdutosDTO p = new ProdutosDTO();
                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("nome"));
                p.setValor(resposta.getInt("valor"));
                p.setStatus(resposta.getNString("status"));
               
                lista.add(p);
            }
            conexao.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao listar os FILMES do Banco de Dados, por favor, tente novamente. ");
        }
        return lista;
    }
            
    public static boolean venderProduto (int id){
         try{
            conectaDAO conexao = new conectaDAO();
            conexao.conectar();
            String sql = "UPDATE produtos SET status='vendido' WHERE id=?";
           PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
           consulta.setInt(1, id);
           consulta.execute();
           conexao.desconectar();
           return true;
    }catch(SQLException s){
    JOptionPane.showMessageDialog(null, "Erro ao excluir o registro no banco de dados (SQL)");
    return false;
    }
        
    }
    
    
    
        
}


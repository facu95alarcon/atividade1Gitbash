
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;






public class conectaDAO {
   
        private Connection conexao; 
        
 public Connection getConexao() {
        return conexao;
    }  
    public void conectar(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11","root","Facu.3895");
        System.out.println("classe conectada com sucesso!");
}catch(ClassNotFoundException e){
            System.out.println("Falha ao carregar a classe de conexão!");
    
}catch(SQLException ex){
        System.out.println("Erro na conexão do SQL");}}
public void desconectar(){
    try{
     if(conexao !=null && !conexao.isClosed()){
    conexao.close();
         System.out.println("DESCONECTADO COM SUCESSO!");
    }
}catch(SQLException e){
        System.out.println("falha ao desconetar o banco!.");
}}}
 
    


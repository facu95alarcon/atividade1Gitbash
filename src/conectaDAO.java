
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
    public Connection connectDB(){
        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }}
    


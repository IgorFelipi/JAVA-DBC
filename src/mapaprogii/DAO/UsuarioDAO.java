
package mapaprogii.DAO;

import mapaprogii.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    public void inserir(Usuario usuario){
        
            String sql = "INSERT INTO usuario(nome, login, senha, email) values (?,?,?,?)";
            
            PreparedStatement ps;
            
            try{
                ps = Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getLogin());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getEmail());
                
                ps.execute();
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Houve um erro ao tentar inserir dados na tabela");
        
            }   
    }
    
    public Usuario AutenticarUsuario(String login, String senha){
        
        String sql = "SELECT id, nome, login, senha , email from mapa.usuario where login = ? and senha = ?";
        
        PreparedStatement ps;
        ResultSet rs;
        ps = null;
        rs = null;
        
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, login); 
            ps.setString(2, senha);
            
            
            rs = ps.executeQuery();
            Usuario user = new Usuario();
            
            
           
            if(rs.next()){
                
                user.setLogin(rs.getString("LOGIN"));
                user.setSenha(rs.getString("SENHA"));
                
                return user;
            }else{
                return null;
                
            }
         }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar pesquisar dados na tabela");
            
        }finally{
            try{
                if (rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Falha ao fechar a operação, erro: " + e);
            }
        }
        return null;
    
}
}

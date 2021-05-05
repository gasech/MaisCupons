
package br.senac.tads.pi3.maiscupons;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bianca
 */
@WebServlet(name = "cadastroUsuarioServlet", urlPatterns = {"/cadastroUsuarioServlet"})

public class cadastroUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private UsuarioDao usuarioDao;

    public void init() {
        usuarioDao = new UsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setTelefone(telefone);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        
        try {
            usuarioDao.cadastrarUsuario(usuario);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        response.sendRedirect("/MaisCupons/logUsuario.jsp");
    }

    

}

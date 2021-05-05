package br.senac.tads.pi3.maiscupons;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bianca
 */
@WebServlet(name = "logUsuarioServlet", urlPatterns = {"/logUsuarioServlet"})

public class logUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LogUsuarioDao logUsuarioDao;

    public void init() {
        logUsuarioDao = new LogUsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        LogUsuarioBean logUsuarioBean = new LogUsuarioBean();
        logUsuarioBean.setEmail(email);
        logUsuarioBean.setSenha(senha);

        try {
            if (logUsuarioDao.validarUsuario(logUsuarioBean)) {
                response.sendRedirect("/MaisCupons/telaUsuario.jsp");
            } else {
                response.sendRedirect("/MaisCupons/logUsuario.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(logUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

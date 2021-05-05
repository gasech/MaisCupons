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
@WebServlet(name = "logEmpresaServlet", urlPatterns = {"/logEmpresaServlet"})

public class logEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LogEmpresaDao logEmpresaDao;

    public void init() {
        logEmpresaDao = new LogEmpresaDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        LogEmpresaBean logEmpresaBean = new LogEmpresaBean();
        logEmpresaBean.setEmail(email);
        logEmpresaBean.setSenha(senha);

        try {
            if (logEmpresaDao.validarEmpresa(logEmpresaBean)) {
                response.sendRedirect("/MaisCupons/telaEmpresa.jsp");
            } else {
                response.sendRedirect("/MaisCupons/logEmpresa.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(logUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

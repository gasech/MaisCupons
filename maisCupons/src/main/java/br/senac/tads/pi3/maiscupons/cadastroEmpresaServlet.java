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
@WebServlet(name = "cadastroEmpresaServlet_1", urlPatterns = {"/cadastroEmpresaServlet_1"})
public class cadastroEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private EmpresaDao empresaDao;

    public void init() {
        empresaDao = new EmpresaDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setCnpj(cnpj);
        empresa.setTelefone(telefone);
        empresa.setEmail(email);
        empresa.setSenha(senha);

        try {
            empresaDao.cadastrarEmpresa(empresa);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("/MaisCupons/index.html");
    }

    
}

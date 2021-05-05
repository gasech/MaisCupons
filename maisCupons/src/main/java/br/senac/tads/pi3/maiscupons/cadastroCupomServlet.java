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
@WebServlet(name = "cadastroCupomServlet", urlPatterns = {"/cadastroCupomServlet"})

public class cadastroCupomServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CupomDao cupomDao;

    public void init() {
        cupomDao = new CupomDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String departamento = request.getParameter("departamento");
        String desconto = request.getParameter("desconto");

        Cupom cupom = new Cupom();
        cupom.setNome(nome);
        cupom.setDepartamento(departamento);
        cupom.setDesconto(desconto);

        try {
            cupomDao.cadastrarCupom(cupom);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("/MaisCupons/telaEmpresa.jsp");
    }
}


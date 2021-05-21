/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "SolicitacaoUsuarioServlet", urlPatterns = {"/SolicitacaoUsuarioServlet"})
public class SolicitacaoUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SolicitacaoUsuarioDao solicitacaoUsuarioDao;

    public void init() {
        solicitacaoUsuarioDao = new SolicitacaoUsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String mensagem = request.getParameter("mensagem");

        SolicitacaoUsuario solicitacaoUsuario = new SolicitacaoUsuario();
        solicitacaoUsuario.setNome(nome);
        solicitacaoUsuario.setCpf(cpf);
        solicitacaoUsuario.setMensagem(mensagem);

        try {
            solicitacaoUsuarioDao.registrarMensagemUsuario(solicitacaoUsuario);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("/MaisCupons/telaUsuario.jsp");
    }
}

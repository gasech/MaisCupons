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
@WebServlet(name = "SolicitacaoEmpresaServlet", urlPatterns = {"/SolicitacaoEmpresaServlet"})

public class SolicitacaoEmpresaServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

    private SolicitacaoEmpresaDao solicitacaoEmpresaDao;

    public void init() {
        solicitacaoEmpresaDao = new SolicitacaoEmpresaDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String mensagem = request.getParameter("mensagem");

        SolicitacaoEmpresa solicitacaoEmpresa = new SolicitacaoEmpresa();
        solicitacaoEmpresa.setNome(nome);
        solicitacaoEmpresa.setCnpj(cnpj);
        solicitacaoEmpresa.setMensagem(mensagem);

        try {
            solicitacaoEmpresaDao.registrarMensagemEmpresa(solicitacaoEmpresa);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("/MaisCupons/telaEmpresa.jsp");
    }
}
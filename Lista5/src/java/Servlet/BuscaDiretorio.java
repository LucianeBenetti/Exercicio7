package Servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaDiretorio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String buscar = request.getParameter("diretorio");
        File buscaDiretorio = new File(buscar);
        File arquivos = null;
        ArrayList<String> conteudo = new ArrayList<>();
        ArrayList<Long> tamanho = new ArrayList<>();
        //  String modificado = "";
        if (buscaDiretorio.isDirectory()) {

            File[] diretorio = buscaDiretorio.listFiles();

            for (int i = 0; i < diretorio.length; i++) {
                arquivos = diretorio[i];
                conteudo.add(arquivos.getName());
                tamanho.add(arquivos.getUsableSpace());
                request.setAttribute("diretorios", conteudo);

                //   request.setAttribute("tamanho", tamanho);
                //   request.setAttribute("modificado", modificado);
            }
        }
        if (conteudo.contains(".")) {

            request.setAttribute("diretorioDesenho", arquivos);
            System.out.println(arquivos);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

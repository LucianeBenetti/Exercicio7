package Servlet;

import Classes.Cardapio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pedido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object c = request.getSession().getAttribute("cardapio");
        if (c != null) {
            ArrayList<Cardapio> cardapio = (ArrayList<Cardapio>) c;

            Double valorTotal = 0.0;
            Double valorPedido = 0.0;
            Integer valorCalorias = 0;
            Integer caloriasTotal = 0;

            for (int i = 0; i < cardapio.size(); i++) {

                String nome = cardapio.get(i).getNome();
                Double preco = cardapio.get(i).getPreco();
                int calorias = cardapio.get(i).getCalorias();
                String descricao = cardapio.get(i).getDescricao();

                String quantidade = request.getParameter("valores_" + i);
                int qtidade = Integer.parseInt(quantidade);
                
                Cardapio pedidoCardapio = new Cardapio(nome, preco, descricao, calorias, qtidade);

                valorPedido = preco * qtidade;
                valorCalorias = calorias * qtidade;
                cardapio.add(pedidoCardapio);

            }
            System.out.println(cardapio);
            valorTotal += valorTotal + valorPedido;
            caloriasTotal += caloriasTotal + valorCalorias;

            request.setAttribute("valor", valorTotal);
            request.setAttribute("calorias", caloriasTotal);
            request.setAttribute("pedido", cardapio);
        }

        request.getRequestDispatcher("pedidoCliente.jsp").forward(request, response);

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

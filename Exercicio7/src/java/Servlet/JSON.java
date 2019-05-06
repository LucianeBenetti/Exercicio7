package Servlet;

import Classes.Cardapio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JSON extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParserConfigurationException, SAXException {
        response.setContentType("text/html;charset=UTF-8");

        String cardapioJson = request.getParameter("cardapioJson");
        ArrayList<Cardapio> conteudoCardapio = new ArrayList<Cardapio>();

        if (cardapioJson != null) {
            File arquivoCardapio = new File("C:\\SENAC\\XML\\cardapio.xml");
            FileInputStream encontrarArquivo = new FileInputStream(arquivoCardapio);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(encontrarArquivo);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("refeicao");

            for (int i = 0; i < nList.getLength(); i++) {
                Cardapio itemDeCardapio = new Cardapio();
                NodeList childs = nList.item(i).getChildNodes();
                itemDeCardapio.setNome(childs.item(1).getTextContent());
                itemDeCardapio.setPreco(Double.parseDouble(childs.item(3).getTextContent()));
                itemDeCardapio.setDescricao(childs.item(5).getTextContent());
                itemDeCardapio.setCalorias(Integer.parseInt(childs.item(7).getTextContent()));
                conteudoCardapio.add(itemDeCardapio);
            }
        }
        JSONObject obj = new JSONObject();
        JSONObject mainObject = new JSONObject();
        JSONArray arrayObjects = new JSONArray();
        JSONArray arrayRefeicao = new JSONArray();

        for (int i = 0; i < conteudoCardapio.size(); i++) {
            if (conteudoCardapio.get(i).getCalorias() != 0) {
                obj = new JSONObject();
                obj.put("nome", conteudoCardapio.get(i).getNome());
                obj.put("preco", conteudoCardapio.get(i).getPreco());
                obj.put("descricao", conteudoCardapio.get(i).getDescricao());
                obj.put("calorias", conteudoCardapio.get(i).getCalorias());
                arrayObjects.add(obj);
            }
        }
        obj = new JSONObject();
        obj.put("refeicao", arrayObjects);
        arrayRefeicao.add(obj);
        mainObject.put("menu", arrayRefeicao);
        
        try {
            File file = new File("C:\\SENAC\\XML\\cardapioJSON.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(mainObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("cardapio", conteudoCardapio);
        request.setAttribute("conteudoCardapio", conteudoCardapio);
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
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

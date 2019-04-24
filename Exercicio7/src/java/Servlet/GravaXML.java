/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GravaXML extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParserConfigurationException, SAXException {
        response.setContentType("text/html;charset=UTF-8");

        File f = new File("C:\\Users\\Aluno\\Downloads\\meuxml.xml");
        FileInputStream in = new FileInputStream(f);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(in);
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("estado");
        System.err.println("Root: " + nList.getLength());
        for (int i = 0; i < nList.getLength(); i++) {
            String attNome = nList.item(i).getAttributes().getNamedItem("nome").getNodeValue();

            String attSigla = nList.item(i).getAttributes().getNamedItem("sigla").getNodeValue();
            System.out.println(attNome + "(" + attSigla + ")");
            NodeList cidadesNode = nList.item(i).getChildNodes();

            for (int j = 0; j < cidadesNode.getLength(); j++) {
                
                try {
                    NodeList cidadeAtts = cidadesNode.item(j).getChildNodes();
                    //  System.out.println ("Attributos cidade: "+ cidadeAtts.getLength());

                    String nomeCidade = cidadeAtts.item(1).getTextContent();
                    String populacao = cidadeAtts.item(3).getTextContent();
                    String pib = cidadeAtts.item(5).getTextContent();
                    String area = cidadeAtts.item(7).getTextContent();
                    System.out.println(nomeCidade + " | " + populacao + "|" + pib + "|" + area);
                } catch (Exception err) {
                    //  System.err.println("Erro em :"+j);
                    // System.err.println(err.getMessage());
                }
            }

            // System.out.println("Tag content:" + nList.item(1).getTextContent());
        }

    }

    public static void escreveXML() throws ParserConfigurationException, TransformerException, FileNotFoundException, IOException {
//        Estado sc = new Estado("SC", "Santa Catarina");
//        Estado rs = new Estado("RS", "Rio Grande do Sul");
//        Estado pr = new Estado("PR", "Paraná");
//
//        sc.getCidades().add(new Cidade("Florianópolis", 1, 2, 3));
//        sc.getCidades().add(new Cidade("Blumenau", 1, 2, 3));
//        sc.getCidades().add(new Cidade("Pomerode", 1, 2, 3));
//
//        rs.getCidades().add(new Cidade("Porto Alegre", 1, 2, 3));
//        rs.getCidades().add(new Cidade("Canoas", 1, 2, 3));
//        rs.getCidades().add(new Cidade("Pelotas", 1, 2, 3));
//
//        pr.getCidades().add(new Cidade("Curitiba", 1, 2, 3));
//        pr.getCidades().add(new Cidade("Londrina", 1, 2, 3));
//        pr.getCidades().add(new Cidade("Foz do Iguaçu", 1, 2, 3));
//
//        ArrayList<Estado> estados = new ArrayList<Estado>();
//        estados.add(pr);
//        estados.add(sc);
//        estados.add(rs);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element rootTag = doc.createElement("estados");

        for (Estado e : estados) {
            Element estado = doc.createElement("estado");
            estado.setAttribute("sigla", e.getSigla());
            estado.setAttribute("nome", e.getNome());
            for (Cidade c : e.getCidades()) {
                Element cidade = doc.createElement("cidade");

                Element nome = doc.createElement("nome");
                cidade.appendChild(nome);
                nome.setTextContent(c.getNome());

                Element populacao = doc.createElement("populacao");
                cidade.appendChild(populacao);
                populacao.setTextContent(String.valueOf(c.getPopulacao()));

                Element pib = doc.createElement("pib");
                cidade.appendChild(pib);
                pib.setTextContent(String.valueOf(c.getPib()));

                Element area = doc.createElement("area");
                cidade.appendChild(area);
                area.setTextContent(String.valueOf(c.getArea()));

                estado.appendChild(cidade);

            }
            rootTag.appendChild(estado);

        }

        //firstLevel.setTextContent("Text content of a tag element");
        doc.appendChild(rootTag);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource domSource = new DOMSource(doc);
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);
        System.out.println(sw.toString());

        File f = new File("C:\\Users\\Aluno\\Downloads\\meuxml.xml");
        FileOutputStream fout = new FileOutputStream(f);
        DataOutputStream dout = new DataOutputStream(fout);
        dout.write(sw.toString().getBytes());
        dout.close();
        fout.close();
    }

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

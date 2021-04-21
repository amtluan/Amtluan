/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.userDAO;
import sample.dto.UserDTO;
import sample.dto.UserErrorDTO;

/**
 *
 * @author ACER
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "insert.jsp";
    private static final String SUCCESS = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullname");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            boolean check = false;
            UserErrorDTO error = new UserErrorDTO("", "", "", "", "");//nghe thuat o day
            if (userID.length() < 3 || userID.length() > 10) {
                check = true;
                error.setUserIDError("UserID must be >3 and <10 !");
            }
            if (fullName.length() < 5 || userID.length() > 50) {
                check = true;
                error.setFullNameError("Full Name must be >5 and <50 !");
            }
            if (roleID.length() < 2 || userID.length() > 10) {
                check = true;
                error.setRoleIDError("RoleID must be >2 and <10 !");
            }
            if (!confirm.equals(password)) {
                check = true;
                error.setConfirmError("Confirm is not maches!");
            }
            if (check) {
                request.setAttribute("ERROR_USER", error);
            } else {
                userDAO dao = new userDAO();
                boolean checkDuplicate = dao.checkDuplicate(userID);
                if (checkDuplicate) {
                    error.setUserIDError("userID is duplicated!");
                    request.setAttribute("ERROR_USER", error);
                } else {
                    UserDTO user = new UserDTO(userID, fullName, roleID, password);
                    dao.insert(user);
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

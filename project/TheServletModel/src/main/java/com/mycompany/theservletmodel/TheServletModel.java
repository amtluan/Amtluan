/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theservletmodel;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ipuil
 */
public class TheServletModel extends HttpServlet{
    private int a=0;

    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException{
        super.init();
        System.out.println("init");
        a+=5;
        System.out.println("a= "+ a);   
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response )
    throws ServletException, IOException{
        response.setContentType("text/http;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet<title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet life Cycle</h1>");
            a+=10;
            out.println("a= "+a);
            

        } finally {
            out.close();
        }

    }

    /**
     *
     */
    @Override
    public void destroy(){
        super.destroy();
        System.out.println("Destroy");
    
}
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response )
    throws ServletException, IOException{
        processRequest(request, response);
        System.out.println("doGet is invoked");
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response )
    throws ServletException, IOException{
         processRequest(request, response);
         System.out.println("doPost is invoked");
     }
    @Override
     protected void service(HttpServletRequest request, HttpServletResponse response )
    throws ServletException, IOException{
         System.out.println("service");
         response.setContentType("text/html");
         PrintWriter out= response.getWriter();
         out.println("This is servicce");
     }
}

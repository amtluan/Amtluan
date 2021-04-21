/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amtluan;

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
public class HelloServlet extends HttpServlet{ 
 // tao servlet de truyen tai du lieu
    @Override
    public void init() throws ServletException {
        System.out.println("Bat dau servlet");
    }

    @Override
    public void destroy() {
        System.out.println("ket thuc servlet");
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
     
        super.service(arg0, arg1); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("phuong thuc cua request" + arg0.getMethod());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      
        PrintWriter writer =resp.getWriter();
        
    }
  
    
    
    
    
    
}

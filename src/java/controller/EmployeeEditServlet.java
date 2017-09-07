/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.FormValidation;
import business.Person;
import data.EmployeeManagerDA;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DateUtil;

/**
 *
 * @author Bill Adams
 */
public class EmployeeEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";
        ArrayList<String> errorMessages = new ArrayList<String>();
        HttpSession session = request.getSession();
        boolean isUpdate = false;
        Person employee = null;
        
        String action = request.getParameter("action");
        if (action.equals("first")) {
            
            url = "/index.jsp";
            session.setAttribute("isUpdate", isUpdate);
            
        } 
        else if (action.equals("editEmployee")) {
            
            int employeeID = Integer.parseInt(request.getParameter("employeeID"));           
            employee = EmployeeManagerDA.selectPersonByID(employeeID);
            request.setAttribute("employee", employee);           
            url = "/edit.jsp";
            
        }
        else if (action.equals("updateEmployee")) {
            
            String validationMessage = "";
            LocalDate birthDate = null;
            LocalDate hireDate = null;

            // Validate the form input.
            String firstName = request.getParameter("firstName");
            validationMessage = FormValidation.validateStringInput(firstName, "First name");
            if (!validationMessage.equals("")) {
                
                errorMessages.add(validationMessage);
                
            }

            String middleName = request.getParameter("middleName");

            String lastName = request.getParameter("lastName");
            validationMessage = FormValidation.validateStringInput(lastName, "Last name");
            if (!validationMessage.equals("")) {
                
                errorMessages.add(validationMessage);
                
            }

            String employeeIDString = request.getParameter("employeeID");
            validationMessage = FormValidation.validateIntegerInput(employeeIDString, "Employee ID");
            if (!validationMessage.equals("")) {
                
                errorMessages.add(validationMessage);
                
            }

            String birthDateString = request.getParameter("birthDate");
            validationMessage = FormValidation.validateDateInput(birthDateString, "Birth date");
            if (!validationMessage.equals("")) {
                
                errorMessages.add(validationMessage);
                
            } else {
                
                birthDate = LocalDate.parse(birthDateString);
                
            }

            String hireDateString = request.getParameter("hireDate");
            validationMessage = FormValidation.validateDateInput(hireDateString, "Hire date");
            if (!validationMessage.equals("")) {
                
                errorMessages.add(validationMessage);
                
            } else {
                
                hireDate = LocalDate.parse(hireDateString);
                
            }

            employee = new Person();
            employee.setEmployeeID(employeeIDString);
            employee.setFirstName(firstName);
            employee.setMiddleName(middleName);
            employee.setLastName(lastName);
            employee.setBirthDate(birthDate);
            employee.setHireDate(hireDate);
            
            // If errorMessages comes back empty (i.e. everything validated), create 
            // or update the person collection and add it to the session.
            if (errorMessages.isEmpty()) {

                // Update an existing employee.
                int updateSuccess = EmployeeManagerDA.updateEmployee(employee);
                if (updateSuccess == 1) {

                    url = "/EmployeeListServlet";
                    
                }
            } else {
                
                // Set attributes the user completed and return them 
                // to the form during the validation process.
                request.setAttribute("employee", employee);
                url = "/edit.jsp";
                request.setAttribute("errorMessages", errorMessages);
                
            }
        }
        
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url)
                .forward(request, response);
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

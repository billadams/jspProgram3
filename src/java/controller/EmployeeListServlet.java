/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.EmployeeManager;
import business.FormValidation;
import business.Person;
import data.EmployeeManagerDA;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DateUtil;
import util.StringUtil;

/**
 *
 * @author da202057
 */
public class EmployeeListServlet extends HttpServlet {

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
        List<String> errorMessages = new ArrayList<>();
        List<Person> employeeList = null;
        EmployeeManager allEmployees = null;
        boolean hasSearched = false;
        HttpSession session = request.getSession();
        String dateInputString = null;
        String listCount = null;
        String message = "";
        int rowCount = 0;
        
        
        // Set the date input to today.
        dateInputString = DateUtil.createFormattedDateInputString();

        // Get the current action
        String action = request.getParameter("action");
        
        if (action == null || action.equals("updateEmployee")) {
            
            // The default action
            action = "defaultList";
            
        }
        
        if (action.equals("defaultList")) {
            
            // Create the default list of employees if they don't already exist.
            rowCount = EmployeeManagerDA.addEmployeesToDB();

            // Create the instances the application needs.
            allEmployees = new EmployeeManager();
            session.setAttribute("allEmployees", allEmployees);
            
            employeeList = new ArrayList<Person>();
            session.setAttribute("employeeList", employeeList);
            
            url = "/index.jsp";
                       
            // Get the default list of employees.
            employeeList = allEmployees.getEmployees();          
            
        }
        else if (action.equals("searchRequest")) {    
            
            String hireDateString = request.getParameter("searchDate");
            LocalDate hireDate = null;
            
            // Validate that the user entered an actual date.
            try {
                
                hireDate = LocalDate.parse(hireDateString);
                
                // Override the default list of employees to reflect the 
                // search criteria the user selected from the form.
                String searchCriteria = request.getParameter("optionsDate");
                allEmployees = (EmployeeManager) session.getAttribute("allEmployees");
                employeeList = allEmployees.searchDB(hireDate, searchCriteria);

                // Format the date for output.
                DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
                String searchDateFormatted = dtf.format(hireDate);
                
                // The user has searched for a date so set the
                // hasSearched variable to true.
                hasSearched = true;
                
                // Format the date the user entered in the date
                // input for display back to the form.
                dateInputString = DateUtil.createFormattedDateInputString(hireDate);
                
                // Get a count of all employees that are in the employeeList.
                listCount = String.valueOf(employeeList.size());

                request.setAttribute("searchCriteria", searchCriteria);
                request.setAttribute("searchDateFormatted", searchDateFormatted);
                request.setAttribute("listCount", listCount);
                
            }
            catch (Exception e) {
                
                // Get the default list of employees.
                allEmployees = (EmployeeManager) session.getAttribute("allEmployees");
                employeeList = allEmployees.getEmployees();
                
                // Set the date input back to today.
                dateInputString = DateUtil.createFormattedDateInputString();
                
                errorMessages.add("Please enter a valid search date.");
                request.setAttribute("errorMessages", errorMessages);
                
            }
        }
        else if (action.equals("clearSearch")) {
            
            // The user cleared the search so set the hasSearched variable
            // to false and generate the default list of employees.
            hasSearched = false;
            allEmployees = (EmployeeManager) session.getAttribute("allEmployees");
            employeeList = allEmployees.getEmployees();
            session.setAttribute("employeeList", employeeList);
            
            // Set the date input to today.
            dateInputString = DateUtil.createFormattedDateInputString();
            
        } 
        else if (action.equals("order")) {
            
            String validationMessage = "";
            String orderBy = request.getParameter("orderBy");
            
            validationMessage = FormValidation.validateOrderByInput(orderBy, "Filter");
            
            if (!validationMessage.equals("")) {
                
                errorMessages.add(validationMessage);
                request.setAttribute("errorMessages", errorMessages);
                allEmployees = (EmployeeManager) session.getAttribute("allEmployees");
                employeeList = allEmployees.getEmployees();
                session.setAttribute("employeeList", employeeList);
                
            }
            else {
                
                employeeList = EmployeeManagerDA.sortListAscending(orderBy);
                session.setAttribute("employeeList", employeeList);
                message = "Employee List sorted by " + StringUtil.convertEnumToString(orderBy) + ".";
                request.setAttribute("message", message);
            }            
        }
        
        // Persist the hasSearched variable.
        session.setAttribute("hasSearched", hasSearched);
        
        request.setAttribute("rowcount", rowCount);
        request.setAttribute("dateInputString", dateInputString);
        request.setAttribute("employeeList", employeeList);
        
        this.getServletContext().getRequestDispatcher(url)
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

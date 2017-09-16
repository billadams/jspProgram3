/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.time.LocalDate;
import business.EmployeeOrderByWhiteList;
import util.StringUtil;

/**
 *
 * @author Bill
 */
public class FormValidation {
    
    public static String validateStringInput(String fieldString, String fieldName) {
        
        String message = "";
        
        if (fieldString.equals("")) {
            message = fieldName + " is required.";
        }
        
        return message;
    }
    
    public static String validateIntegerInput(String fieldString, String fieldName) {
        
        String message = "";

        try {
            
            int i = Integer.parseInt(fieldString);
            
        }
        catch (NumberFormatException e) {
            
            message = fieldName + " is required and must be a valid Integer.";
            
        }

        return message;
    }
    
    public static String validateDoubleInput(String fieldString, String fieldName) {

        String message = "";

        try {

            Double i = Double.parseDouble(fieldString);

        } catch (NumberFormatException e) {

            message = fieldName + " is required and must be a valid Double.";

        }

        return message;
    }
    
    public static String validateDateInput(String fieldString, String fieldName) {
        
        String message = "";

        try {
            
            LocalDate date = LocalDate.parse(fieldString);
            
        } catch (Exception e) {
            
            message = fieldName + " is required and must be a valid Date.";
            
        }

        return message;
    } 
    
    public static String validateOrderByInput(String fieldString, String fieldName) {
        
        String message = "";
        boolean matchFlag = false;

        for (EmployeeOrderByWhiteList orderByInput : EmployeeOrderByWhiteList.values()) {
        
            if (fieldString.equals(orderByInput.toString())) {
                matchFlag = true;
                
            }       
        }
        
        if (matchFlag == true) {
            
            return message;
            
        }
        else {
            
            message = "Please select one of the available filter options.";
            
        }
        
        return message;
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Bill Adams
 */
public class ValidationException extends Exception {
    
    ArrayList<String> messages = new ArrayList<String>();
 
    public ValidationException() {}
    
    public ValidationException(String message) {
        
        messages.add(message);
        
    }
}

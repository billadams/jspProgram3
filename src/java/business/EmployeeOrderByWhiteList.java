/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Bill Adams
 */
public enum EmployeeOrderByWhiteList {
    
    FIRST_NAME,
    MIDDLE_NAME,
    LAST_NAME,
    BIRTH_DATE,
    HIRE_DATE;
    
    @Override
    public String toString() {
        
        String string = "";
        
        if (this.ordinal() == 0) {
            
            string = "firstName";
            
        }
        else if (this.ordinal() == 1) {
            
            string = "middleName";
            
        }
        else if (this.ordinal() == 2) {
            
            string = "lastName";
            
        }
        else if (this.ordinal() == 3) {
            
            string = "birthDate";
            
        }
        else if (this.ordinal() == 4) {
            
            string = "hireDate";
            
        }
        
        return string;
    }
}
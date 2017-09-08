/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import business.EmpHourly;
import business.EmpSalary;
import business.Person;
import java.time.LocalDate;

/**
 *
 * @author Bill Adams
 */
public class EmployeeFactory {
    
    public static Person createPerson(String firstName, String middleName, String lastName, String employeeID,
            LocalDate birthDate, LocalDate hireDate, double salary, double rate, double avgWeeklyHours) {
        
        if (salary != 0) {
            
            return new EmpSalary(firstName, middleName, lastName, employeeID, birthDate, hireDate, salary);
            
        }      
        else if (rate != 0) {
            
            return new EmpHourly(firstName, middleName, lastName, employeeID, birthDate, hireDate, rate, avgWeeklyHours);
                
        }
        else {
            
            return new Person(firstName, middleName, lastName, employeeID, birthDate, hireDate);
            
        }      
    }
}

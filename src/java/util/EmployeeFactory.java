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
            LocalDate birthDate, LocalDate hireDate, Double salary, Double rate, Double avgWeeklyHours) {
        
        if (salary != null) {
            
            return new EmpSalary(firstName, middleName, lastName, employeeID, birthDate, hireDate, salary);
            
        }      
        else if (rate != null) {
            
            return new EmpHourly(firstName, middleName, lastName, employeeID, birthDate, hireDate, rate, avgWeeklyHours);
            
        }
        else {
            
            return new Person(firstName, middleName, lastName, employeeID, birthDate, hireDate);
            
        }      
    }
}

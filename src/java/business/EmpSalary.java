/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.NumberFormat;
import java.time.LocalDate;

/**
 *
 * @author fssco
 */
public class EmpSalary extends Person {
    
    private Double salary;
    
    public EmpSalary () {}
    
    public EmpSalary(String firstName, String middleName, String lastName, String employeeID, 
            LocalDate birthDate, LocalDate hireDate, Double salary) {
        super(firstName, middleName, lastName, employeeID, birthDate, hireDate);
        
        this.salary = salary;
        
    }

    /**
     * @return the salary
     */
    public Double getSalary() {
        
        return salary;
        
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        
        this.salary = salary;
        
    }
    
        public String getYearlyPayCurrencyFormat() {
        
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        return currency.format(this.salary);
    }
    
}

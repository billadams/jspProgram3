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
public class EmpHourly extends Person {
    
    private Double rate;
    private Double avgWeeklyHours;
    
    public EmpHourly() {}
    
    public EmpHourly(String firstName, String middleName, String lastName, String employeeID, 
            LocalDate birthDate, LocalDate hireDate, Double rate, Double avgWeeklyHours) {
        super(firstName, middleName, lastName, employeeID, birthDate, hireDate);
        
        this.rate = rate;
        this.avgWeeklyHours= avgWeeklyHours;
        
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        
        return rate;
        
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        
        this.rate = rate;
        
    }

    /**
     * @return the avgWeeklyHours
     */
    public Double getAvgWeeklyHours() {
        
        return avgWeeklyHours;
        
    }

    /**
     * @param avgWeeklyHours the avgWeeklyHours to set
     */
    public void setAvgWeeklyHours(Double avgWeeklyHours) {
        
        this.avgWeeklyHours = avgWeeklyHours;
        
    }
    
    public double getYearlyPay() {
        
        double yearlyPay = this.rate * this.avgWeeklyHours * 50;
        
        return yearlyPay;
        
    }
    
    public String getYearlyPayCurrencyFormat() {
        
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        return currency.format(this.getYearlyPay());
    }
    
}

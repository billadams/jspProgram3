/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author fssco
 */
public class EmpHourly extends Person{
    private double rate;
    private double avgWeeklyHours;
    
    public EmpHourly() {}
    
    public EmpHourly(String firstName, String middleName, String lastName, String employeeID, LocalDate birthDate, LocalDate hireDate, double rate, double avgWeeklyHours) {
        super(firstName, middleName, lastName, employeeID, birthDate, hireDate);
        this.rate = rate;
        this.avgWeeklyHours= avgWeeklyHours;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @return the avgWeeklyHours
     */
    public double getAvgWeeklyHours() {
        return avgWeeklyHours;
    }

    /**
     * @param avgWeeklyHours the avgWeeklyHours to set
     */
    public void setAvgWeeklyHours(double avgWeeklyHours) {
        this.avgWeeklyHours = avgWeeklyHours;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonafede.ian_linearlinkedlistlab;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Ian_2
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        PrintWriter p = new PrintWriter(new File("csci.txt"));
        Scanner payfileS = new Scanner(new File("payfile.txt"));
        Scanner hirefileS = new Scanner(new File("hirefile.txt"));
        Scanner firefileS = new Scanner(new File("firefile.txt"));
        
        Payroll pay = new Payroll(p, payfileS);
        Payroll hire = new Payroll(p, hirefileS);
        Payroll fire = new Payroll(p, firefileS);
        
        
        
        
        ObjectList employeeList = pay.makeEmployeeList();
        
        pay.outputAllEmployees(employeeList);
        
        pay.countEmployees(employeeList);
        
        pay.countWomenNames(employeeList);
        
        pay.countWeeklyEmployees(employeeList);
        
        pay.giveRaise(employeeList);
        
        ObjectList alphaOrderEmployeeList = pay.alphaOrderList(employeeList);
        
        pay.printAllNamesAndSalaries(alphaOrderEmployeeList);
        
        hire.addEmployeesToSortedList(alphaOrderEmployeeList);
        
        System.out.println("Added Employees to the list");
        p.println("Added Employees to the list");
        
        hire.printAllNamesAndSalaries(alphaOrderEmployeeList);
        
        fire.deleteFiredEmployees(alphaOrderEmployeeList);
        
        System.out.println("Removed Employees from the list");
        p.println("Added Employees to the list");
        
        fire.printAllNamesAndSalaries(alphaOrderEmployeeList);
        
        p.close();
    }
    
}

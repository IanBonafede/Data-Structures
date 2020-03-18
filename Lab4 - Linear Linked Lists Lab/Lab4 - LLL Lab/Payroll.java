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
public class Payroll {
    
    PrintWriter pw;
    Scanner s;
    
    ObjectList alphaList = new ObjectList();
    
    /**
     *
     * @param p
     * @param s
     */
    public Payroll(PrintWriter p, Scanner s) {
        this.pw = p;
        this.s = s;
    }
    
    /**Uses the scanner class to take in strings, split them into an array
     * of strings, and make an employee object from those strings, and add
     * that employee to a list, all in a loop.
     *
     * @return ObjectList
     */
    public ObjectList makeEmployeeList() {
        
        ObjectList employeeList = new ObjectList();
        
        while (s.hasNext()) {
            String tempS = s.nextLine();
            
            String[] tokens = tempS.split("[ ]+");
            
            String fN = tokens[0];
            String lN = tokens[1];
            String gend = tokens[2];
            String tenu = tokens[3];
            String rt = tokens[4];
            String slry = tokens[5];
            
            Employee tempE = new Employee(fN, lN, gend, tenu, rt, slry);
            
            ObjectListNode tempN = new ObjectListNode(tempE);
            
            employeeList.addLast(tempN);
        }
        
        return employeeList;
    }
    
    /** Uses an index to count the number of nodes in the list
     *
     * @param list
     */
    public void countEmployees(ObjectList list) {
        int i = 0;
        
        if (list == null) {
            System.out.println("Runtime Error: employee list is null");
            System.exit(1);
        }
        
        ObjectListNode p = list.getFirstNode();
        
        while (p != null) {
            i++;
            p = p.getNext();
        }
        
        System.out.println("Number of employees: " + i + "\n");
        pw.println("Number of employees: " + i + "\r\n");
    }
    
    /**Loops through the list, checks every gender, if its "F" it will print
     * out her name
     *
     * @param list
     */
    public void countWomenNames(ObjectList list) {
        
        if (list == null) {
            System.out.println("Runtime Error: employee list is null");
            System.exit(1);
        }
        
        System.out.println("All women on payroll:" + "\n");
        pw.println("All women on payroll:" + "\r\n");
        
        ObjectListNode p = list.getFirstNode();
        
        while (p != null) {
            
            char gender = (((Employee) p.getInfo()).getGender()).charAt(0);
            
            if( gender == 'F') {
                String fN = ((Employee) p.getInfo()).getFirstName();
                System.out.println(fN);
                pw.println(fN);
            }
            
            p = p.getNext();
        }
        System.out.println("\n");
        pw.println("\r\n");
    }
    
    /**Loops through the list, gets all the employee's info, and prints it out
     *
     * @param list
     */
    public void outputAllEmployees(ObjectList list) {
        
        if (list == null) {
            System.out.println("Runtime Error: employee list is null");
            System.exit(1);
        }
        
        ObjectListNode p = list.getFirstNode();
        System.out.printf("First Name\tLast Name\tGender\tTenure\tRate\tSalary\t\n" + "\n");
        pw.printf("First Name\tLast Name\tGender\tTenure\tRate\tSalary\t\n" + "\r\n");
        
        while(p != null) {
            String firstN = ((Employee) p.getInfo()).getFirstName();
            String lastN = ((Employee) p.getInfo()).getLastName();
            char gender = (((Employee) p.getInfo()).getGender()).charAt(0);
            int tenure = Integer.parseInt(((Employee) p.getInfo()).getTenure());
            char rate = (((Employee) p.getInfo()).getRate()).charAt(0);
            double salary = Double.parseDouble(((Employee) p.getInfo()).getSalary());
            
            System.out.printf("%s\t\t%s\t\t%s\t%s\t%s\t%s\n",firstN,lastN,gender,tenure,rate,salary);
            
            pw.printf("%s\t\t%s\t\t%s\t%s\t%s\t%s\n",firstN,lastN,gender,tenure,rate,salary);
            
            p = p.getNext();
            
        }
        System.out.println("\n");
        pw.println("\r\n");
    }
    
    /**Loops through the list, gets the employee's first and last name, rate, 
     * tenure, and salary, if the tenure is greater than or equal to 5, and 
     * the rate is 'W', it calculates the salary per year, then if that salary per
     * year is greater than 35000, it will print the first and last name
     *
     * @param list
     */
    public void countWeeklyEmployees(ObjectList list) {
        
        if (list == null) {
            System.out.println("Runtime Error: employee list is null");
            System.exit(1);
        }
        
        ObjectListNode p = list.getFirstNode();
        System.out.println("Weekly employees who make more than 35,000 "
                + "and who have been with the company for atleast 5 years: " + "\n");
        pw.println("Weekly employees who make more than 35,000 "
                + "and who have been with the company for atleast 5 years: " + "\r\n");
        
        while(p != null) {
            String firstN = ((Employee) p.getInfo()).getFirstName();
            String lastN = ((Employee) p.getInfo()).getLastName();
            char rate = (((Employee) p.getInfo()).getRate()).charAt(0);
            int tenure = Integer.parseInt(((Employee) p.getInfo()).getTenure());
            double salary = Double.parseDouble(((Employee) p.getInfo()).getSalary());
            
            
            if((tenure >= 5) && (rate == 'W')) {
                double salaryPerY = salary * 52;
                
                if (salaryPerY > 35000) {
                    System.out.println(firstN + " " + lastN);
                    pw.println(firstN + " " + lastN);
                }
            }
            
            p = p.getNext();
            
        }
        
        System.out.println("\n");
        pw.println("\r\n");
    }
    
    /**Loops through the list, gets the employees first and last name, rate, and
     * salary. if the rate is 'H', .75 is added to the salary, and prints the
     * name and salary. if the rate is 'W', 350 is added to the salary,
     *  and prints the name and salary
     *
     * @param list
     */
    public void giveRaise(ObjectList list) {
        
        if (list == null) {
            System.out.println("Runtime Error: employee list is null");
            System.exit(1);
        }
        
        ObjectListNode p = list.getFirstNode();
        System.out.println("Raises: " + "\n");
        pw.println("Raises: " + "\r\n");
        
        
        while (p != null) {
            String firstN = ((Employee) p.getInfo()).getFirstName();
            String lastN = ((Employee) p.getInfo()).getLastName();
            char rate = (((Employee) p.getInfo()).getRate()).charAt(0);
            double salary = Double.parseDouble(((Employee) p.getInfo()).getSalary());
            
            if ((rate == 'H') && (salary < 10)) {
                salary = salary + .75;
                System.out.printf("%s\t%s\t%s\n",firstN,lastN,salary);
                pw.printf("%s\t%s\t%s\n",firstN,lastN,salary);
            }
            
            else if ((rate == 'W') && (salary < 350)) {
                salary = salary + 50;
                System.out.printf("%s\t%s\t%s\n",firstN,lastN,salary);
                pw.printf("%s\t%s\t%s\n",firstN,lastN,salary);
            }
            p = p.getNext();
        }
        System.out.println("\n");
        pw.println("\r\n");
    }
    
    /**Uses the insert method to insert the node pointed to by p,looping through
     * the list, into the correct position in a new ordered list, returns this
     * ordered list
     *
     * @param list
     * @return ObjectList
     */
    public ObjectList alphaOrderList(ObjectList list) {

        ObjectListNode p = list.getFirstNode();
        Employee e;
        
        
        while(p != null) {
            e = (Employee) p.getInfo();
            alphaList.insert(e);
            p = p.getNext();
        }
        return alphaList;
    }
    
    /**loops through the list, gets the first and last name, and salary, and 
     * prints them out
     *
     * @param list
     */
    public void printAllNamesAndSalaries(ObjectList list) {
        
        if (list == null) {
            System.out.println("Runtime Error: employee list is null");
            System.exit(1);
        }
        
        ObjectListNode p = list.getFirstNode();
        System.out.printf("Names and salaries in alphabetical order by last name: " + "\n");
        pw.println("Names and salaries in alphabetical order by last name: " + "\r\n");
        System.out.printf("\n");
        pw.println("\r\n");
        
        while(p != null) {
            String firstN = ((Employee) p.getInfo()).getFirstName();
            String lastN = ((Employee) p.getInfo()).getLastName();
            double salary = Double.parseDouble(((Employee) p.getInfo()).getSalary());
            
            System.out.println(lastN + " " + firstN + " " + salary);
            pw.println(lastN + " " + firstN + " " + salary);
            
            p = p.getNext();
            
        }
        System.out.println("\n");
        pw.println("\r\n");
    }
    
    /**loops through the lines of strings, makes an array of the strings, saves 
     * info to create employees to be inserted into the correct position in the 
     * ordered list
     *
     * @param list
     */
    public void addEmployeesToSortedList(ObjectList list) {
        
        while (s.hasNext()) {
            String tempS = s.nextLine();
            
            String[] tokens = tempS.split("[ ]+");
            
            String fN = tokens[0];
            String lN = tokens[1];
            String gend = tokens[2];
            String tenu = tokens[3];
            String rt = tokens[4];
            String slry = tokens[5];
            
            Employee tempE = new Employee(fN, lN, gend, tenu, rt, slry);
            
            ObjectListNode tempN = new ObjectListNode(tempE);
            
            list.insert(tempN);
        }
    }
    
    /**Loops through lines of strings, save the info to be used to create 
     * employees that will be searched for in the list, and removed
     *
     * @param list
     */
    public void deleteFiredEmployees(ObjectList list) {
        
        while (s.hasNext()) {
            String tempS = s.nextLine();
            
            String[] tokens = tempS.split("[ ]+");
            
            String fN = tokens[0];
            String lN = tokens[1];
            
            
            Employee tempE = new Employee(fN, lN);
            
            ObjectListNode tempN = new ObjectListNode(tempE);
            
            list.remove(tempE);
        }
    }
    
    
}

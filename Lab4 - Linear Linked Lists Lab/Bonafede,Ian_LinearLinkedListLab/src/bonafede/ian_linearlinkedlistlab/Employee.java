/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonafede.ian_linearlinkedlistlab;

/**
 *
 * @author Ian_2
 */
public class Employee implements Comparable {
    
    String firstName;
    String lastName;
    String gender;
    String tenure;
    String rate;
    String salary;
    
    /**Constructs an Employee object with the fields set to the passed 
     * arguments
     *
     * @param fN
     * @param lN
     * @param gend
     * @param tenu
     * @param rt
     * @param slry
     */
    public Employee(String fN, String lN, String gend, String tenu, String rt, String slry) {
        firstName = fN;
        lastName = lN;
        gender = gend;
        tenure = tenu;
        rate = rt;
        salary = slry;
    }
    
    /**Constructs an Employee object with only the name fields set to the passed 
     * arguments
     *
     * @param fN
     * @param lN
     */
    public Employee(String fN, String lN) {
        firstName = fN;
        lastName = lN;
        gender = "M";
        tenure = "0";
        rate = "0";
        salary = "0";
    }
    
    /**returns the first name
     *
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }
    
    /** returns the last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }
    
    /** returns the gender
     *
     * @return String
     */
    public String getGender() {
        return gender;
    }
    
    /** returns the tenure(years the employee has been employed)
     *
     * @return String
     */
    public String getTenure() {
        return tenure;
    }
    
    /** returns the rate at which the employee is paid
     *
     * @return String
     */
    public String getRate() {
        return rate;
    }
    
    /** returns the salary of the employee
     *
     * @return String
     */
    public String getSalary() {
        return salary;
    }
    
    /** Compares the last name of this employee to the last name of the employee
     * object passed, by using the method compareTo in the string class
     * 
     *
     * @param o
     * @return integer
     */
    public int compareTo(Object o) {
    Employee e = (Employee) o;
    return lastName.compareTo(e.getLastName());
    }
    
}

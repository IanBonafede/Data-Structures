/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.queue.lab;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Ian_2
 */
public class Driver {
    
    /**Runs the program designed to complete designated jobs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner scanner = new Scanner(new File("mfq.txt"));
        
        MFQ mfq = new MFQ(pw, scanner);
        
        
        mfq.getJobs();
        mfq.outputHeader();
        mfq.runSimulation();
        mfq.outStats();
        pw.close();
    }
    
}

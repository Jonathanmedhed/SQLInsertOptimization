package main;

import setup.SetUp;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * CCT College Dublin Data Structures and Algorithms
 *
 * @author Jonathan Medina 2016234
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Instance to get methods from the setup
         */
        SetUp setup = new SetUp();
        /**
         * Create list of Companies e want to insert
         */
        setup.createCompanyList(1000);
        /**
         * Select type of insertion
         */
        System.out.println("Inserting 1000 rows");
        setup.insertAllOnce();
        setup.insertElementOnebyOne();
        
        setup.createCompanyList(10000);
        System.out.println("Inserting 10000 rows");
        setup.insertAllOnce();
        //Dont event try it will take too long xD
        //setup.insertElementOnebyOne();
        
        setup.createCompanyList(15000);
        System.out.println("Inserting 15000 rows");
        setup.insertAllOnce();
        //Dont event try it will take too long xD
        //setup.insertElementOnebyOne();
    }

}

package setup;


/**
 * CCT College Dublin Data Structures and Algorithms
 * 
 * @author Jonathan Medina 2016234
 *
 */
import dataGeneration.GenerateData;
import utilities.Printers;
import database.OopDAO;
import database.MySQLOopDAO;
import entities.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * Frame for the application
 */
public class SetUp {
        
        /**
         * Connection to the database
         */
        OopDAO db = new MySQLOopDAO();
	/**
	 * Scanner to get input from User
	 */
	Scanner sc = new Scanner(System.in); // integers scanner
	/**
	 * Empty Company list to fill with randomly generated Companies
	 */
	List<Company> companyList = new ArrayList<Company>();
	/**
	 * Instance from Printers class to start print useful data to the user
	 */
	Printers printer = new Printers();

	/**
	 * 
	 * Create random list of companies
	 * 
	 * @param companyAmount
	 */
	public void createCompanyList(int companyAmount) {
		GenerateData gD = new GenerateData();
		gD.fillCompanyList(companyList, companyAmount);
	}
        
        /**
         * 
         * @param companyList 
         */
        public void insertElementOnebyOne(){
            // finding the time before the operation is executed
            long start = System.currentTimeMillis();
            for (Company x : companyList) {
                db.saveCompany(x);
            }
            // finding the time after the operation is executed
            long end = System.currentTimeMillis();
            //finding the time difference and converting it into seconds
            float sec = (end - start) / 1000F; 
            System.out.println("Time taken one by one: "+sec + " seconds");
            
        }
        
        public void insertAllOnce(){
            db.saveCompanies(companyList);
        }
        
	
}

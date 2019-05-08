package dataGeneration;


/**
 * CCT College Dublin Data Structures and Algorithms
 * @author Jonathan Medina 2016234
 *
 */

import database.OopDAO;
import database.MySQLOopDAO;
import entities.Company;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class GenerateData {

	

	/**
	 * Instance of the class containing all the data for the random generation
	 */
	public StoredData sD = new StoredData();

	/**
	 * Random generator
	 */
	Random rG = new Random();
	
	/**
	 * Connection to the database
	 */
	OopDAO db = new MySQLOopDAO();
        
	/**
	 * 
	 * Fills companyList with random Companies
	 * 
	 * @param companyList
	 * @param amt
	 *            amount of companies to generate
	 */
	public void fillCompanyList(List<Company> list, int amt) {

		for (int i = 0; i < amt; i++) {
			Company k = new Company();
			k.setName(sD.companyNames[rG.nextInt(sD.companyNames.length)]);
			k.setSharePrice(ThreadLocalRandom.current().nextInt(10, 100 + 1));
			list.add(k);
		}
	}

	

}

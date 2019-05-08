package utilities;

import entities.Company;
import java.util.List;

public class Printers {

    /**
     * Print Companies with only useful information
     *
     * @param list
     */
    public void printCompanies(List<Company> list) {
        int count = 0;
        for (Company x : list) {
            count++;
            System.out.println("Company [Name=" + x.getName() + ", Shares Sold=" + x.getSharesSold() + ", Share Number=" + x.getShareNumber()
                    + ", SharePrice=" + x.getSharePrice() + "]");
        }
        System.out.println("Total number of results: " + count);
    }

    

}

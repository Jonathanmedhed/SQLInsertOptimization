package database;

import entities.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOopDAO implements OopDAO {

    /**
     * Get all companies
     *
     * @return
     */
    public ArrayList<Company> getCompanies() {

        /**
         * List that will be filled with the companies
         */
        ArrayList<Company> companies = new ArrayList<Company>();

        /**
         * query for the database
         */
        String query = "select * from company";

        /**
         * access the database
         */
        DataSource db = new DataSource();

        /**
         * Query the database
         */
        ResultSet rs = db.select(query);

        /**
         * Loop through the result set
         */
        try {
            while (rs.next()) {
                /**
                 * Get the attributes from each row
                 */
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int shareNumber = rs.getInt(3);
                int sharesSold = rs.getInt(4);
                double sharePrice = rs.getDouble(5);
                Company comp = new Company();
                comp.setId(id);
                comp.setName(name);
                comp.setShareNumber(shareNumber);
                comp.setSharesSold(sharesSold);
                comp.setSharePrice(sharePrice);
                companies.add(comp);
            }

            /**
             * close the connection to the database
             */
            db.closing();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /**
         * Return the list of companies
         */
        return companies;
    }

    public Company findCompanyById(String id) {

        /**
         * Empty object of the company that will be found
         */
        Company comp = null;

        String query = "select * from company where id = " + id;

        DataSource db = new DataSource();

        ResultSet rs = db.select(query);

        try {
            String name = rs.getString(2);
            int shareNumber = rs.getInt(3);
            int sharesSold = rs.getInt(4);
            double sharePrice = rs.getDouble(5);
            comp.setId(Integer.parseInt(id));
            comp.setName(name);
            comp.setShareNumber(shareNumber);
            comp.setSharesSold(sharesSold);
            comp.setSharePrice(sharePrice);

            db.closing();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return comp;
    }

    /**
     * Save one company
     *
     * @param company
     * @return
     */
    public boolean saveCompany(Company company) {

        /**
         * access the database
         */
        DataSource db = new DataSource();

        /**
         * Get data from the object in the parameter
         */
        String name1 = company.getName();
        int shareNumber1 = company.getShareNumber();
        int sharesSold = company.getSharesSold();
        double sharePrice1 = company.getSharePrice();

        /**
         * Query to add object to database
         */
        String query = "insert into company (name, shareNumber, sharesSold, sharePrice) values ('" + name1
                + "', '" + shareNumber1 + "', '" + sharesSold + "', '" + sharePrice1 + "')";
        /**
         * add row to database
         */
        boolean result = db.save(query);

        db.closing();

        return result;
    }

    /**
     * Save a list of companies
     *
     * @param list
     * @return
     */
    public boolean saveCompanies(List<Company> list) {

        boolean result = false;

        /**
         * access the database
         */
        DataSource db = new DataSource();

        /**
         * Beginning of the query, that will be appended to all the objects
         */
        String query = "insert into company (name, shareNumber, sharesSold, sharePrice) values ";

        /**
         * Get attributes from each object
         */
        
        // finding the time before the operation is executed
        long start = System.currentTimeMillis();
        for (Company company : list) {
            String name1 = company.getName();
            int shareNumber1 = company.getShareNumber();
            int sharesSold = company.getSharesSold();
            double sharePrice1 = company.getSharePrice();

            /**
             * Create query string with the attributes
             */
            String add = "('" + name1 + "', '" + shareNumber1 + "', '" + sharesSold + "', '" + sharePrice1 + "'),";
            /**
             * Combine main query with this object query string
             */
            query = query + add;
        }
        
        /**
         * Remove ',' from the end of the query
         */
        query = query.substring(0, query.length() - 1);
        /**
         * Save all companies with one query
         */
        result = db.save(query);
        // finding the time after the operation is executed
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F; 
        System.out.println("Time taken insert All Once: "+sec + " seconds");

        /**
         * Close connection to database
         */
        db.closing();

        /**
         * Return if success
         */
        return result;

    }

}

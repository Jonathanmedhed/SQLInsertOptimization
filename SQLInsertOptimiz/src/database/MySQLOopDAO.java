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

        public boolean saveCompanies(List<Company> list2) {

        boolean result = false;

        /**
         * access the database
         */
        DataSource db = new DataSource();
        
        /**
         * Editable list
         */
        List<Company> list = new CopyOnWriteArrayList<Company>();
        list.addAll(list2);
        
        /**
         * Beginning of the query, that will be appended to all the objects
         */
        String query = "insert into company (name, shareNumber, sharesSold, sharePrice) values ";

        /**
         * Get attributes from each object
         */
        
        // finding the time before the operation is executed
        long start = System.currentTimeMillis();
        //row counter
        int queryCounter = 0;
        for (Company company : list) {
            queryCounter++;
            String name1 = company.getName();
            int shareNumber1 = company.getShareNumber();
            int sharesSold = company.getSharesSold();
            double sharePrice1 = company.getSharePrice();
            //remove company from list
            list.remove(company);
            /**
             * Create query string with the attributes
             */
            String add = "('" + name1 + "', '" + shareNumber1 + "', '" + sharesSold + "', '" + sharePrice1 + "'),";
            /**
             * Combine main query with this object query string
             */
            query = query + add;
            /**
             * if the row count for this query is 1k
             * insert it and run method with the new list
             */
            if (queryCounter == 1000 || list.isEmpty()) {
                query = query.substring(0, query.length() - 1);
                result = db.save(query);
                System.out.println(query);
                //If list size is under 5000 user a different method
                if (list.isEmpty()) {
                    return result;
                } else {
                    //repeat method with new list
                    saveCompanies(list);
                }
                break;
            }
        }
        
        return result;

    }

}

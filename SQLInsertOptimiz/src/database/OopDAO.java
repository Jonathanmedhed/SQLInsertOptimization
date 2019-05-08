package database;

import entities.Company;
import java.util.ArrayList;
import java.util.List;

public interface OopDAO {

	public ArrayList<Company> getCompanies();
	public Company findCompanyById(String id);
	public boolean saveCompany(Company company);
        public boolean saveCompanies(List<Company> list);
        
	
}

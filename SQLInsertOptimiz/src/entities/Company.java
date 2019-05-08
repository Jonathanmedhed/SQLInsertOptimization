package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * CCT College Dublin Data Structures and Algorithms
 * 
 * @author Jonathan Medina 2016234
 * 
 *
 */

public class Company {

	/** Company info */
	private int id;
	private String name;
	private int shareNumber;
	private int sharesSold;
	private double sharePrice;

	/**
	 * Company Constructor
	 * 
	 */
	public Company(int id, String name, int shareNumber, int sharesSold, double sharePrice) {
		this.id = id;
		this.name = name;
		this.shareNumber = shareNumber;
		this.sharesSold = sharesSold;
		this.sharePrice = sharePrice;
	}

	public Company() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getShareNumber() {
		return shareNumber;
	}
	
	public void setShareNumber(int shareNumber) {
		this.shareNumber = shareNumber;
	}
	
	public int getSharesSold() {
		return sharesSold;
	}
	
	public void setSharesSold(int sharesSold) {
		this.sharesSold = sharesSold;
	}
	
	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public double getCompanyValue() {
		return sharesSold*sharePrice;
	}
	
	
		

	@Override
	public String toString() {
		return "Company [id=" + id + ", Name=" + name + ", ShareNumber=" + shareNumber + ", SharePrice=" + sharePrice
				+ ", " + /* "SharesSold=" + sharesSold + */ "]";
	}

}

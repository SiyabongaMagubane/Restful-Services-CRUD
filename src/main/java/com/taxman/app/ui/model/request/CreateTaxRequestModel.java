package com.taxman.app.ui.model.request;

public class CreateTaxRequestModel {
	private int Salary;
	private int TaxBracket;
	
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return Salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		Salary = salary;
	}
	/**
	 * @return the taxBracket
	 */
	public int getTaxBracket() {
		return TaxBracket;
	}
	/**
	 * @param taxBracket the taxBracket to set
	 */
	public void setTaxBracket(int taxBracket) {
		TaxBracket = taxBracket;
	}
	
}

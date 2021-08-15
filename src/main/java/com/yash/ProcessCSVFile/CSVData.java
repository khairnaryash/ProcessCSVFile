package com.yash.ProcessCSVFile;

import com.opencsv.bean.CsvBindByName;

public class CSVData {

	public int getPrimary() {
		return primary;
	}

	public void setPrimary(int primary) {
		this.primary = primary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public int getCalculate_in_minutes() {
		return calculate_in_minutes;
	}

	public void setCalculate_in_minutes(int calculate_in_minutes) {
		this.calculate_in_minutes = calculate_in_minutes;
	}

	@CsvBindByName(column = "primary")
	private int primary;

	@CsvBindByName(column = "name")
	private String name;

	@CsvBindByName(column = "dOJ")
	private String dateOfJoining;

	@CsvBindByName(column = "amount")
	private float amount;

	@CsvBindByName(column = "month")
	private int month;

	@CsvBindByName(column = "day")
	private int day;

	@CsvBindByName(column = "min")
	private int min;

	@CsvBindByName(column = "sec")
	private int sec;

	@CsvBindByName(column = "calculate_in_minutes")
	private int calculate_in_minutes;

}

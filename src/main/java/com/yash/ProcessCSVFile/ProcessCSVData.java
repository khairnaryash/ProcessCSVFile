package com.yash.ProcessCSVFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;


public class ProcessCSVData {
	public static void main(String[] args) throws Exception {
		System.out.println("Processing CSV file.....");

		String fileName = "test.csv";

		List<CSVData> beans = new CsvToBeanBuilder<CSVData>(new FileReader(fileName)).withType(CSVData.class).build()
				.parse();

		for (CSVData data : beans) {

			int timeInMinute = 0;

			if (data.getMonth() > 0)
				timeInMinute = timeInMinute + data.getMonth() * 30 * 24 * 60;

			if (data.getDay() > 0)
				timeInMinute = timeInMinute + data.getDay() * 24 * 60;

			if (data.getMin() > 0)
				timeInMinute = timeInMinute + data.getMin();

			if (data.getSec() > 0)
				timeInMinute = timeInMinute + data.getSec() / 60;

			data.setCalculate_in_minutes(timeInMinute);

		}
		processDojInput(beans);
		try (CSVWriter writer = new CSVWriter(new FileWriter("Output.csv"))) {
			writer.writeAll(createCsvData(beans));
		}
		
		System.out.println("Processing completed");

	}

	private static List<CSVData>  processDojInput(List<CSVData> beans) throws Exception {

		File file = new File("DojInput.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		int i=0;
		while ((st = br.readLine()) != null)
		{
			if(st!= null && !st.isEmpty())
				beans.get(i++).setDateOfJoining(st);
		}
		
		return beans;
	}

	private static List<String[]> createCsvData(List<CSVData> beans) {

		String[] header = { "primary", "name", "dOJ", "amount", "month", "day", "min", "sec", "calculate in minutes" };

		List<String[]> list = new ArrayList<>();
		list.add(header);

		for (CSVData data : beans) {
			String[] arr = new String[header.length];
			arr[0] = String.valueOf(data.getPrimary());
			arr[1] = data.getName();
			arr[2] = data.getDateOfJoining();
			arr[3] = String.valueOf(data.getAmount());
			arr[4] = String.valueOf(data.getMonth());
			arr[5] = String.valueOf(data.getDay());
			arr[6] = String.valueOf(data.getMin());
			arr[7] = String.valueOf(data.getSec());
			arr[8] = String.valueOf(data.getCalculate_in_minutes());
			list.add(arr);
		}
		return list;

	}
}

package utils;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ImportaCSV {

	public void run() {

		String csvFile = "C:\\ServiceDesk.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		MySQL m = new MySQL();
		m.connect("servicedesk", "root", "root");
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				String[] servico  = line.split(cvsSplitBy);
				m.insert(servico[0], servico[1], servico[2], servico[3]);

			}
			m.fechaConnection();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

}


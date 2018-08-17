package com.ait.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class HistoryDao extends Dao {

	public void addEquation(String equation, String answer) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			//String update = "INSERT INTO history (equation, result, date_calculated) VALUES (?, ?, now());"; //mySQL
			String update = "INSERT INTO history (equation, result, date_calculated) VALUES (?, ?, getDate());"; //msSQL
			ps = con.prepareStatement(update);
			ps.setString(1, equation);
			ps.setString(2, answer);
			ps.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println("Exception occured in the addEquation() method: "
					+ e.getMessage());
		}

		
	}
	
	public ArrayList<HistoricalEquation> getEquations() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HistoricalEquation> history = new ArrayList<HistoricalEquation>();
		try {
			
			con = getConnection();
			String query = "SELECT * FROM history;";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				HistoricalEquation he = new HistoricalEquation();
				he.setId(rs.getInt("id"));
				he.setEquation(rs.getString("equation"));
				he.setResult(rs.getString("result"));
				he.setDate(rs.getTimestamp("date_calculated"));
				
				history.add(he);
			}
			
		} catch (SQLException e) {

			System.out.println("Exception occured in the addEquation() method: "
					+ e.getMessage());
		}
		return history;
		

		
	}
}

package com.ait.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FormulaDao extends Dao{
	
	public ArrayList<Formula> getFormula() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Formula> formulaList = new ArrayList<Formula>();
		try {
			
			con = getConnection();
			String query = "SELECT * FROM formula;";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String equation = rs.getString("equation");
				String variables = rs.getString("variables");
				String variableNames = rs.getString("variable_names");
				
				formulaList.add(new Formula(id, name, equation, variables, variableNames));
			}
			
		} catch (SQLException e) {

			System.out.println("Exception occured in the getFormula() method: "
					+ e.getMessage());
		}
		return formulaList;
		

		
	}
}

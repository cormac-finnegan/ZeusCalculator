package com.ait.Database;

public class Formula {

	private int id;
	private String name;
	private String equation;
	private String[] variables;
	private String[] variableNames;
	
	public Formula(int id, String name, String equation, String variables,
			String variableNames) {
		super();
		this.id = id;
		this.name = name;
		this.equation = equation;
		this.variables = variables.split(",");
		this.variableNames = variableNames.split(",");
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

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public String[] getVariables() {
		return variables;
	}

	public void setVariables(String[] variables) {
		this.variables = variables;
	}

	public String[] getVariableNames() {
		return variableNames;
	}

	public void setVariableNames(String[] variableNames) {
		this.variableNames = variableNames;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

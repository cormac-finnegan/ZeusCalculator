CREATE TABLE history (
  [id] INT NOT NULL identity,
  [equation] VARCHAR(500),
  [result] VARCHAR(500),
  [date_calculated] DATETIME2(0),
  PRIMARY KEY ([id]),
  CONSTRAINT [id_UNIQUE] UNIQUE  ([id] ASC))
;

CREATE TABLE formula (
  [id] INT NOT NULL identity,
  [name] VARCHAR(45),
  [equation] VARCHAR(45),
  [variables] VARCHAR(200),
  [variable_names] VARCHAR(200),
  PRIMARY KEY ([id]))
;

INSERT INTO history (equation, result, date_calculated) VALUES ("4+4", "8", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("10*6", "60", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("25+5", "30", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("9*8+5", "77", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("10*(5+2)", "7", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("4+4", "8", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("10*6", "60", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("25+5", "30", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("9*8+5", "77", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("10*(5+2)", "7", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("4+4", "8", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("10*6", "60", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("25+5", "30", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("9*8+5", "77", getdate());
INSERT INTO history (equation, result, date_calculated) VALUES ("10*(5+2)", "7", getdate());

INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Area of a Square", "side^2", "side", "Side Length");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Area of a Rectangle", "length*width", "length,width", "Length,Width");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Area of a Parrallelogram", "base*height", "base,height", "Base,Height");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Area of a Triangle", "base*height/2", "base,height", "Base,Height");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Area of Circle", "pi*(radius^2)", "radius", "Radius");

INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Perimeter of a Square", "4*side", "side", "Side");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Perimeter of a Rectangle", "(2*length)+(2*width)", "length,width", "Length,Width");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Perimeter of a Triangle", "side1+side2+side3", "side1,side2,side3", "Side 1,Side 2,Side 3");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Circumference of a Circle", "pi*diameter", "diameter", "Diameter");

INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Volume of a Sphere", "(4/3)*pi*(radius^3)", "radius", "Radius");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Volume of a Cylinder", "pi*(radius^2)*height", "radius,height", "Radius,Height");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Volume of a Cone", "0.33*pi*radius^2*height", "radius,height", "Radius,Height");

INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Fahrenheit to Celsius", "(tempF-32)/1.8", "tempF", "Temperature(F)");
INSERT INTO formula (name, equation, variables, variable_names) VALUES ("Celsius to Fahrenheit", "(tempC*1.8)+32", "tempC", "Temperature(C)");


SELECT * from history;
SELECT * from formula;
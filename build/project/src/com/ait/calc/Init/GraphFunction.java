package com.ait.calc.Init;
import com.ait.calc.Controller.GraphController;
import com.ait.calc.Model.PlotPoint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class GraphFunction extends Application{


	@Override 
	public void start(Stage stage){
		//XYCHART
		GraphController.Plotting();
		stage.setTitle("Graph Test");
		final NumberAxis xAxis=new NumberAxis();
		final NumberAxis yAxis= new NumberAxis();




		final LineChart<Number,Number> lineChart=
				new LineChart<Number,Number>(xAxis,yAxis);

		lineChart.setTitle("Graph Test");
		XYChart.Series series=new XYChart.Series<>();
		series.setName("Plotting function: f(x):"+GraphController.getFunction());



		for(PlotPoint p:GraphController.plotPoints){
			series.getData().add(new XYChart.Data(p.getX(),p.getY()));
		}



		Scene scene= new Scene(lineChart,800,600);
		lineChart.getData().add(series);
		lineChart.setStyle("-fx-background-color: rgb(25,29,50);");
		stage.setScene(scene);
		stage.show();

	}
	public static void main (String[] args){
		launch(args);
	}

}
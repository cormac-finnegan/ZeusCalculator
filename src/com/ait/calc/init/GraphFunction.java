package com.ait.calc.init;
import com.ait.calc.controller.GraphController;
import com.ait.calc.model.PlotPoint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Stage;
public class GraphFunction extends Application{


	@Override 
	public void start(Stage stage){
		//XYCHART
	//	GraphController.Plotting();
		stage.setTitle(GraphController.getFunction());
		final NumberAxis xAxis=new NumberAxis();
		final NumberAxis yAxis= new NumberAxis();




		final LineChart<Number,Number> lineChart=
				new LineChart<Number,Number>(xAxis,yAxis);

		lineChart.setTitle(GraphController.getFunction());
		
		//Line to remove points/ dots from the graph
		lineChart.setCreateSymbols(false);
		lineChart.setLegendVisible(false);
		XYChart.Series series=new XYChart.Series<>();
	//	series.setName("Plotting function: f(x):"+GraphController.getFunction());



		for(PlotPoint p:GraphController.plotPoints){
			
			if(p.getX()==0.12343256724356724&&p.getY()==0.12343256724356724){
				lineChart.getData().add(series);
				series=new XYChart.Series<>();
				continue;
			}
		
			else{
				series.getData().add(new XYChart.Data(p.getX(),p.getY()));
			}
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
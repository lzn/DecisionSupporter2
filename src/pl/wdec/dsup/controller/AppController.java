package pl.wdec.dsup.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import pl.wdec.dsup.data.Decisions;
import pl.wdec.dsup.data.Simulation;
import pl.wdec.dsup.exceptions.ModelAlreadyInitExc;
import pl.wdec.dsup.model.Model;
import pl.wdec.dsup.views.ViewsBuilder;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AppController implements Controller, Initializable {

	private static final String MAIN_VIEW_TITLE = "Game Properites";

	private static final String PROPS_VIEW_RESOURCE = "../views/GameProperties.fxml";

	private static final double SLIDER_MIN_PRICE = 0;

	private static final double SLIDER_MAX_PRICE = 50;

	public Stage stage;

	@FXML
	private Parent view;
	@FXML
	private LineChart<Number, Number> chart;
	@FXML
	private Slider quantitySlider;
	@FXML
	private Label quantityValue;
	@FXML
	private Slider qualitySlider;
	@FXML
	private Label qualityValue;
	@FXML
	private Slider priceSlider;
	@FXML
	private Label priceValue;
	@FXML
	private Label riskValue;
	@FXML
	private Label cashValue;

	@FXML
	private TextField cash;
	@FXML
	private TextField credit;
	@FXML
	private TextField credit_payments;

	public Model model = new Model();

	@FXML
	protected void gameProp(ActionEvent event) {
		Stage gamePref = new Stage();
		gamePref.initModality(Modality.WINDOW_MODAL);
		gamePref.initOwner(((Button) event.getSource()).getScene().getWindow());

		Controller con = null;
		try {
			con = ViewsBuilder.initStage(gamePref, PROPS_VIEW_RESOURCE,
					MAIN_VIEW_TITLE, this);
			con.setStage(gamePref);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con.initModel(model);
		} catch (ModelAlreadyInitExc e) {
			// Do nothing
		}

		gamePref.show();
	}

	@Override
	public void setStage(Stage s) {
		stage = s;
	}

	@FXML
	protected void close(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	protected void calculate(ActionEvent event) {
		chart.getData().clear();
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		chart.getData().add(series);
		
		Simulation sim = new Simulation(new BigDecimal(cash.getText()), new BigDecimal(credit.getText()), new BigDecimal(credit_payments.getText()));
		model.setSimulation(sim);
		ArrayList<Decisions> dec = model.calculateDecisions();
		for (Decisions decision : dec) {
			XYChart.Data<Number, Number> point = new XYChart.Data<Number, Number>(
					decision.point.cash, decision.point.risk);
			PointChangeListener listener = new PointChangeListener(decision,
					qualitySlider, quantitySlider, priceSlider, cashValue,
					riskValue) {
				@Override
				public void changed(ObservableValue<? extends Node> observable,
						Node oldValue, Node newValue) {
					newValue.addEventHandler(MouseEvent.MOUSE_CLICKED,
							new PointEventHandler());
				}
			};
			
			point.nodeProperty().addListener(listener);
			series.getData().add(point);
		}
	}

	@Override
	public void initModel(Model model) throws ModelAlreadyInitExc {
		if (this.model != null) {
			throw new ModelAlreadyInitExc();
		} else {
			this.model = model;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*
		 * Ustawienie "domyślnych" wartości
		 */
		qualityValue.setText(String.format("%4.0f", 0.00) + " %"); // TODO:
		quantityValue.setText(String.format("%6.0f sztuk", 0.00));
		priceValue.setText(String.format("%3.2f zł", 0.0));

		cash.setText(model.getSimulation().cash.toString());
		credit.setText(model.getSimulation().credit.toString());
		credit_payments.setText(model.getSimulation().credit_payments
				.toString());
		/*
		 * Ustawienie rozdzielczości suwaków na podstawie ustawień gry
		 */
		quantitySlider.setMax(model.getGameProperties().getMaxProdCapacity());
		quantitySlider.setMajorTickUnit(model.getGameProperties()
				.getMaxProdCapacity() / 2);
		quantitySlider.setBlockIncrement(model.getGameProperties()
				.getMaxProdCapacity() / 100);

		qualitySlider.setMin(model.getGameProperties().getMinQuality());
		qualitySlider.setMax(model.getGameProperties().getMaxQuality());
		// qualitySlider.setBlockIncrement(10D);
		qualitySlider.setMajorTickUnit((model.getGameProperties()
				.getMaxQuality()) / 2);

		priceSlider.setMin(SLIDER_MIN_PRICE);
		priceSlider.setMax(SLIDER_MAX_PRICE);
		/*
		 * Połącznenie suwaków z etykietami
		 */
		qualitySlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				qualityValue.setText(String.format("%4.0f", newValue) + " %"); // TODO
			}
		});
		quantitySlider.valueProperty().addListener(
				new ChangeListener<Number>() {
					@Override
					public void changed(
							ObservableValue<? extends Number> observable,
							Number oldValue, Number newValue) {
						quantityValue.setText(String.format("%4.0f sztuk",
								newValue));
					}
				});
		priceSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				priceValue.setText(String.format("%4.0f zł", newValue));
			}
		});
	}

	/*
	 * Inner classes
	 */

	public abstract class PointChangeListener implements ChangeListener<Node> {
		protected Decisions dec;

		public PointChangeListener(Decisions dec, Slider qualitySlider,
				Slider quantitySlider, Slider priceSlider, Label cashValue,
				Label riskValue) {
			this.dec = dec;
		}

		public class PointEventHandler implements EventHandler<MouseEvent> {
			@Override
			public void handle(MouseEvent arg0) {
				qualitySlider.setValue(dec.quality);
				quantitySlider.setValue(dec.quantity);
				priceSlider.setValue(dec.price);
				cashValue.setText(String.format("%.2f zł", dec.point.cash));
				riskValue.setText(String.format("%.2f", dec.point.risk) + "%"); // TODO
			}
		}
	}
}

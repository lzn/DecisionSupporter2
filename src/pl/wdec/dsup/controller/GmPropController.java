package pl.wdec.dsup.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import pl.wdec.dsup.data.GameProperties;
import pl.wdec.dsup.exceptions.ModelAlreadyInitExc;
import pl.wdec.dsup.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GmPropController implements Initializable, Controller {

	@FXML
	private Parent view;

	@FXML
	private TextField fixedAssets;
	@FXML
	private TextField maxCredit;
	@FXML
	private TextField cash;
	@FXML
	private TextField debt;
	@FXML
	private TextField depreciation;
	@FXML
	private TextField fixedCosts;
	@FXML
	private TextField acntInterestRate;
	@FXML
	private TextField creditInterestRate;
	@FXML
	private TextField taxRate;
	@FXML
	private TextField resalesRate;
	@FXML
	private TextField maxProdCapacity;
	@FXML
	private TextField minQuality;
	@FXML
	private TextField maxQuality;

	private Model model;

	@FXML
	protected void close(ActionEvent event) {
		view.getScene().getWindow().hide();
	}

	@FXML
	protected void save(ActionEvent event) {
		GameProperties gm = new GameProperties(new BigDecimal(
				fixedAssets.getText()), new BigDecimal(maxCredit.getText()),
				new BigDecimal(cash.getText()), new BigDecimal(debt.getText()),
				new BigDecimal(depreciation.getText()), new BigDecimal(
						fixedCosts.getText()), new Double(
						acntInterestRate.getText()) / 100, new Double(
						creditInterestRate.getText()) / 100, new Double(
						taxRate.getText()) / 100, new Double(
						resalesRate.getText()) / 100, new Integer(
						maxProdCapacity.getText()), new Integer(
						minQuality.getText()),
				new Integer(maxQuality.getText()));

		model.setGameProperties(gm);

		view.getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (model != null) {
			initFields();
		}
	}

	public void setStage(Stage gamePref) {

	}

	public Model getModel() {
		return model;
	}

	@Override
	public void initModel(Model model) throws ModelAlreadyInitExc {
		if (this.model != null) {
			throw new ModelAlreadyInitExc();
		} else {
			this.model = model;
		}
		initFields();
	}

	private void initFields() {
		fixedAssets.setText(model.getGameProperties().getFixedAssets()
				.toString());
		maxCredit.setText(model.getGameProperties().getMaxCredit().toString());
		cash.setText(model.getGameProperties().getCash().toString());
		debt.setText(model.getGameProperties().getDebt().toString());
		depreciation.setText(model.getGameProperties().getDepreciation()
				.toString());
		fixedCosts
				.setText(model.getGameProperties().getFixedCosts().toString());
		acntInterestRate.setText(model.getGameProperties()
				.getAcntInterestRateProc().toString());
		creditInterestRate.setText(model.getGameProperties()
				.getCreditIntegererestRateProc().toString());
		taxRate.setText(model.getGameProperties().getTaxRateProc().toString());
		resalesRate.setText(model.getGameProperties().getResalesRateProc()
				.toString());
		maxProdCapacity.setText(model.getGameProperties().getMaxProdCapacity()
				.toString());
		minQuality
				.setText(model.getGameProperties().getMinQuality().toString());
		maxQuality
				.setText(model.getGameProperties().getMaxQuality().toString());

	}

}

package pl.wdec.dsup.controller;

import pl.wdec.dsup.exceptions.ModelAlreadyInitExc;
import pl.wdec.dsup.model.Model;
import javafx.stage.Stage;

public interface Controller {

	public void setStage(Stage s);

	public void initModel(Model model) throws ModelAlreadyInitExc;
}

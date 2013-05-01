package pl.wdec.dsup;


import pl.wdec.dsup.controller.Controller;
import pl.wdec.dsup.views.ViewsBuilder;
import javafx.application.Application;
import javafx.stage.Stage;

public class DecisionSupporter extends Application {

	private static final String APP_TITLE = "Decision Supporter";
	private static final String MAIN_VIEW_RESOURCE = "views/DecisionSupporter.fxml";
	private Controller appController;

	@Override
	public void start(Stage s) throws Exception {

		appController = ViewsBuilder.initStage(s, MAIN_VIEW_RESOURCE, APP_TITLE,this);
		appController.setStage(s);
		s.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

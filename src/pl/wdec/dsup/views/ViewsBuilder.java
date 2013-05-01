package pl.wdec.dsup.views;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.wdec.dsup.controller.Controller;

public final class ViewsBuilder {
	public static final Controller initStage(Stage s, String resources, String title, Object parent) throws Exception {
		s.setTitle(title);
		Pane mainPane = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		
		//fxmlLoader.setController(con);
		fxmlLoader.setLocation(parent.getClass().getResource(resources));
		fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
		mainPane = (Pane) fxmlLoader.load();
		Scene mainScene = new Scene(mainPane);
		s.setScene(mainScene);
		return fxmlLoader.getController();
	}
}

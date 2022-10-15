package questions;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class que3 extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		FlowPane root=new FlowPane();
		Scene scene=new Scene(root,200,200);
		stage.setScene(scene);
		root.setAlignment(Pos.CENTER);
		
		Menu newMenu=new Menu("New");
		MenuItem file=new MenuItem("File");
		MenuItem folder=new MenuItem("Folder");
		MenuItem img=new MenuItem("Image");
		newMenu.getItems().addAll(file,folder,img);
		
		Menu viewMenu=new Menu("View");
		MenuItem large=new MenuItem("large");
		MenuItem medium=new MenuItem("medium");
		MenuItem small=new MenuItem("small");
		viewMenu.getItems().addAll(large,medium,small);
	
		final ContextMenu context = new ContextMenu();
		
		TextField tf=new TextField();
		tf.setLayoutX(20);
		
		context.getItems().add(newMenu);
		context.getItems().add(viewMenu);
		tf.setContextMenu(context);
		Text label=new Text();
		EventHandler<ActionEvent> actionobj = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				label.setText(name + " selected");
			}
		};
		
		file.setOnAction(actionobj);
		folder.setOnAction(actionobj);
		img.setOnAction(actionobj);
		large.setOnAction(actionobj);
		medium.setOnAction(actionobj);
		small.setOnAction(actionobj);
		
		root.getChildren().addAll(label,tf);
		stage.show();
		
		
	}
}

package questions;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class que2 extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root=new BorderPane();
		Scene scene=new Scene(root,400,400);
		stage.setScene(scene);
		
		
		Text response=new Text();
		MenuBar menubar=new MenuBar();
		
		Menu fileMenu=new Menu("File");
		
		MenuItem New=new MenuItem("new");
		MenuItem open=new MenuItem("open");
		MenuItem save=new MenuItem("save");
		fileMenu.getItems().addAll(New,open,save);
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		New.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		
		menubar.getMenus().add(fileMenu);
		
		Menu editMenu=new Menu("Edit");
		MenuItem cut=new MenuItem("Cut");
		MenuItem copy=new MenuItem("Copy");
		MenuItem paste=new MenuItem("Paste");
		editMenu.getItems().addAll(cut,copy,paste);
		cut.setAccelerator(KeyCombination.keyCombination("shortcut+x"));
		copy.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		paste.setAccelerator(KeyCombination.keyCombination("shortcut+V"));
		
		menubar.getMenus().add(editMenu);
		
		Menu helpMenu=new Menu("Help");
		MenuItem help=new MenuItem("Help Centre");
		MenuItem about=new MenuItem("About Us");
		helpMenu.getItems().addAll(help,about);
		
		menubar.getMenus().add(helpMenu);
	
		
		EventHandler<ActionEvent> actionobj = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				response.setText(name + " selected");
			}
		};
		
		New.setOnAction(actionobj);
		open.setOnAction(actionobj);
		save.setOnAction(actionobj);
		cut.setOnAction(actionobj);
		copy.setOnAction(actionobj);
		paste.setOnAction(actionobj);
		help.setOnAction(actionobj);
		about.setOnAction(actionobj);
		
		root.setTop(menubar);
		root.setCenter(response);
		stage.show();
		
	}
}



package questions;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class que4 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Ragistration Form");
		FlowPane fp=new FlowPane();
		fp.setAlignment(Pos.TOP_CENTER);
		GridPane root=new GridPane();
		Scene scene=new Scene(fp,400,300);
		stage.setScene(scene);
		
		root.setPadding(new Insets(10,10,10,30));
		root.setVgap(15);
		root.setHgap(20);
		
		Label title=new Label("Employee Registration Form");
		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		
//		Label response=new Label();
//		GridPane.setConstraints(response, 1, 6);
		
		Text namelabel=new Text("Enter Your Name");
		GridPane.setConstraints(namelabel, 0, 1);
		
		TextField nameText=new TextField();
		nameText.setPromptText("Enter Your Name");
		nameText.setPrefColumnCount(15);
		GridPane.setConstraints(nameText, 1, 1);
		
		Text genderlabel=new Text("Enter Your Gender");
		GridPane.setConstraints(genderlabel, 0, 2);
		
		RadioButton male=new RadioButton("Male");
		RadioButton female=new RadioButton("Female");
		
		ToggleGroup tg=new ToggleGroup();
		male.setToggleGroup(tg);
		female.setToggleGroup(tg);
		HBox box = new HBox(10, male,female);
		female.fire();
		root.add(box,1,2);
		
		Text datelabel=new Text("Enter Date of Birth");
		GridPane.setConstraints(datelabel, 0, 3);
		
		Label l = new Label("no date selected"); 
		DatePicker date = new DatePicker();
		date.setPromptText("select Date");
		GridPane.setConstraints(date, 1, 3);
		
		Text statelabel=new Text("Select Your State");
		GridPane.setConstraints(statelabel, 0, 4);
		
		ComboBox<String> statecombox;
		ObservableList<String> states= FXCollections.observableArrayList("Karnataka", "Goa", "TamilNadu","Maharashtra");
		statecombox=new ComboBox<String>(states);
		statecombox.setValue("Karnataka");
		statecombox.setEditable(true);
		root.add(statecombox, 1, 4);
		
		Text qualilabel=new Text("Select Your State");
		GridPane.setConstraints(qualilabel, 0, 5);
		
		CheckBox UGcheckbox=new CheckBox("UG");
		CheckBox PGcheckbox=new CheckBox("PG");
		CheckBox PhDcheckbox=new CheckBox("PhD");
		HBox checkHBox = new HBox(10,UGcheckbox,PGcheckbox,PhDcheckbox);
		root.add(checkHBox, 1, 5);
		UGcheckbox.fire();
		PGcheckbox.fire();
		PhDcheckbox.fire();
		
		Button register=new Button("Register");
		GridPane.setConstraints(register, 1, 6);
		
		register.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				
//				if(nameText.getText().equals("") ) {
//					response.setText("name and date cannot be empty");
//				}
//				else {
					Alert dialog=new Alert(Alert.AlertType.INFORMATION);
					dialog.setResizable(false);
					dialog.setX(963);
					dialog.setY(310);
					dialog.setTitle("Registration Successful");
					dialog.setHeaderText("Registration Status");
					dialog.setContentText("Employee Ragistration is Successful");
					dialog.show();
//				}
			}
		});
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {  
                LocalDate i = date.getValue(); 
                l.setText("Date :" + i); 
            } 
        };
		date.setOnAction(event);
		root.getChildren().addAll(namelabel,nameText,genderlabel,datelabel,date,statelabel,qualilabel,register);
		fp.getChildren().addAll(title,root);
		
		stage.show();
			
	}
}

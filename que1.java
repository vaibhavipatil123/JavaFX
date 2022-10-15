package questions;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class que1 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		TextField tf;
		Label response= new Label("status:");
		FlowPane root=new FlowPane(20,20);
		Scene scene=new Scene(root,230,240,Color.RED);
		stage.setTitle("Login Page");

		root.setAlignment(Pos.CENTER);

		Text text1=new Text("Name  ");
		text1.setFill(Color.BLACK);

		Text text2=new Text("Password");
		text2.setFill(Color.BLACK);

		tf = new TextField();
		tf.setPromptText("Enter Name");

		PasswordField password=new PasswordField();

		Button bt=new Button("login");

		bt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(tf.getText().equals("vaibhavi") & password.getText().equals("vp123")) {
					response.setText("successful");
				}
				else {
					response.setText("wrong username or password");
				}
				
				if(tf.getText().isEmpty() && password.getText().isEmpty()) {
					response.setText("Enter username and password");
				}

			}
		});

		Separator separator = new Separator();
		separator.setPrefWidth(180);

		root.getChildren().addAll(text1,tf,text2,password,bt,separator,response);
		stage.setScene(scene);
		stage.show();
	}


}




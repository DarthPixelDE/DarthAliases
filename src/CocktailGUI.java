import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.Observable;


public class CocktailGUI extends Application {

	
	private Stage primaryStage;

	public static void main(String[] args) {
		
		launch(args);

	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		BorderPane bp = new BorderPane();
		
		Button BTnew = new Button("neu");
		Button BTsave = new Button("speichern");
		Button BTdel = new Button("löschen");
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(15, 12, 15, 12));
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER);		
		hb.getChildren().addAll(BTnew, BTsave, BTdel);
		
		
		bp.setBottom(hb);        
        
		
		LinkedList<String> l = new LinkedList<String>();
		l.add("test");
		
		Cocktail testC = new Cocktail("test","test123", l);
		
		
		ListView<String> liste = new ListView<String>();
		liste.prefHeight(50);
		ObservableList<String> items = FXCollections.observableArrayList();
		
		for(int i = 0 ; i < 20; i++){
			items.add("Test");
		}
		
		liste.setItems(items);
		
		Label label = new Label("Name:");		
		TextField tf = new TextField();
		tf.setMinWidth(248);
		
		label.setLabelFor(tf);
		label.setTextFill(Color.WHITE);
		
		HBox hb2 = new HBox();
		
		hb2.setSpacing(13.5);
		hb2.setAlignment(Pos.CENTER);		
		hb2.getChildren().addAll(label,tf);
		
		
		Label label2 = new Label("Zutaten:");
		label2.setTextFill(Color.WHITE);
		ListView<String> lv = new ListView<String>();
		
		label2.setLabelFor(lv);
		
		lv.setPrefHeight(300);
		
		HBox hb3 = new HBox();
		
		hb3.setSpacing(5);
		hb3.setAlignment(Pos.CENTER);		
		hb3.getChildren().addAll(label2,lv);
		
		Label label3 = new Label("Schritte:");
		label3.setTextFill(Color.WHITE);
		TextField tf2 = new TextField();
		label3.setLabelFor(tf2);
		
		
		
		tf2.setMinWidth(248);
		
		
		HBox hb4 = new HBox();
		
		hb4.setSpacing(6);
		hb4.setAlignment(Pos.CENTER);		
		hb4.getChildren().addAll(label3,tf2);
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(15, 12, 15, 12));
		vb.setSpacing(2);
		vb.setAlignment(Pos.CENTER);
		
		
		
		
		
		vb.getChildren().addAll(liste,hb2,hb3,hb4);
		
		bp.setCenter(vb);

		
		bp.setStyle("-fx-background-color: #000000");
		
        Scene scene = new Scene(bp, 500, 400);

        
       
        primaryStage.setTitle("Cocktail-Rezepte");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}

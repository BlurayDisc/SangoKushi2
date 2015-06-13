package com.run.sango.view.scene;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;
import com.run.sango.controller.data.GameData;
import com.run.sango.model.Hero;

public class HeroTable extends Scene {
	
	private int index = 0;
	
	@SuppressWarnings("unchecked")
	public HeroTable(List<Hero> herolist) {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		getStylesheets().add("com/run/sango/view/menuStyle.css");
		
		VBox layout = (VBox) getRoot();
		layout.setAlignment(Pos.CENTER);
		
        Text title = new Text("Hero Table");
        title.setFont(new Font("SansSerif", 22));
		
    	TableView<Hero> tableView = new TableView<>();
        ObservableList<Hero> obsherolist = FXCollections.observableArrayList(herolist);
        tableView.setItems(obsherolist);
		
		TableColumn<Hero, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(cellData -> 
	      cellData.getValue().getIdProperty().asObject()
        );
		
		TableColumn<Hero, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(90);
		nameCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("name"));
		
		TableColumn<Hero, Integer> leadCol = new TableColumn<>("Leadership");
		leadCol.setMinWidth("Leadership".length() * 10 + 30);
		leadCol.setCellValueFactory(cellData ->
			cellData.getValue().getLeaderShipProperty()
		 );
		
		TableColumn<Hero, Integer> strCol = new TableColumn<>("Stength");
		strCol.setMinWidth("Stength".length() * 10 + 30);
		strCol.setCellValueFactory(cellData ->
			cellData.getValue().getStrengthProperty()
		 );
		
		TableColumn<Hero, Integer> intCol = new TableColumn<>("Intelligence");
		intCol.setMinWidth("Intelligence".length() * 10 + 30);
		intCol.setCellValueFactory(cellData ->
			cellData.getValue().getIntelligenceProperty()
		 );
		
		TableColumn<Hero, Integer> polCol = new TableColumn<>("Politics");
		polCol.setMinWidth("Politics".length() * 10 + 30);
		polCol.setCellValueFactory(cellData ->
			cellData.getValue().getPoliticsProperty()
		 );

		tableView.getColumns().setAll(idCol, nameCol, leadCol, strCol, intCol, polCol);
		
		ImageView imageView = new ImageView();
		
		Button nextButton = new Button("Next Image");
		nextButton.getStyleClass().add("button1");
		nextButton.setOnAction(event -> {
			final Hero hero = GameData.getHeroes().get(index);
			final Image image = GameData.getPortrait(hero);
			imageView.setImage(image);
			index++;
		});
		
	    Button backButton = new Button("Back");
	    backButton.getStyleClass().add("button2");
	    backButton.setOnAction(event -> {
	    	SangokushiFX.controller.switchScene(SceneType.init);
	    });
	    
	    layout.getChildren().addAll(title, nextButton, backButton, imageView, tableView);
	}
}

package classes;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Frame extends Application {
	
	private ArrayList<Hexagon> hexs = new ArrayList<Hexagon>();
	
	private Group hGroup;
	
	private double radius = 50;

	@Override
	public void init() {
		
		double a = Math.sqrt(3);
		
		for (int i = 0;i<20;i++) {
			for (int j = 0;j<12;j+=2) {
				hexs.add(new Hexagon(radius+(i*Math.sqrt(3)*radius),((j)*(radius+Math.sin(Math.PI/6)*radius)+radius),radius));
				hexs.add(new Hexagon(radius+Math.sqrt(3)*radius/2+(i*Math.sqrt(3)*radius),((j+1)*(radius+Math.sin(Math.PI/6)*radius)+radius),radius));
			}
		}
		
		
	}

	@Override
	public void start(final Stage stage) {
		
		hGroup = new Group();
		hGroup.getChildren().addAll(hexs);
		
		Pane pane = new Pane();
		pane.getChildren().addAll(hGroup);

		Scene scene = new Scene(pane);
		scene.setFill(Color.rgb(30, 6, 40));

		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("Press ESC to exit Fullscreen");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

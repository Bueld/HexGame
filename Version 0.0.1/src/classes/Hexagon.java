package classes;

import javafx.event.EventHandler;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {
	
	private Lighting l;
	private Light.Distant li;

	public Hexagon(double x, double y, double r) {

		getPoints().addAll((x + Math.sin(0) * r), (y + Math.cos(0) * r), 
				(x + Math.sin(Math.PI / 3) * r),(y + Math.cos(Math.PI / 3) * r),
				(x + Math.sin(Math.PI / 3 * 2) * r),(y + Math.cos(Math.PI / 3 * 2) * r), 
				(x + Math.sin(Math.PI) * r), (y + Math.cos(Math.PI) * r),
				(x + Math.sin(Math.PI / 3 * 4) * r), (y + Math.cos(Math.PI / 3 * 4) * r),
				(x + Math.sin(Math.PI / 3 * 5) * r), (y + Math.cos(Math.PI / 3 * 5) * r));

		l = new Lighting();
		li = new Light.Distant();
		li.setAzimuth(-135);
		li.setColor(Color.WHITESMOKE);
		l.setLight(li);
		l.setSurfaceScale(3.0);

		setEffect(l);

		setFill(Color.STEELBLUE);
		
		
		setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				setFill(Color.DARKGOLDENROD);
				}
			
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				setFill(Color.STEELBLUE);
				}
			
		});
		
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				li.setAzimuth(45);
				setEffect(l);
				
			}
			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				li.setAzimuth(-135);
				setEffect(l);
				
			}
			
		});

	}

}

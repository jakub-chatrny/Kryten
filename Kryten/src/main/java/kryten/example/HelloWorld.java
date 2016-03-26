package kryten.example;

import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import kryten.engine.Draw;
import kryten.engine.Engine;
import kryten.factory.FontFactory;
import kryten.factory.TextureFactory;
import kryten.game.GameTemplate;

public class HelloWorld extends GameTemplate {
	private int fontSize = 10;
	
	public static void main(String[] args){
		Engine.init(800, 600);
		HelloWorld game = new HelloWorld();
		Engine.initGame(game);
		Engine.run();
	}
	
	public HelloWorld(){
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		final int posX = 50;
		final int posY = 50;
		final int width = 600;
		final int height = 100;
		final Color color = Color.gray;
		
		//drawing a gray rectangle
		Draw.rect(posX, posY, width, height, color, TextureFactory.get("blank"));
		
		//drawing a black line across rectangle
		Draw.line(posX, posY, posX+width, posY+height, Color.black, TextureFactory.get("blank"));
		
		//draw curve
		final List<Point> controlPoints = new ArrayList<Point>();	
		controlPoints.add(new Point(posX,posY));		
		controlPoints.add(new Point(posX,posY+height));
		controlPoints.add(new Point(posX+width,posY+height));
		controlPoints.add(new Point(posX+width,posY));
		Draw.curve(controlPoints, 0.0001, Color.green, TextureFactory.get("blank"));

		//rednder a text
		TrueTypeFont ttf = FontFactory.getFont("Times New Roman", Font.PLAIN,
				fontSize);
		ttf.drawString(posX, posY, "Hello world!",
				Color.white);
		ttf.drawString(posX, posY+(fontSize*2), "True type font loaded to FontFactory:"+FontFactory.capacity,
				Color.white);
		
		
		
	}

	@Override
	public void update(int FPS) {
		//update whenever is FPS counter reseted => every second
		if(FPS == 1){
			if(fontSize < 30){
				fontSize += 5;
			}
			else{
				fontSize -= 5;
			}
		}
		
	}
	

}

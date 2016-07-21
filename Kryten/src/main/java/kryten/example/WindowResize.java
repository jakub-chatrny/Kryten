package kryten.example;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import kryten.engine.Draw;
import kryten.engine.Engine;
import kryten.factory.FontFactory;
import kryten.factory.TextureFactory;
import kryten.game.GameTemplate;

public class WindowResize extends GameTemplate {
	private int fontSize = 10;
	
	public static void main(String[] args){
		//Engine.init(800,600);
		Engine.init();
		WindowResize game = new WindowResize();
		Engine.initGame(game);
		Engine.run();
	}
	
	public WindowResize(){
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		final int posX = 0;
		final int posY = 0;
		final int width = Engine.getDisplayWidth();
		final int height = Engine.getDisplayHeight();
		
		
		//drawing a green rect
		Draw.rect(0, 0, posX+width, posY+height, Color.green, TextureFactory.get("blank"));
		
		//drawing a black line across rectangle
		Draw.line(posX, posY, posX+width, posY+height, Color.black, TextureFactory.get("blank"));

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

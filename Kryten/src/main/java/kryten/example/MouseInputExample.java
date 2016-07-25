package kryten.example;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import kryten.engine.Engine;
import kryten.factory.FontFactory;
import kryten.game.GameTemplate;
import kryten.game.InputTemplate;

public class MouseInputExample extends GameTemplate{
	private InputCheck input;
	public int fontSize = 10;
	public int posX = 50;
	public int posY = 50;
	
	public static void main(String[] args){
		//Engine.init(800,600);
		Engine.init();
		MouseInputExample game = new MouseInputExample();
		Engine.initGame(game);
		Engine.run();
	}
	
	public MouseInputExample(){
		input = new InputCheck(this);
	}

	@Override
	public void getInput() {
		input.mouseCheck();		
	}

	@Override
	public void render() {
		//render a text
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
		
	}
	
	private class InputCheck extends InputTemplate{
		private MouseInputExample game;
		public InputCheck(MouseInputExample game){
			this.game = game;
		}
		
		public void mouseCheck() {
			//it's nesesery to add Check method here to run Action method.
			//there are two modes 
			// - PressedCheck - for action only once on press of button
			// - HoldCheck - action is called until is button released 
			
			//reacts just  to click
			//mouseLeftPressedCheck();
			mouseRightPressedCheck();
			
			//reacts to drag
			mouseLeftHoldCheck();
			
			
			//mouse scroll check
			mouseScrollCheck();
		}
		@Override
		protected void mouseLeftPressedAction(int x, int y) {
			
			game.posX = x;
			//origin in left bot corner
			game.posY = Engine.getDisplayHeight()-y;
			
		}
		@Override
		protected void mouseLeftReleasedAction(int x, int y) {
			game.posX = x;
			//origin in left bot corner
			game.posY = Engine.getDisplayHeight()-y;
			
		}
		@Override
		protected void mouseLeftHoldAction(int x, int y) {
			game.posX = x;
			//origin in left bot corner
			game.posY = Engine.getDisplayHeight()-y;
			
		}

		@Override
		protected void mouseRightPressedAction(int x, int y) {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void mouseScrollUpCheckAction() {
			if(fontSize > 5)
				game.fontSize -= 5;
			
		}

		@Override
		protected void mouseScrollDownCheckAction() {
			if(fontSize < 60)
				game.fontSize += 5;
			
		}

		@Override
		protected void keyLeftPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyLeftHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyRightPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyRightHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyUpPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyUpHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyDownPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyDownHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyWPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyWHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keySPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keySHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyAPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyAHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyDPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyDHoldAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF1PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF2PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF3PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF4PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF5PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF6PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF7PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF8PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF9PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF10PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF11PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyF12PressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyEscPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keyAddPressedAction() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void keySubPressedAction() {
			// TODO Auto-generated method stub
			
		}

		
	}
	

}



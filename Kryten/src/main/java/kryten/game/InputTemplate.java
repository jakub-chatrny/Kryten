package kryten.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public abstract class InputTemplate {
	private boolean leftMousePressed;
	private boolean rightMousePressed;
	
	private boolean rightArrowPressed;
	private boolean leftArrowPressed;
	private boolean upArrowPressed;
	private boolean downArrowPressed;
	
	private boolean f1Pressed;
	private boolean f2Pressed;
	private boolean f3Pressed;
	private boolean f4Pressed;
	private boolean f5Pressed;
	private boolean f6Pressed;
	private boolean f7Pressed;
	private boolean f8Pressed;
	private boolean f9Pressed;
	private boolean f10Pressed;
	private boolean f11Pressed;
	private boolean f12Pressed;
	private boolean escPressed;
	
	private boolean addPressed;
	private boolean subPressed;
	
	private boolean wPressed;
	private boolean sPressed;
	private boolean aPressed;
	private boolean dPressed;
	
	
	// ////////
	// MOUSE //
	// ////////
	protected boolean mouseLeftPressedCheck() {
		if (Mouse.isButtonDown(0)) {
			if(!isLeftMousePressed()){
				mouseLeftPressedAction(Mouse.getX(),Mouse.getY());
			}
			setLeftMousePressed(true);
			return true;
		} else if (!Mouse.isButtonDown(0) && isLeftMousePressed()) {
			setLeftMousePressed(false);	
		}
		return false;
	}

	protected abstract void mouseLeftPressedAction(int x, int y);
	
	protected boolean mouseRightPressedCheck() {
		if (Mouse.isButtonDown(1)) {
			if(!isRightMousePressed()){
				mouseRightPressedAction(Mouse.getX(),Mouse.getY());		
			}
			setRightMousePressed(true);
			return true;
		} else if (!Mouse.isButtonDown(1) && isRightMousePressed()) {
			setRightMousePressed(false);	
		}
		return false;
	}

	protected abstract void mouseRightPressedAction(int x, int y);
	
	protected boolean mouseScrollCheck() {
		final int dWheel = Mouse.getDWheel();
		if (Mouse.hasWheel() && dWheel != 0){
			if(dWheel < 0){
				mouseScrollDownCheckAction();
				return true;
			}
			else if(dWheel > 0){
				mouseScrollUpCheckAction();
				return true;
			}
		}
		return false;
	}
	protected abstract void mouseScrollUpCheckAction();
	protected abstract void mouseScrollDownCheckAction();

	// ////////
	// ARROWS//
	// ////////

	// left arrow
	protected boolean keyLeftPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			leftArrowPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_LEFT) && leftArrowPressed) {
			leftArrowPressed = false;
			keyLeftPressedAction();
		}
		return leftArrowPressed;
	}

	protected abstract void keyLeftPressedAction();

	protected boolean keyLeftHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			keyLeftHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyLeftHoldAction();

	// rigtht arrow
	protected boolean keyRightPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			rightArrowPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && rightArrowPressed) {
			rightArrowPressed = false;
			keyRightPressedAction();
		}
		return rightArrowPressed;
	}

	protected abstract void keyRightPressedAction();

	protected boolean keyRightHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			keyRightHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyRightHoldAction();

	// up arrow
	protected boolean keyUpPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			upArrowPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_UP) && upArrowPressed) {
			upArrowPressed = false;
			keyUpPressedAction();
		}
		return upArrowPressed;
	}

	protected abstract void keyUpPressedAction();

	protected boolean keyUpHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			keyUpHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyUpHoldAction();

	// down arrow
	protected boolean keyDownPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			downArrowPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_DOWN) && downArrowPressed) {
			downArrowPressed = false;
			keyDownPressedAction();
		}
		return downArrowPressed;
	}

	protected abstract void keyDownPressedAction();

	protected boolean keyDownHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			keyDownHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyDownHoldAction();
	// ///////////////
	// ALPHABET KEYS//
	// ///////////////
	// W
	protected boolean keyWPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			wPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_W) && wPressed) {
			wPressed = false;
			keyWPressedAction();
		}
		return wPressed;
	}
	
	protected abstract void keyWPressedAction();
	
	protected boolean keyWHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			keyWHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyWHoldAction();
	
	// S
	protected boolean keySPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			sPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_S) && sPressed) {
			sPressed = false;
			keySPressedAction();
		}
		return sPressed;
	}
	
	protected abstract void keySPressedAction();
	
	protected boolean keySHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			keySHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keySHoldAction();
	
	// A
	protected boolean keyAPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			aPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_A) && aPressed) {
			aPressed = false;
			keyAPressedAction();
		}
		return aPressed;
	}
	
	protected abstract void keyAPressedAction();
	
	protected boolean keyAHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			keyAHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyAHoldAction();
	// D
	protected boolean keyDPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			dPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_D) && dPressed) {
			dPressed = false;
			keyDPressedAction();
		}
		return dPressed;
	}
	
	protected abstract void keyDPressedAction();
	
	protected boolean keyDHoldCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			keyDHoldAction();
			return true;
		} else
			return false;
	}

	protected abstract void keyDHoldAction();
	
	// ////////
	// F KEYS//
	// ////////
	// f1
	protected boolean keyF1PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F1)) {
			f1Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F1) && f1Pressed) {
			f1Pressed = false;
			keyF1PressedAction();
		}
		return f1Pressed;
	}

	protected abstract void keyF1PressedAction();

	// f2
	protected boolean keyF2PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F2)) {
			f2Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F2) && f2Pressed) {
			f2Pressed = false;
			keyF2PressedAction();
		}
		return f2Pressed;
	}

	protected abstract void keyF2PressedAction();

	// f3
	protected boolean keyF3PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F3)) {
			f3Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F3) && f3Pressed) {
			f3Pressed = false;
			keyF3PressedAction();
		}
		return f3Pressed;
	}

	protected abstract void keyF3PressedAction();

	// f4
	protected boolean keyF4PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F4)) {
			f4Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F4) && f4Pressed) {
			f4Pressed = false;
			keyF4PressedAction();
		}
		return f4Pressed;
	}

	protected abstract void keyF4PressedAction();

	// f5
	protected boolean keyF5PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F5)) {
			f5Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F5) && f5Pressed) {
			f5Pressed = false;
			keyF5PressedAction();
		}
		return f5Pressed;
	}

	protected abstract void keyF5PressedAction();

	// f6
	protected boolean keyF6PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F6)) {
			f6Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F6) && f4Pressed) {
			f6Pressed = false;
			keyF6PressedAction();
		}
		return f6Pressed;
	}

	protected abstract void keyF6PressedAction();

	// f7
	protected boolean keyF7PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F7)) {
			f7Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F7) && f7Pressed) {
			f7Pressed = false;
			keyF7PressedAction();
		}
		return f7Pressed;
	}

	protected abstract void keyF7PressedAction();

	// f8
	protected boolean keyF8PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F8)) {
			f8Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F8) && f8Pressed) {
			f8Pressed = false;
			keyF8PressedAction();
		}
		return f8Pressed;
	}

	protected abstract void keyF8PressedAction();

	// f9
	protected boolean keyF9PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F9)) {
			f9Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F9) && f9Pressed) {
			f9Pressed = false;
			keyF9PressedAction();
		}
		return f9Pressed;
	}

	protected abstract void keyF9PressedAction();

	// f10
	protected boolean keyF10PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F10)) {
			f10Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F10) && f10Pressed) {
			f10Pressed = false;
			keyF10PressedAction();
		}
		return f10Pressed;
	}

	protected abstract void keyF10PressedAction();

	// f11
	protected boolean keyF11PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F11)) {
			f11Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F11) && f11Pressed) {
			f11Pressed = false;
			keyF11PressedAction();
		}
		return f11Pressed;
	}

	protected abstract void keyF11PressedAction();

	// f12
	protected boolean keyF12PressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_F12)) {
			f12Pressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_F12) && f12Pressed) {
			f12Pressed = false;
			keyF12PressedAction();
		}
		return f12Pressed;
	}

	protected abstract void keyF12PressedAction();

	// ESC
	protected boolean keyEscPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			escPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && escPressed) {
			escPressed = false;
			keyEscPressedAction();
		}
		return escPressed;
	}

	protected abstract void keyEscPressedAction();

	// /////////
	// NUMERIC//
	// /////////
	// +
	protected boolean keyAddPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
			addPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_ADD) && addPressed) {
			addPressed = false;
			keyAddPressedAction();
		}
		return addPressed;
	}

	protected abstract void keyAddPressedAction();

	// -
	protected boolean keySubPressedCheck() {
		if (Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT)) {
			subPressed = true;
		} else if (!Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT) && subPressed) {
			subPressed = false;
			keySubPressedAction();
		}
		return subPressed;
	}

	protected abstract void keySubPressedAction();

	/**
	 * @return the leftMousePressed
	 */
	private boolean isLeftMousePressed() {
		return leftMousePressed;
	}

	/**
	 * @param leftMousePressed the leftMousePressed to set
	 */
	private void setLeftMousePressed(boolean leftMousePressed) {
		this.leftMousePressed = leftMousePressed;
	}

	/**
	 * @return the rightMousePressed
	 */
	private boolean isRightMousePressed() {
		return rightMousePressed;
	}

	/**
	 * @param rightMousePressed the rightMousePressed to set
	 */
	private void setRightMousePressed(boolean rightMousePressed) {
		this.rightMousePressed = rightMousePressed;
	}
}
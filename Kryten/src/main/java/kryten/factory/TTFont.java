package kryten.factory;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.TrueTypeFont;

/**
 * Represents group of fonts from same family with different sizes.
 * @author Jakub Chatrný
 *
 */
public class TTFont {
	private Map<Integer,TrueTypeFont> specificFont;
	/**
	 * Creates empty font group
	 */
	public TTFont(){
		specificFont = new HashMap<Integer,TrueTypeFont>();
	}
	/**
	 * Puts new font.
	 * @param key
	 * @param ttf
	 */
	public void put(final int key, final TrueTypeFont ttf){
		specificFont.put(key, ttf);
	}
	/**
	 * Gets font with specific size. 
	 * @param key
	 * @return
	 */
	public TrueTypeFont get(final int key){
		return specificFont.get(key);
	}
		
}
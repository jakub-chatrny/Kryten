package kryten.engine;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

/**
 * Draws geometric object to frame buffer.
 * 
 * @author jchatrny
 *
 */
public class Draw {
	private final static boolean counterFlag = true;
	private static int drawCounter;
	
	/**
	 * Draws line with color and texture. 
	 * 
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 * @param color
	 * @param texture
	 */
	public static void line(final float sx, final float sy, final float ex, final float ey,
			final Color color, final Texture texture) {
		glPushMatrix();
		{
			//glTranslatef(0, 0, 0);
			glColor4f(color.r, color.g, color.b, color.a);

			texture.bind();

			glBegin(GL_LINES);
			{
				glVertex2f(sx, sy);
				glVertex2f(ex, ey);
				
			}
			glEnd();
		}
		glPopMatrix();
		incDrawCounter();		
	}
	/**
	 * Draws rectangle with color and texture. Draw from x, y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 * @param texture
	 */
	public static void rect(final float x, final float y, final float width, final float height,
			final Color color, final Texture texture) {
		glPushMatrix();
		{
			glTranslatef(x, y, 0);
			glColor4f(color.r, color.g, color.b, color.a);

			texture.bind();

			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0);
				glVertex2f(0, 0);
				glTexCoord2f(0, 1);
				glVertex2f(0, height);
				glTexCoord2f(1, 1);
				glVertex2f(width, height);
				glTexCoord2f(1, 0);
				glVertex2f(width, 0);
			}
			glEnd();
		}
		glPopMatrix();
		incDrawCounter();
	}

	/**
	 * Draws rectangle with color,texture and rotate it. Draw object from
	 * center.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param rot
	 * @param color
	 * @param texture
	 */
	public static void rectRot(final float x, final float y, float width, float height,
			final float rot, final Color color, final Texture texture) {

		glPushMatrix();
		{
			width /= 2;
			height /= 2;
			glTranslatef(x + width, y + height, 0);
			glRotatef(rot, 0, 0, 1);

			glColor4ub((byte) color.getRedByte(), (byte) color.getGreenByte(),
					(byte) color.getBlueByte(), (byte) color.getAlphaByte());
			texture.bind();

			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0);
				glVertex2f(-width, -height);
				glTexCoord2f(0, 1);
				glVertex2f(-width, height);
				glTexCoord2f(1, 1);
				glVertex2f(width, height);
				glTexCoord2f(1, 0);
				glVertex2f(width, -height);
			}
			glEnd();
		}
		glPopMatrix();
		incDrawCounter();
	}
	/**
	 * Draws rectangle with color and texture. Draw from x, y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 * @param texture
	 */
	public static void rectRepTex(final int x, final int y, final int width, final int height,
			final Color color, final Texture texture, final int scaleX, final int scaleY) {
		rectRepTex((float) x, (float)y, (float)width, (float)height, color, texture, (float)scaleX, (float)scaleY);
	}
	public static void rectRepTex(final float x, final float y, final float width, final float height,
			final Color color, final Texture texture, final float scaleX, final float scaleY) {
		glPushMatrix();
		{
			glTranslatef(x, y, 0);

			glColor4ub((byte) color.getRedByte(), (byte) color.getGreenByte(),
					(byte) color.getBlueByte(), (byte) color.getAlphaByte());
			texture.bind();

			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0);
				glVertex2f(0, 0);
				glTexCoord2f(0, scaleY);
				glVertex2f(0, height);
				glTexCoord2f(scaleX, scaleY);
				glVertex2f(width, height);
				glTexCoord2f(scaleX, 0);
				glVertex2f(width, 0);
			}
			glEnd();
		}
		glPopMatrix();
		incDrawCounter();
	}
	
	private static void incDrawCounter(){
		if(counterFlag){
			Draw.drawCounter++;
		}
	}
	
	public static void resetDrawCounter(){
		Draw.drawCounter = 0;
	}
	
	public static int getDrawCounter() {
		return Draw.drawCounter;
	}
}
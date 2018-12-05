package game;

import java.awt.Image;
import java.awt.Toolkit;

public class Background {
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	
	public Background() {
		setxCoord(1);
		setyCoord(1);
		setWidth(1);
		setHeight(1);
		setImg("../Files/Cool.png"); 
	}		
		public Background(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
		}
		
		public void setImg(String imgpath) {
			this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}
		

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	public void moveIt(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}



package game;

		import java.awt.Image;
		import java.awt.Toolkit;

		public class Badguy {
			
			private float xCoord = 0;
			private float yCoord = 0;
			private int width = 10;
			private int height = 10;
			private Image img;
			
			public Badguy() {
				setxCoord(10);
				setyCoord(10);
				setWidth(50);
				setHeight(50);
				setImg("../files/right.png"); 
			}		
				public Badguy(int x, int y, int w, int h, int s, String imgpath) {
					setxCoord(x);
					setyCoord(y);
					setWidth(w);
					setHeight(h);
					setImg(imgpath);
				}
				
				public void setImg(String imgpath) {
					this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
			}
				

			public float getxCoord() {
				return xCoord;
			}

			public void setxCoord(float xCoord) {
				this.xCoord = xCoord;
			}

			public float getyCoord() {
				return yCoord;
			}

			public void setyCoord(float yCoord) {
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
		}


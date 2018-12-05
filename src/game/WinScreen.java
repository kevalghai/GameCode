package game;

		import java.awt.Image;
		import java.awt.Toolkit;

		public class WinScreen {
			
			private int xCoord = 0;
			private int yCoord = 0;
			private int width = 10;
			private int height = 10;
			private Image img;
			
			public WinScreen() {
				setxCoord(10);
				setyCoord(10);
				setWidth(50);
				setHeight(50);
				setImg("../files/right.png"); 
			}		
				public WinScreen(int x, int y, int w, int h, String imgpath) {
					setxCoord(x);
					setyCoord(y);
					setWidth(w);
					setHeight(h);
					setImg(imgpath);
				}
			//	public Badguy(int nextInt, int nextInt2, int i, int j, String string) {
					// TODO Auto-generated constructor stub
			//	}
			//	private void setSpeed(int s) {
					//this.speed = s;
					// TODO Auto-generated method stub
					
			//	}
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
		}

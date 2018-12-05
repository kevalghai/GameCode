package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.*;

public class MyCanvas extends Canvas implements KeyListener {
	
	Goodguy rocket = new Goodguy (450, 675, 50, 100,"Files/rocket.png");
	LinkedList asteroids = new LinkedList();
	Background Cool = new Background (0, 0, 300,150, "Files/Cool.png");
	Gif alien = new Gif (10, 10, 400,300, "Files/alien.png");
	LinkedList Laser = new LinkedList();
	boolean GameOver = false;
	NewScreen gameover = new NewScreen (-220, 0, 200,300, "Files/gameover.png");
	boolean HomeScreen = true;	
	SplashScreen Pressstart = new SplashScreen (-800, 0, 1000,1000, "Files/Pressstart.png");
	boolean YouWin = false;
	WinScreen youwin = new WinScreen (-220, 0, 300, 300, "Files/youwin.png");
	Spark spark = new Spark (700, 10, 400,300, "Files/spark.png");
 	int score = 0;
 	int Level = 0;
	//String scorechart = "Score = " + score;
	
 	public MyCanvas() {
		this.setSize(1300,800);
		this.addKeyListener(this);
	    
		Random rand = new Random();
	    int winwidth = this.getWidth() -100;
	    
	    if (Level == 4) {
	    	for(int i = 0; i<500; i++) {
	   	    	Badguy bg = new Badguy(rand.nextInt(winwidth),0 + (int)(Math.random() * (100 - 600) + 1),60,100,10, "Files/asteroid.png");
	   	    	Rectangle r = new Rectangle(100,100,100,30);
	   	    	if (r.contains(rocket.getxCoord(), rocket.getyCoord())) {
	   	    		System.out.println("badguy on top of rocket");
	   	    		continue;
	   	    	} 
	   	    	
   	    		asteroids.add(bg);


	   	 }  
	    }
	    
	    else {
	    	for(int i = 0; i<50; i++) {
	   	    	Badguy bg = new Badguy(rand.nextInt(winwidth),0 + (int)(Math.random() * (100 - 600) + 1),60,100,10, "Files/asteroid.png");
	   	    	Rectangle r = new Rectangle(100,100,100,30);
	   	    	if (r.contains(rocket.getxCoord(), rocket.getyCoord())) {
	   	    		System.out.println("badguy on top of rocket");
	   	    		continue;
	   	    	} 		   	    		
	   	    	
	   	    	asteroids.add(bg);

	   	    }  
	    }
	    	   
	    	   
	    	
	    	   
	try {
	    File yourFile = new File("Files/realmusic.wav");
	    AudioInputStream stream;
	    AudioFormat format;
	    DataLine.Info info;
	    Clip clip;
	    stream = AudioSystem.getAudioInputStream(yourFile);
	    format = stream.getFormat();
	    info = new DataLine.Info(Clip.class, format);
	    clip = (Clip) AudioSystem.getLine(info);
	    clip.open(stream);
	    clip.start();
	    
	}
	catch (Exception e) {
	}
	}
	
	public void paint(Graphics g) {
		
	//score = score + 1;
		
		if (HomeScreen) {
			Image img1 = Toolkit.getDefaultToolkit().getImage("Files/Pressstart.png");
			int width = img1.getWidth(this);
			int height = img1.getHeight(this);
			int w = width*5;
			int h = height*6;
			
			g.drawImage(Pressstart.getImg(), Pressstart.getxCoord(), Pressstart.getyCoord(), (int) w, (int) h, this);
			Font font = new Font("Serif", Font.BOLD, 50);
			g.setFont(font);
			g.setColor(Color.GREEN);
			g.drawString("Press Enter for Easy", 500, 360);
			g.setColor(Color.BLUE);
			g.drawString("Press 2 for Meduim", 500, 450);
			g.setColor(Color.MAGENTA);
			g.drawString("Press 3 for Hard", 500, 540);
			g.setColor(Color.WHITE);
			g.drawString("Use Arrow Keys to Move Left and Right", 100, 200);
			g.drawString("Use Space Bar to Shoot Lasers", 100, 100);
			
		}
					
		else if (GameOver) {
			Image img1 = Toolkit.getDefaultToolkit().getImage("Files/gameover.png");
			int width = img1.getWidth(this);
			int height = img1.getHeight(this);
			int w = width*2;
			int h = height*2;
			
			g.drawImage(gameover.getImg(), gameover.getxCoord(), gameover.getyCoord(), (int) w, (int) h, this);
			Font font = new Font("Serif", Font.BOLD, 60);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Final Score = " + score, 450, 750);

		
		} else {
		
		Image img1 = Toolkit.getDefaultToolkit().getImage("Files/Background.png");
		int width = img1.getWidth(this);
		int height = img1.getHeight(this);
		int w = width*5;
		int h = height*5; //An example of the many screens and images I created 
			
		g.drawImage(Cool.getImg(), Cool.getxCoord(),Cool.getyCoord() , (int) w, (int) h, this);
		g.drawImage(rocket.getImg(), rocket.getxCoord(), rocket.getyCoord(), rocket.getWidth(), rocket.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.drawString("Score = " + score, 10, 20); //Scoring System 
		
		
		for(int i = 0; i < asteroids.size(); i++) {
			Badguy one = (Badguy) asteroids.get(i);
			if (Level == 1) {
				one.setyCoord(one.getyCoord()+ (float) + 0.8 ); //Changing the speed to produce different levels
			}
			if (Level == 2) {
				one.setyCoord(one.getyCoord()+ (float) + 1.8  );

			}
			if (Level == 3) {
				one.setyCoord(one.getyCoord()+ (float) + 2.7 ); 

			}
			if (Level == 4) {
				one.setyCoord(one.getyCoord()+ (float) + 2.5 ); 

			}
			g.drawImage(one.getImg(), Math.round(one.getxCoord()), Math.round(one.getyCoord()), one.getWidth(), one.getHeight(), this);
			
			if (score == 500) {
				YouWin = true;

			} 
	
			if (one.getyCoord() > 750) {
				GameOver = true;
				
				try {
				    File yourFile = new File("Files/Gamingisover.wav");
			        AudioInputStream stream;
				    AudioFormat format;
				    DataLine.Info info;
			    Clip clip;
				    stream = AudioSystem.getAudioInputStream(yourFile);
				    format = stream.getFormat();
				    info = new DataLine.Info(Clip.class, format);
				    clip = (Clip) AudioSystem.getLine(info);
				    clip.open(stream);
				    clip.start();

				}
				catch (Exception e) {
			 	}
				
			} 
		for(int j = 0; j < Laser.size(); j++) {
			Projectile k = (Projectile) Laser.get(j);
			if (k.getyCoord() < 0) { Laser.remove(k); }
			k.setyCoord(k.getyCoord() - 4);
			g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this); 
			Rectangle kr = new Rectangle(k.getxCoord(),k.getyCoord(),k.getWidth(),k.getHeight());
				Rectangle r = new Rectangle(Math.round(one.getxCoord()), Math.round(one.getyCoord()), one.getWidth(), one.getHeight());
				if (kr.intersects(r)) {
					asteroids.remove(i);
					try {
					    File yourFile = new File("Files/expoloding.wav"); //One of the various sound effect that I've included 
				        AudioInputStream stream;
					    AudioFormat format;
					    DataLine.Info info;
				    Clip clip;
					    stream = AudioSystem.getAudioInputStream(yourFile);
					    format = stream.getFormat();
					    info = new DataLine.Info(Clip.class, format);
					    clip = (Clip) AudioSystem.getLine(info);
					    clip.open(stream);
					    clip.start();

					}
					catch (Exception e) {
				 	}
					score += 10; //Adding 10 to the score every time there's a collision 
					Laser.remove(j);
				} 
				}
				 
			
		} 

		}	
		
		if (score == 500) {
			Image img1 = Toolkit.getDefaultToolkit().getImage("Files/youwin.png");
			int width = img1.getWidth(this);
			int height = img1.getHeight(this);
			int w = width*2;
			int h = height*2;
			
			g.drawImage(youwin.getImg(), youwin.getxCoord(), youwin.getyCoord(), (int) w, (int) h, this);
		
		} if (score == 500) {	
			Image img1 = Toolkit.getDefaultToolkit().getImage("Files/alien.png");
			int width = img1.getWidth(this);
			int height = img1.getHeight(this);
			int w = width;
			int h = height;
			g.drawImage(alien.getImg(), alien.getxCoord(), alien.getyCoord(), (int) w, (int) h, this);
			
		} if (score == 500) {	
			Image img1 = Toolkit.getDefaultToolkit().getImage("Files/spark.png");
			int width = img1.getWidth(this);
			int height = img1.getHeight(this);
			int w = width;
			int h = height;
			g.drawImage(spark.getImg(), spark.getxCoord(), spark.getyCoord(), (int) w, (int) h, this);

			
			try {
			    File yourFile = new File("Files/.wav");
			    AudioInputStream stream;
			    AudioFormat format;
			    DataLine.Info info;
			    Clip clip;
			    stream = AudioSystem.getAudioInputStream(yourFile);
			    format = stream.getFormat();
			    info = new DataLine.Info(Clip.class, format);
			    clip = (Clip) AudioSystem.getLine(info);
			    clip.open(stream);
			    clip.start();
			    
			}
			catch (Exception e) {
			}
		} 
	}
			
	public void keyTyped(KeyEvent e) {
		
	}
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			System.out.println(e);
			if (key == KeyEvent.VK_SPACE) {
				Projectile laser = new Projectile(rocket.getxCoord(),rocket.getyCoord(),30,30,"Files/Laser.png");
				Laser.add(laser);
			} 
			 
			rocket.moveIt(e.getKeyCode(),this.getWidth(),this.getHeight());

					
				if (key == KeyEvent.VK_SPACE) { 
		
				try {
				    File yourFile = new File("Files/laser1.wav");
				    AudioInputStream stream;
				    AudioFormat format;
				    DataLine.Info info;
				    Clip clip;
				    stream = AudioSystem.getAudioInputStream(yourFile);
				    format = stream.getFormat();
				    info = new DataLine.Info(Clip.class, format);
				    clip = (Clip) AudioSystem.getLine(info);
				    clip.open(stream);
				    clip.start();
			
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
			
			repaint();
			}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_ENTER)	{ 
				HomeScreen = false;
				Level = 1;
				
			}
			
			if (key == KeyEvent.VK_2) {
				HomeScreen = false;
				Level = 2;
			
			}
			
			if (key == KeyEvent.VK_3) {
				HomeScreen = false;
				Level = 3;
				
		}
			if (key == KeyEvent.VK_4) {
				HomeScreen = false;
				Level = 4;
			
			
		}
} 
}



import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class Draw extends JComponent{
	
	public int x = 60;
	public int y = 60;

	public int state = 0;

	public BufferedImage image;
	public BufferedImage background;
	public URL bg = getClass().getResource("bc.png");
	public URL resource = getClass().getResource("naruto1.png");

	public Draw(){
		try{
			image = ImageIO.read(resource);
			background = ImageIO.read(bg);
		}
		catch(IOException e){
			e.printStackTrace();
		}
			
	}

	public void ReloadImage(){
		if(state==0){
			resource = getClass().getResource("naruto1.png");
		}
		else if(state==1){
			resource = getClass().getResource("naruto2.png");
		}
		else if(state==2){
			resource = getClass().getResource("naruto3.png");
		}
		else if(state==3){
			resource = getClass().getResource("naruto4.png");
		}
		else if(state==4){
			resource = getClass().getResource("naruto5.png");
		}
		else if(state==5){
			resource = getClass().getResource("naruto6.png");
		}
		state++;
		if(state == 6){
			state = 0;
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attack(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                for(int astate = 0;astate<5;astate++){
                    if(astate==5){
                        resource = getClass().getResource("Attack12.png");
                    }

                    else{
                        resource = getClass().getResource("Attack1"+astate+".png");
                    }

                    try{
                        image = ImageIO.read(resource);
                    }
                    catch(IOException e){ 
                        e.printStackTrace();
                    }

                    repaint();    

                    try{
                        Thread.sleep(1);    
                    }
                    catch(InterruptedException e){

                    }
                }
            }
        });

        thread1.start();
    }


	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.drawImage(background,0,0,this);
		g.drawImage(image,x,y,this);
	}

	public void moveUP(){
		y = y - 8;
		ReloadImage();
		repaint();
	}

	public void moveDOWN(){
		y = y + 8;
		ReloadImage();
		repaint();
	}

	public void moveLEFT(){
		x = x - 8;
		ReloadImage();
		repaint();
	}

	public void moveRIGHT(){
		x = x + 8;
		ReloadImage();
		repaint();
	}

}
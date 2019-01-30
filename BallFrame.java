import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BallFrame extends JFrame implements KeyListener{
	
	Draw paint;
	public BallFrame(){
		this.paint = new Draw();
	}
	public void keyTyped(KeyEvent e){
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_D){
			paint.moveRIGHT();
			System.out.println("RIGHT");
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			paint.moveLEFT();
			System.out.println("LEFT");
		}
		else if(e.getKeyCode() == KeyEvent.VK_W){
			paint.moveUP();
			System.out.println("UP");
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			paint.moveDOWN();
			System.out.println("DOWN");
		}
		else if(e.getKeyCode() == KeyEvent.VK_J){
            paint.attack();
            System.out.println("Attack");
        }
	}

	public void keyReleased(KeyEvent e){
	
	}


	public static void main(String args[]){

	//create frame
		BallFrame frame0 = new BallFrame();
		//create label object
		frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame0.setVisible(true);
		frame0.setSize(492,355);
		frame0.add(frame0.paint);
		frame0.addKeyListener(frame0);
	}
}
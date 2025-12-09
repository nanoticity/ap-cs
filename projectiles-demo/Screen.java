import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;






public class Screen extends JPanel implements KeyListener{


	private Game game;
	
	public Screen(){
		
		game = new Game();
	
        setFocusable(true);
		addKeyListener(this);
	}


	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
	
	
		game.drawMe(g);




	} 




	public void animate(){
		
		while(true){
			//wait for .01 second
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}


			//repaint the graphics drawn
			repaint();
		}


	}
	
	
	public void keyPressed(KeyEvent e){
		System.out.println( e.getKeyCode() ); //use to detect what key is pressed
		
		if(  e.getKeyCode() == 38 ){
			//call the method for the ship to move up
			game.movePlayer("up");
		
			
		} else if( e.getKeyCode() == 40  ){
			//call the method for the ship to move down
			game.movePlayer("down");
		
		}
		
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
}


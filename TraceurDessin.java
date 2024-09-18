package interfaces.traceurDessin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*class EcouterPx implements ActionListener{
	ex3tp3 st;
	public void actionPerformed(ActionEvent e) {
		st.setStrPx((String) e.getSelectedItem());
	}
}*/

class EcouterEffacer implements ActionListener{
	TraceurDessin va;
	public void actionPerformed(ActionEvent e) {
		va.repaint();
	}
}
public class TraceurDessin extends JFrame implements MouseListener,MouseMotionListener,KeyListener{
	static int x1,y1,x2,y2,x,y;
	JPanel pan;
	Graphics g;
	String px[]= {"1PX","3PX","5PX","8PX"},strpx;
	
	public void paint(int x,int y,Graphics g) {
		g.drawLine(x, y, x, y);
	}
	
	public void setStrPx(String str) {
		strpx=str;
	}
		
	public TraceurDessin() {
		setTitle("tracer------");
		setSize(800,500);
		setLocationRelativeTo(null);
		pan = new JPanel();
		pan.setBackground(Color.cyan);
		pan.setSize(800,500); this.add(pan);
		pan.setFocusable(true);
		pan.setLayout(null);
		/*JButton but = new JButton("Effecer"); pan.add(but); but.setBounds(0,0,75,30);
		JComboBox combo =new JComboBox(px); pan.add(combo); combo.setBounds(80,0,30,30);*/
		JMenuBar menubar =new JMenuBar(); setJMenuBar(menubar);
		JMenu cont=new JMenu("controle"); menubar.add(cont);
		JMenuItem effa =new JMenuItem("effacer"); cont.add(effa);
		JMenu px=new JMenu("PX"); cont.add(px);
		JMenuItem px1 =new JMenuItem("1PX"); px.add(px1); px1.setSelected(true);
		JMenuItem px3 =new JMenuItem("3PX"); px.add(px3);
		JMenuItem px5 =new JMenuItem("5PX"); px.add(px5);
		JMenuItem px8 =new JMenuItem("8PX"); px.add(px8);
		pan.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				g=pan.getGraphics();
				x1=e.getX();y1=e.getY();
				System.out.println(x1+","+y1);
				System.out.println(strpx);
				x=x1; y=y1;
				paint(x,y,g);
			}
		});
		
		px.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//strpx=(String)e.getSource();
				setStrPx((String) e.getSource());
			}
		});
		pan.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==37) {
					x--;
					paint(x,y,g);
				}
				if(e.getKeyCode()==38) {
					y--;
					paint(x,y,g);
				}
				if(e.getKeyCode()==39) {
					x++;
					paint(x,y,g);
				}
				if(e.getKeyCode()==40) {
					y++;
					paint(x,y,g);
				}
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyTyped(KeyEvent e) {
			}
		});
		pan.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				x1=e.getX();y1=e.getY();
				g.drawLine(x, y, x1, y1);
				x=x1;y=y1;
			}
			public void mouseMoved(MouseEvent e){
				/*x1=e.getX();y1=e.getY();
				paint(x1,y1,g);
				x1=e.getX();y1=e.getY();
				g.drawLine(x, y, x1, y1);
				x=x1;y=y1;*/

			}
		});
		
		/*but.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//repaint();
			}
		});*/
		/*effa.addActionListener(new EcouterEffacer());
		px.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStrPx((String) px.getSelectedItem());
			}
		});*/
		//System.out.println(strpx);
	}
	
	public static void main(String[] args) {
		TraceurDessin tr = new TraceurDessin();
		tr.setVisible(true);
	}
}

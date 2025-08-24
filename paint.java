import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class paint extends Applet implements MouseListener,MouseMotionListener,ActionListener
{
	int sx,sy,ex,ey;
	TextField t1,t2,t3;
	Button draw,erase;
	Color c;
	int d=0;

	public void init()
	{
		sx=sy=ex=ey=0;

		t1=new TextField("0",3);
		t2=new TextField("0",3);
		t3=new TextField("0",3);
		draw=new Button("Draw");
		erase=new Button("Erase");

		add(t1);
		add(t2);
		add(t3);
		c=new Color(0,0,0);
		add(draw);
		add(erase);

		addMouseListener(this);
		addMouseMotionListener(this);
		draw.addActionListener(this);
		erase.addActionListener(this);
	}

	public void mousePressed(MouseEvent e1)
	{
		if(e1.getModifiers()==16)
		{
			sx=e1.getX();
			sy=e1.getY();
		}
	}

	public void mouseDragged(MouseEvent e2)
	{
		if(e2.getModifiers()==16)
		{
			repaint();
			ex=e2.getX();
			ey=e2.getY();
		}
	}

	public void update(Graphics g)
	{
		if(d==0)
		{
c=new Color(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()));
		g.setColor(c);
		g.drawLine(sx,sy,ex,ey);
		}

		if(d==1)
		{
		g.setColor(getBackground());
		g.fillRect(sx,sy,20,20);
		}
		sx=ex;
		sy=ey;
	}

	public void mouseMoved(MouseEvent e3){}
	public void mouseClicked(MouseEvent e4){}
	public void mouseEntered(MouseEvent e5){}
	public void mouseExited(MouseEvent e6){}
	public void mouseReleased(MouseEvent e7){}

	public void actionPerformed(ActionEvent e8)
	{
		if(e8.getSource()==draw)
		{
			d=0;
		}
		if(e8.getSource()==erase)
		{
			d=1;
		}
	}
}
//<applet code="paint.java" height=500 width=500></applet>
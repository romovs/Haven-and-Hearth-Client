package haven.pathfinder;

import java.awt.*;


import javax.swing.JFrame;

public class DbgWnd extends JFrame
{
    public Map map;      

    public DbgWnd(Map map, int width, int height) {
	    super("PathFinder Dbg");       
	    this.map = map;
	    setSize(width, height);
	    setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
    }
    
    
    public void setScene(Map map) {
    	this.map = map;
    }

	public void paint(Graphics g) {
	    super.paint(g);

	  //  ((Graphics2D)g).scale(0.85, 0.85);

	    Node src = null;
	    Node dst = null;
	    
        for(int i=0;i<map.h;i++){
            for(int j=0;j<map.w;j++){
            	Node cell = map.nodes[j][i];
            	
            	if (cell.isPartOfPath()) {
            		g.setColor(new Color(176, 23, 31));
            	} else if (cell.pathTraversed) {
            		g.setColor(new Color(125, 158, 192));
            	} else if (cell.isSrc()) {
            		src = cell;
            		g.setColor(new Color(113, 198, 113));
            	} else if (cell.isDst()) {
            		dst = cell;
            		g.setColor(Color.RED);
            	} else {
	            	switch (map.nodes[j][i].type) {
	            		case BLOCK_DYNAMIC:
	            		case BLOCK: g.setColor(Color.BLACK); break;
	            		case NORMAL: g.setColor(Color.LIGHT_GRAY); break;
	            		case MOUNTAIN: g.setColor(Color.DARK_GRAY); break;        	
	            		case SWAMP: g.setColor(new Color(142, 142, 56)); break;
	            		case THICKET: g.setColor(Color.WHITE); break;   
	            		case GRASS: g.setColor(Color.GREEN); break;
	            		case HEATH: g.setColor(Color.PINK); break;
	            		case MOOR: g.setColor(Color.YELLOW); break;
	            		case WATER_DEEP: g.setColor(Color.BLUE); break;
	            		case WATER_SHALLOW: g.setColor(Color.CYAN); break;
	            		case SAND: g.setColor(new Color(249, 255, 128)); break;
	            		case NOT_IMPLEMENTED: g.setColor(Color.ORANGE); break;
	            		default: g.setColor(Color.GRAY); break;
	            	}
            	}
            	g.drawLine(j, i, j, i);
            }
        } 
        if (src != null) {
	        g.setColor(new Color(113, 198, 113));
	    	g.drawLine(src.x, src.y, src.x, src.y);
	    	g.drawLine(src.x+1, src.y, src.x+1, src.y);
	    	g.drawLine(src.x+1, src.y+1, src.x+1, src.y+1);
	    	g.drawLine(src.x, src.y+1, src.x, src.y+1);
        }
        if (dst != null) {
			g.setColor(Color.RED);
	    	g.drawLine(dst.x, dst.y, dst.x, dst.y);
	    	g.drawLine(dst.x+1, dst.y, dst.x+1, dst.y);
	    	g.drawLine(dst.x+1, dst.y+1, dst.x+1, dst.y+1);
	    	g.drawLine(dst.x, dst.y+1, dst.x, dst.y+1);
        }
	}
}
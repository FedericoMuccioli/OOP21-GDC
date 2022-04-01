package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import utility.Pair;

public class Resizer {
	
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Pair<Integer, Integer> Resize(final double factor){		
		int dimX=0;
	    int dimY=0;
		
		if(checkVertical()) {
			System.out.println("verticale");		
			dimX=(int) (screenSize.getWidth()/factor);
			dimY=(int) ((screenSize.getWidth()*16/9)/factor);	
		}else {		
			System.out.println("orizzontale");    	
			if(checkRatio()) {
				System.out.println("RatioCorretto 16/9");    	
				dimX=(int) (screenSize.getWidth()/factor);
				dimY=(int) (screenSize.getHeight()/factor);
			} else {
				System.out.println("RatioSbagliato != 16/9");  
				dimX=(int) ((screenSize.getHeight()*16/9)/factor);
				dimY=(int) (screenSize.getHeight()/factor);
			}	
		}	
		return new Pair<>(dimX,dimY);
	}

	private boolean checkRatio() {
		return(screenSize.getHeight()*(16/9)==screenSize.getWidth());
	}

	private boolean checkVertical() {
		return(screenSize.getWidth()<screenSize.getHeight());
	}	
}

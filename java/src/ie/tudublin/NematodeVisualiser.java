package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;


	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{

		}
		if (keyCode == RIGHT)
		{

		}		
	}
	

	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		minim = new Minim(this);
        
        ap = minim.loadFile("nucleya.mp3", 1024);
        ap.play();
        
		colorMode(HSB);
		
		background(0);
		smooth();
		loadNematodes();
		printNematodes();				
	}
	void printNematodes()
    {
        for(Nematode n:nematodes)
        {
            System.out.println(n);
        }
    }
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
            Nematode n = new Nematode(r);
            nematodes.add(n);
        }

	}


	public void draw()
	{	

	}
}

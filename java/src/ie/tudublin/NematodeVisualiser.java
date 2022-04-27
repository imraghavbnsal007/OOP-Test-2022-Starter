package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {
	ArrayList<Nematode> nematodes = new ArrayList<>();
	Minim minim;
	AudioPlayer ap;
	AudioInput ai;
	AudioBuffer ab;

	int mode = 0;
	float border = 10;
	float Rborder = 800 - border * 3.0f;
	float Lborder = border * 3.0f;
	Nematode PresentNem = null;
	float RadiusCircle = 40;

	// changes the
	public void keyPressed() {
		if (keyCode == LEFT) {
		}

		if (keyCode == RIGHT) {
		}
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
			if (ap.isPlaying()) {
				ap.pause();
			} else {
				ap.rewind();
				ap.play();
			}
		}
	}

	public void loadNematodes() {
		Table table = loadTable("nematodes.csv", "header");
		for (TableRow r : table.rows()) {
			Nematode s = new Nematode(r);
			nematodes.add(s);
		}
	}// end loading csv file function

	void printNematodes() {
		for (Nematode s : nematodes) {
			System.out.println(s);
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();
		printNematodes();
		minim = new Minim(this);

		ap = minim.loadFile("nucleya.mp3", 1024);
		ap.play();
	}

	public void draw() {
		drawArrow();
		stroke(0, 125, 255);
		strokeWeight(3);
		noFill();
		int halfW = 800 / 2;
		int halfH = 800 / 2;
		PresentNem = nematodes.get(0);
		for (int i = 0; i < PresentNem.getLength(); i++) {
			int offset = (int) (RadiusCircle * i);

			if (PresentNem.getLength() % 2 == 1) {
				circle(halfW, halfH - offset, RadiusCircle);
				circle(halfW, halfH + offset, RadiusCircle);

				// Limbs
				// Top segment limbs
				line(halfW + RadiusCircle / 2, halfH - offset, halfW + RadiusCircle, halfH - offset);
				line(halfW - RadiusCircle / 2, halfH - offset, halfW - RadiusCircle, halfH - offset);
				// line(halfW - RadiusCircle, halfH + RadiusCircle/2 - offset, halfW +
				// RadiusCircle, halfH + RadiusCircle/2 - offset);
				// Bottom segment limbs
				line(halfW + RadiusCircle / 2, halfH + offset, halfW + RadiusCircle, halfH + offset);
				line(halfW - RadiusCircle / 2, halfH + offset, halfW - RadiusCircle, halfH + offset);
			} else {
				circle(halfW, halfH + RadiusCircle / 2 - offset, RadiusCircle);
				circle(halfW, halfH - RadiusCircle / 2 + offset, RadiusCircle);
				// Top limbs
				line(halfW + RadiusCircle, halfH + RadiusCircle / 2 - offset, halfW + RadiusCircle,
						halfH + RadiusCircle / 2 - offset);
				line(halfW - RadiusCircle, halfH + RadiusCircle / 2 - offset, halfW - RadiusCircle,
						halfH + RadiusCircle / 2 - offset);
				// Bottom limbs
				line(halfW + RadiusCircle, halfH + RadiusCircle / 2 - offset, halfW + RadiusCircle,
						halfH + RadiusCircle / 2 - offset);
				line(halfW - RadiusCircle, halfH + RadiusCircle / 2 - offset, halfW - RadiusCircle,
						halfH + RadiusCircle / 2 - offset);

			}
			String gender = PresentNem.getGender();
			switch (gender) {
				case "m": {
					int y = (int) (halfH + (RadiusCircle / 2) * PresentNem.getLength());
					line(halfW, y, halfW, y + RadiusCircle / 2);
					y = (int) (y + 5 + RadiusCircle / 2);
					circle(halfW, y, 10);
					break;
				}
				case "f": {
					int y = (int) (halfH + (RadiusCircle / 2) * (PresentNem.getLength() - 1));
					circle(halfW, y, RadiusCircle / 2);
					break;
				}
				case "h": {
					int y = (int) (halfH + (RadiusCircle / 2) * PresentNem.getLength());
					line(halfW, y, halfW, y + RadiusCircle / 2);
					y = (int) (y + 5 + RadiusCircle / 2);
					circle(halfW, y, 10);
					y = (int) (halfH + (RadiusCircle / 2) * (PresentNem.getLength() - 1));
					circle(halfW, y, RadiusCircle / 2);
				}
			}
			fill(random(255), 255, 255);
			textSize(55);
			text("NEMATODE", 250, 100);

			textAlign(CORNER);
			textSize(20);
			String info = PresentNem.toString();
			text(info, border * 3.0f, height - border * 3.0f);
		}
	}

	public void drawArrow() {
		stroke(0, 155, 250);
		// arrows
		// right arrow
		line(Rborder, height / 2, Rborder - 90, height / 2);
		line(Rborder, height / 2, Rborder - 30, height / 2 - 20);
		line(Rborder, height / 2, Rborder - 30, height / 2 - 20);
		line(Rborder, height / 2, Rborder - 30, height / 2 + 20);

		// arrow left
		line(Lborder, height / 2, Lborder + 90, height / 2);
		line(Lborder, height / 2, Lborder + 30, height / 2 - 20);
		line(Lborder, height / 2, Lborder + 30, height / 2 + 20);
	}
}
package org.usfirst.frc3467.pid;

import java.util.Vector;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;

public class Input implements PIDSource {
	
	public static final int AVERAGE = 0;
	int type = 0;
	Vector list;
	
	public Input(int type) {
		this.type = type;
		list = new Vector();
	}
	
	public void addEncoder(Encoder enc) {
		list.addElement(enc);
	}
	
	public double pidGet() {
		switch (type) {
			case 0:
				int total = 0;
				for (int i = 0; i < list.size(); i++) {
					Encoder enc = (Encoder) list.elementAt(i);
					total += enc.getRaw();
				}
				return total / list.size();
			default:
				return 0;
		}
	}
}

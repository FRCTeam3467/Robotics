package org.usfirst.frc3467.other;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import javax.microedition.io.Connector;
import javax.microedition.io.InputConnection;

import com.sun.squawk.microedition.io.FileConnection;

public class FTC {
	PrintStream writer = null;
	FileConnection outputConnection;
	InputConnection inputConnection;
	DataOutputStream outputSteam;
	InputStream inputStream;
	String fileName = "";
	String file = "";
	
	public FTC(String file) {
		this.fileName = file;
	}
	
	public void appendToFile(String message) {
		try {
			try {
				outputConnection = (FileConnection) Connector.open(fileName, Connector.WRITE);
				outputConnection.create();
				outputSteam = outputConnection.openDataOutputStream();
				writer = new PrintStream(outputSteam);
			} catch (Exception e1) {
				System.out.println("Creating");
				e1.printStackTrace();
			}
			writer.println(message);
			try {
				writer.close();
				// outputSteam.close();
				// outputConnection.close();
			} catch (Exception e) {
				System.out.println("Closing");
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readFile() {
		file = "";
		try {
			int b;
			inputConnection = (InputConnection) Connector.open(fileName, Connector.READ);
			InputStream input = inputConnection.openDataInputStream();
			b = input.read();
			while (b != -1) {
				// System.out.print((char) b);
				file += (char) b;
				b = input.read();
			}
			if (inputStream != null)
				inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
}

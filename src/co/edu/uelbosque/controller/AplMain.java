package co.edu.uelbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AplMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

		Controller controlador = new Controller();

	}

}

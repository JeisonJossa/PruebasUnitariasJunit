package co.edu.uelbosque.test;

import co.edu.uelbosque.controller.Controller;
import co.edu.uelbosque.model.Vehiculo;
import junit.framework.TestCase;

public class ControllerTest extends TestCase{
	Controller control = new Controller();
	Vehiculo v1;
	Vehiculo v2;
	
	public void setupEscenario() {
		v1 = new Vehiculo("mazda", "trx123", 2, 5 , "automovil", "2015","normal");
		v2 = new Vehiculo("mazda", "frw173", 4, 4, "mini", "2019", "vendido");
	}
	
public void testCompararMarca() {
	setupEscenario();
	
	assertEquals("Deberian ser igual",1, control.compararMarca(v1, v2));
	//assertEquals("Son diferentes",-1, control.compararMarca(v1, v2));
}
	
}

package sumaNumeros.espe.edu.ec;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.DecimalFormat;

import sumaNumeros.espe.edu.ec.controler.Interface.IOPeraciones;
import sumaNumeros.espe.edu.ec.controler.Modelo.Operacion;
import sumaNumeros.espe.edu.ec.controler.Modelo.OperacionesModelo;
import sumaNumeros.espe.edu.ec.controler.Presentador.OperacionesPresentador;
import sumaNumeros.espe.edu.ec.controler.Vista.OperacionesVista;

import static org.junit.Assert.*;

public class OperacionTest {
    private Operacion operacion;
    private static final double DELTA = 1e-2;
    @Before
    public void setUp(){
        operacion = new Operacion(Float.parseFloat("21.5"),Float.parseFloat("0.56"));
    }
    @Test
    public void operacionNotNUll() {
        assertNotNull(operacion);
    }

    @Test
    public void sumar() {

        assertEquals(  22.06,operacion.sumar(),DELTA);
    }

    @Test
    public void resstar() {
        assertEquals(20.94,operacion.resstar(),DELTA);
    }

    @Test
    public void multiplicar() {
        assertEquals(12.04,operacion.multiplicar(),DELTA);
    }

    @Test
    public void dividir() {
        assertEquals(38.39,operacion.dividir(),DELTA);
    }
    @Test
    public void sumarF() {

        assertNotEquals(  221.06,operacion.sumar(),DELTA);
    }

    @Test
    public void resstarF() {
        assertNotEquals(201.94,operacion.resstar(),DELTA);
    }

    @Test
    public void multiplicarF() {
        assertNotEquals(121.04,operacion.multiplicar(),DELTA);
    }

    @Test
    public void dividirF() {
        assertNotEquals(381.39,operacion.dividir(),DELTA);
    }
    @Test
    public void nulo() {
        Operacion operacionP = new Operacion(0,0);
        assertTrue(Double.isNaN(operacionP.dividir()));
    }
}
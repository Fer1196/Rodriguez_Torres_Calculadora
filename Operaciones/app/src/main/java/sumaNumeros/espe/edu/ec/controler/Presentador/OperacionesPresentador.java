package sumaNumeros.espe.edu.ec.controler.Presentador;

import sumaNumeros.espe.edu.ec.controler.Interface.IOPeraciones;
import sumaNumeros.espe.edu.ec.controler.Modelo.Operacion;
import sumaNumeros.espe.edu.ec.controler.Modelo.OperacionesModelo;

public class OperacionesPresentador implements IOPeraciones.Presentador {
    private IOPeraciones.Vista vista;
    private  IOPeraciones.Modelo modelo;
    public OperacionesPresentador (IOPeraciones.Vista view) {
        this.vista = view;
        this.modelo = new OperacionesModelo(this);
    }
    @Override
    public void resultado(String resultado) {
        if (this.vista != null){
            this.vista.resultado(resultado);
        }
    }

    @Override
    public void operar(String n1, String n2, String operacion) {
        if (vista != null){
            this.modelo.operar(n1,n2, operacion);
        }
    }
}

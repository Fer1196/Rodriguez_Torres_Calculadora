package sumaNumeros.espe.edu.ec.controler.Interface;

import sumaNumeros.espe.edu.ec.controler.Modelo.Operacion;

public interface IOPeraciones {
    interface Vista{
        void resultado(String resultado);
    }
    interface Presentador{
        void resultado(String resultado);
        void operar(String n1, String n2, String operacion);
    }
    interface Modelo{
        void operar(String n1, String n2, String operacion);
    }
}

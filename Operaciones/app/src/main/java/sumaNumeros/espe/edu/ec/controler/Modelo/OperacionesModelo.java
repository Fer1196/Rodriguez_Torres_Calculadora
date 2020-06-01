package sumaNumeros.espe.edu.ec.controler.Modelo;

import sumaNumeros.espe.edu.ec.controler.Interface.IOPeraciones;
import sumaNumeros.espe.edu.ec.controler.Presentador.OperacionesPresentador;

public class OperacionesModelo implements IOPeraciones.Modelo {
    private IOPeraciones.Presentador presentador;
    public OperacionesModelo(IOPeraciones.Presentador presentador){
        this.presentador = presentador;
    }
    @Override
    public void operar(String n1, String n2, String operacion) {
        Operacion operar = new Operacion(Double.parseDouble (n1), Double.parseDouble (n2));
        try{
            switch (operacion){
                case "+":
                    this.presentador.resultado(operar.sumar()+"");
                    break;
                case "-":
                    this.presentador.resultado(operar.resstar()+"");
                    break;
                case "*":
                    this.presentador.resultado(operar.multiplicar()+"");
                    break;
                case "/":
                        this.presentador.resultado(operar.dividir()+"");
                        break;
            }
        }
        catch (Exception e){
            this.presentador.resultado(e.getMessage());
        }

    }
}

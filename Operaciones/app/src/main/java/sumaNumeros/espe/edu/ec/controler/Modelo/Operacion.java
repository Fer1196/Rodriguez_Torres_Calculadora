package sumaNumeros.espe.edu.ec.controler.Modelo;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class Operacion {
    private double N1;
    private double N2;
    DecimalFormat twoDForm;


    /**
     * @param n1 parametro de tipo double
     * @param n2 parametro de tipo double
     *  Constructor Operacion
     */
    public Operacion(double n1, double n2) {
        this.N1 = n1;
        this.N2 = n2;
        this.twoDForm = new DecimalFormat("#.##");
    }


    /**
     * Constuctor Operacion vacio
     */
    public Operacion() {

    }


    /**
     * @return un double con el valor de N1
     */
    public double getN1() {
        return N1;
    }


    /**
     * @param n1 parametro de tipo float
     * Funcion para asignar un valor a N1
     */
    public void setN1(float n1) {
        N1 = n1;
    }


    /**
     * @return un double con el valor de N2
     */
    public double getN2() {
        return N2;
    }


    /**
     * @param n2 parametro de tipo float
     * Funcion para asignar un valor a N2
     */
    public void setN2(float n2) {
        N2 = n2;
    }


    /**
     * @param txt de tipo TextInputLayout
     * @return false si tiene un formato erroneo y true si cumple con todos los parametros como ser numero
     * y no contener caracteres especiales
     * Funcion para determinar si el campo no esta vacio o contiene caracteres especiales
     */
    public boolean validar(TextInputLayout txt){
        if(txt.getEditText().getText().length()==0){
            txt.setErrorEnabled(true);
            txt.requestFocus();
            txt.getEditText().setError("Campo Obligatorio");
            txt.requestFocus();
            return false;
        }
        return true;
    }


    /**
     * @return double de la suma de de los 2 numeros
     * Funcion que suma dos numeros
     */
    public double sumar(){
        return Double.valueOf(twoDForm.format(this.N1 + this.N2));
    }

    /**
     * @return double de la resta de 2 numeros
     * Funcion que resta 2 numeros
     */
    public double resstar(){
        return Double.valueOf(twoDForm.format(this.N1 - this.N2));
    }

    /**
     * @return double de la multiplicacion de 2 numeros
     * Funcion que multiplica 2 numeros
     */
    public double multiplicar(){

        return Double.valueOf(twoDForm.format(this.N1 * this.N2));
    }

    /**
     * @return double de la division de 2 numeros
     * Funcion que divide 2 numeros
     */
    public double dividir(){
        try{
            return Double.valueOf(twoDForm.format(this.N1 / this.N2));
        }
        catch (Exception e){
            throw e;
        }
    }
}

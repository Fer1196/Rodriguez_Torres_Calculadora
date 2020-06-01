package sumaNumeros.espe.edu.ec.controler.Modelo;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class Operacion {
    private double N1;
    private double N2;
    DecimalFormat twoDForm;
    public Operacion(double n1, double n2) {
        this.N1 = n1;
        this.N2 = n2;
        this.twoDForm = new DecimalFormat("#.##");
    }
    public Operacion() {

    }
    public double getN1() {
        return N1;
    }

    public void setN1(float n1) {
        N1 = n1;
    }

    public double getN2() {
        return N2;
    }

    public void setN2(float n2) {
        N2 = n2;
    }
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
    public double sumar(){
        return Double.valueOf(twoDForm.format(this.N1 + this.N2));
    }
    public double resstar(){
        return Double.valueOf(twoDForm.format(this.N1 - this.N2));
    }
    public double multiplicar(){

        return Double.valueOf(twoDForm.format(this.N1 * this.N2));
    }
    public double dividir(){
        try{
            return Double.valueOf(twoDForm.format(this.N1 / this.N2));
        }
        catch (Exception e){
            throw e;
        }
    }
}

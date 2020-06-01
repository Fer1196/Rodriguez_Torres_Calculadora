package sumaNumeros.espe.edu.ec.controler.Vista;

import androidx.appcompat.app.AppCompatActivity;
import sumaNumeros.espe.edu.ec.R;
import sumaNumeros.espe.edu.ec.controler.Interface.IOPeraciones;
import sumaNumeros.espe.edu.ec.controler.Presentador.OperacionesPresentador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class OperacionesVista extends AppCompatActivity implements View.OnClickListener, IOPeraciones.Vista, BottonSheetOperaciones.BottomSheetListner {
    private Button btnOperation;
    private TextInputLayout txtN1;
    private TextInputLayout txtN2;
    private IOPeraciones.Presentador presentador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnOperation = (Button) findViewById(R.id.btnSumar);
        this.btnOperation.setOnClickListener(this);
        this.txtN1 = (TextInputLayout) findViewById(R.id.txtN1);
        this.txtN2 = (TextInputLayout) findViewById(R.id.txtN2);
        presentador = new OperacionesPresentador(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSumar:
                if(this.validar(txtN1) && this.validar(txtN2)){
                    BottonSheetOperaciones bottomSheet = new BottonSheetOperaciones();
                    bottomSheet.show(getSupportFragmentManager(), "Operaciones");
                }
                break;
        }
    }


    /**
     * Funcion tipo void()
     * Limpia las dos cajas de textas
     */
    public void limpiarData(){
        this.txtN1.getEditText().setText("");
        this.txtN2.getEditText().setText("");
        this.txtN1.getEditText().getBackground().clearColorFilter();
        this.txtN2.getEditText().getBackground().clearColorFilter();
        this.txtN2.clearFocus();
        this.txtN1.clearFocus();

    }


    /**
     * @param txt parametro de un textbox, valida que la caja no este vacia y contenga un valor valido
     * @return true si el valor es valido y false si esta nulo
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

    @Override
    public void resultado(String resultado) {
        Toast notificacion =
                Toast.makeText(getApplicationContext(),
                        "El resultado es: ".concat(resultado), Toast.LENGTH_SHORT);

        notificacion.show();
        limpiarData();
    }

    @Override
    public void onButtonClicked(String operacion) {
        this.presentador.operar(txtN1.getEditText().getText().toString(), txtN2.getEditText().getText().toString(), operacion);
    }
}

package sumaNumeros.espe.edu.ec.controler.Vista;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sumaNumeros.espe.edu.ec.R;

public class BottonSheetOperaciones extends BottomSheetDialogFragment {
    private BottomSheetListner mListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.botton_sheet_operation, container, false);
        Button btnSumar = v.findViewById(R.id.btnSSUMAR);
        Button btnRestar = v.findViewById(R.id.btnSRestar);
        Button btnMultiplicar = v.findViewById(R.id.btnSMultiplicar);
        Button btnDividir = v.findViewById(R.id.btnSDividir);
        btnSumar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnSSUMAR:
                            mListener.onButtonClicked("+");
                            dismiss();
                        break;
                }
            }
        });
        btnRestar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnSRestar:
                        mListener.onButtonClicked("-");
                        dismiss();
                        break;
                }
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnSMultiplicar:
                        mListener.onButtonClicked("*");
                        dismiss();
                        break;
                }
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnSDividir:
                        mListener.onButtonClicked("/");
                        dismiss();
                        break;
                }
            }
        });
        return  v;
    }
    public interface BottomSheetListner{
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (BottomSheetListner) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ " DEBE IMPLEMENTAR EL BOTTONSHEETLISTENER");
        }

    }
}

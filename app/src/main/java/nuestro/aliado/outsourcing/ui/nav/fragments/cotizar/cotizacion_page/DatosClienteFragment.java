package nuestro.aliado.outsourcing.ui.nav.fragments.cotizar.cotizacion_page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import nuestro.aliado.outsourcing.R;
import nuestro.aliado.outsourcing.classes.Utils;

public class DatosClienteFragment extends Fragment {

    //ui
    protected EditText inputName;
    protected EditText inputPhone;
    protected EditText inputEmail;
    protected EditText inputCompany;
    protected EditText inputDescription;

    protected Button btnNext;

    //init instance view
    public static DatosClienteFragment newInstance() {
        return new DatosClienteFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_datos_cliente, container, false);

        //init ui
        inputName = (EditText) rootView.findViewById(R.id.inputName);
        inputPhone = (EditText) rootView.findViewById(R.id.inputPhone);
        inputEmail = (EditText) rootView.findViewById(R.id.inputEmail);
        inputCompany = (EditText) rootView.findViewById(R.id.inputCompany);
        inputDescription = (EditText) rootView.findViewById(R.id.inputDescription);

        btnNext = (Button) rootView.findViewById(R.id.btnNext);

        //events of view
        configureEvents();

        return rootView;
    }

    //events in View
    protected void configureEvents() {

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validateFields()) return;
                //change page
            }
        });
    }

    //check if fields is not empty
    protected boolean validateFields() {
        String inputNameValue = inputName.getText().toString();
        String inputEmailValue = inputEmail.getText().toString();

        boolean isError = false;

        //clear error in fields
        clearError();

        if(Utils.isEmpty(inputNameValue)){
            isError = true;
            inputName.setError(getString(R.string.error_campo_requerido));
        }

        if(Utils.isEmpty(inputEmailValue)){
            isError = true;
            inputEmail.setError(getString(R.string.error_campo_requerido));
        }else if(!Utils.isValidEmail(inputEmailValue)){
            isError = true;
            inputEmail.setError(getString(R.string.error_email_invalido));
        }

        return isError;
    }

    protected void clearError(){
        inputName.setError(null);
        inputEmail.setError(null);
    }
}

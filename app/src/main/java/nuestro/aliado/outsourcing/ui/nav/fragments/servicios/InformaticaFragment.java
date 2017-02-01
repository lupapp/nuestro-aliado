package nuestro.aliado.outsourcing.ui.nav.fragments.servicios;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class InformaticaFragment extends Fragment {

    public static InformaticaFragment newInstance() {
        return new InformaticaFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_informatica, container, false);
        return rootView;
    }
}

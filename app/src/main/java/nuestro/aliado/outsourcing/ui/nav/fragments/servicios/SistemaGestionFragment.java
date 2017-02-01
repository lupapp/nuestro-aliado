package nuestro.aliado.outsourcing.ui.nav.fragments.servicios;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class SistemaGestionFragment extends Fragment {
    public static SistemaGestionFragment newInstance() {
        return new SistemaGestionFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gestion, container, false);

        return rootView;
    }
}

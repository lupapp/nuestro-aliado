package nuestro.aliado.outsourcing.ui.nav.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class VerCotizacionFragment extends Fragment {

    public static VerCotizacionFragment newInstance() {
        return new VerCotizacionFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ver_cotizacion, container, false);

        return rootView;
    }
}

package nuestro.aliado.outsourcing.ui.nav.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;


public class ServiciosFragment   extends Fragment {

    public static ServiciosFragment newInstance() {
        return new ServiciosFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_servicios, container, false);

        return rootView;
    }
}

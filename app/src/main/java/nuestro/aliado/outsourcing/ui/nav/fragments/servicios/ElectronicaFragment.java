package nuestro.aliado.outsourcing.ui.nav.fragments.servicios;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class ElectronicaFragment extends Fragment {
    public static ElectronicaFragment newInstance() {
        return new ElectronicaFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_electronica, container, false);

        return rootView;
    }
}

package nuestro.aliado.outsourcing.ui.nav.fragments.servicios;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class ElectricaFragment extends Fragment {

    public static ElectricaFragment newInstance() {
        return new ElectricaFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_electrica, container, false);

        return rootView;
    }
}

package nuestro.aliado.outsourcing.ui.nav.fragments.cotizar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class VisitaFragment extends Fragment {

    public static VisitaFragment newInstance() { return new VisitaFragment();}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_visita, container, false);

        return rootView;
    }
}

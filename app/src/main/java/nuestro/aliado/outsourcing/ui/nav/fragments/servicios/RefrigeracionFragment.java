package nuestro.aliado.outsourcing.ui.nav.fragments.servicios;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nuestro.aliado.outsourcing.R;

public class RefrigeracionFragment extends Fragment {
    public static RefrigeracionFragment newInstance() {
        return new RefrigeracionFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_refrigeracion, container, false);

        return rootView;
    }
}

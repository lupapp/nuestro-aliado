package nuestro.aliado.outsourcing.ui.nav.fragments.cotizar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nuestro.aliado.outsourcing.R;
import nuestro.aliado.outsourcing.ui.adapters.PageAdapter;
import nuestro.aliado.outsourcing.ui.nav.fragments.cotizar.cotizacion_page.DatosClienteFragment;

public class CotizacionFragment extends Fragment {

    //UI
    protected ViewPager viewPager;

    //adapter
    protected PageAdapter pageAdapter;


    public static CotizacionFragment newInstance() {
        return new CotizacionFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cotizar, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        pageAdapter = new PageAdapter(getChildFragmentManager());
        viewPager.setAdapter(pageAdapter);

        //loads fragments in view
        setFragments();

        return rootView;
    }

    protected void setFragments(){
        //this list add fragments
        ArrayList<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(DatosClienteFragment.newInstance());

        pageAdapter.clear();
        pageAdapter.setList(fragmentList);
        pageAdapter.notifyDataSetChanged();
    }

}

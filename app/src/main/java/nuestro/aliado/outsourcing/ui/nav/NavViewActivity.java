package nuestro.aliado.outsourcing.ui.nav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nuestro.aliado.outsourcing.R;
import nuestro.aliado.outsourcing.classes.Constants;
import nuestro.aliado.outsourcing.classes.Utils;
import nuestro.aliado.outsourcing.ui.adapters.PageAdapter;
import nuestro.aliado.outsourcing.ui.nav.fragments.cotizar.CotizacionFragment;
import nuestro.aliado.outsourcing.ui.nav.fragments.cotizar.VisitaFragment;
import nuestro.aliado.outsourcing.ui.nav.fragments.servicios.ElectricaFragment;
import nuestro.aliado.outsourcing.ui.nav.fragments.servicios.ElectronicaFragment;
import nuestro.aliado.outsourcing.ui.nav.fragments.servicios.InformaticaFragment;
import nuestro.aliado.outsourcing.ui.nav.fragments.servicios.RefrigeracionFragment;
import nuestro.aliado.outsourcing.ui.nav.fragments.servicios.SistemaGestionFragment;

public class NavViewActivity extends AppCompatActivity{

    //ui
    protected DrawerLayout drawer;
    protected Toolbar toolbar;
    protected NavigationView navigationView;
    protected AppBarLayout appBarLayout;
    protected ViewPager viewPager;

    //adapter
    protected PageAdapter pageAdapter;

    //FRAGMENTS
    protected static final String COTIZAR_FRAGMENT = "cotizar";
    protected static final String SERVICIOS_FRAGMENT = "servicios";
    protected static final String VER_COTIZACIONES_FRAGMENT = "ver_cotizaciones";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_view);

        //configure Toolbar Section
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //hidde toolbar bootom
        if(getSupportActionBar()!= null)getSupportActionBar().setDisplayShowTitleEnabled(false);

        //init drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //init navigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //add instance  appBarLayout
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);

        //create viepage
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        //configure  init activity
        if(getIntent() != null && getIntent().getExtras() != null){

            Bundle bundle = getIntent().getExtras();
            int action = bundle.getInt("action",0);

            switch (action){
                case Constants.ACTION_SERVICIOS :
                    navigationView.getMenu().getItem(1).setChecked(true);
                    setFragments(SERVICIOS_FRAGMENT);
                    break;
                case Constants.ACTION_COTIZAR :
                    navigationView.getMenu().getItem(0).setChecked(true);
                    setFragments(COTIZAR_FRAGMENT);
                    break;
                case Constants.ACTION_VER_COTIZACION :
                    navigationView.getMenu().getItem(2).setChecked(true);
                    setFragments(VER_COTIZACIONES_FRAGMENT);
                    break;
                default:
                    setFragments(COTIZAR_FRAGMENT);
                    break;
            }
        }else{
            navigationView.getMenu().getItem(0).setChecked(true);
            setFragments(COTIZAR_FRAGMENT);
        }

        //init  menu drawer
        configureEvents();
    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    protected void setFragments(String view){
        //this list add fragments
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //this lista add tabs  name
        ArrayList<String> tabsName = new ArrayList<>();

       switch (view){
           case COTIZAR_FRAGMENT:
               //add fragments to view
               fragmentList.add(CotizacionFragment.newInstance());
               fragmentList.add(VisitaFragment.newInstance());
               //add name  tabs for view
               tabsName.add(getString(R.string.tab_cotizacion));
               tabsName.add(getString(R.string.tab_visita));
               break;

           case SERVICIOS_FRAGMENT:
               //add fragments to view
               fragmentList.add(InformaticaFragment.newInstance());
               fragmentList.add(ElectronicaFragment.newInstance());
               fragmentList.add(ElectricaFragment.newInstance());
               fragmentList.add(RefrigeracionFragment.newInstance());
               fragmentList.add(SistemaGestionFragment.newInstance());

               //listo
               //add name  tabs for view
               tabsName.add("Informática");
               tabsName.add("Electrónica");
               tabsName.add("Eléctrica");
               tabsName.add("Refrigeración");
               tabsName.add("Gestión");

               break;

           case VER_COTIZACIONES_FRAGMENT:
               break;
       }

        pageAdapter.clear();
        pageAdapter.setList(fragmentList);
        pageAdapter.notifyDataSetChanged();

        //create tab bar
        createTabBar(view, tabsName);
    }

    protected void configureEvents() {
        //drawer event
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NavigationView Events
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean isFound = false;
                switch (item.getItemId()) {
                    case R.id.cotizar:
                        isFound = true;
                        setFragments(COTIZAR_FRAGMENT);
                        break;
                    case R.id.servicios:
                        isFound = true;
                        setFragments(SERVICIOS_FRAGMENT);
                        break;
                    case R.id.ver_cotizaciones:
                        isFound = true;
                        setFragments(VER_COTIZACIONES_FRAGMENT);
                        break;
                }

                drawer.closeDrawer(GravityCompat.START);

                return isFound;
            }
        });
    }

    protected void createTabBar(String view,  ArrayList<String> tabsName){

        for(int i= 0; i < appBarLayout.getChildCount(); i++){
            //remove tab layout
            if(appBarLayout.getChildAt(i) instanceof TabLayout){
                appBarLayout.removeViewAt(i);
                break;
            }
        }

        //check if page exist
        if(tabsName.size() == 0) return;

        //params tab
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.getDp(this, 40));
        //create tabs layout
        TabLayout tabs = new TabLayout(this);
        //adjuts tab indicator
        tabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorBlueLigth));
        tabs.setSelectedTabIndicatorHeight(Utils.getDp(this, 5));

        switch (view){
            case COTIZAR_FRAGMENT:
                //set gravity
                tabs.setTabGravity(TabLayout.GRAVITY_FILL);
                //set mode tabs
                tabs.setTabMode(TabLayout.MODE_FIXED);
                break;
            case SERVICIOS_FRAGMENT:
                //here all services
                tabs.setTabGravity(TabLayout.GRAVITY_CENTER);
                //set mode tabs
                tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
                break;

            case VER_COTIZACIONES_FRAGMENT:
                //set gravity
                tabs.setTabGravity(TabLayout.GRAVITY_FILL);
                //set mode tabs
                tabs.setTabMode(TabLayout.MODE_FIXED);
                break;
        }

        //set  params of view
        tabs.setLayoutParams(params);

        //passing viewpage
        tabs.setupWithViewPager(viewPager);

        //add view
        appBarLayout.addView(tabs);

        //add tabs
        setTabs(tabs, tabsName);
    }

    protected void setTabs(TabLayout tabs, ArrayList<String> tabsName){

        int pos = 0;

        for(String str: tabsName){
            //custom tap widget
            TextView customtab = new TextView(this);

            customtab.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
            customtab.setTextSize(16f);
            customtab.setGravity(Gravity.CENTER);
            customtab.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlueNormal));

            customtab.setText(str);

            tabs.getTabAt(pos).setCustomView(customtab);

            pos++;
        }

    }
}

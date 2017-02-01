package nuestro.aliado.outsourcing.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nuestro.aliado.outsourcing.R;
import nuestro.aliado.outsourcing.classes.Constants;
import nuestro.aliado.outsourcing.ui.nav.NavViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed(){
       finish();
    }

    /**
     * events in menu buttons
     */
    public void doClickServicios(View v){
        attempAction(Constants.ACTION_SERVICIOS);
    }

    public void doClickCotizar(View v){
        attempAction(Constants.ACTION_COTIZAR);
    }

    public void doClickVerCotizacion(View v){
        attempAction(Constants.ACTION_VER_COTIZACION);
    }

    //got to nav view

    protected void attempAction(int code_action){

        //create bundle for  send  params to nex activity
        Bundle bundle = new Bundle();
        bundle.putInt("action", code_action);

        //  create  intent for  change activities
        Intent i = new Intent(MainActivity.this, NavViewActivity.class);
        // add params  to  send view
        i.putExtras(bundle);
        //go to activity
        startActivity(i);
        finish();
    }
}

package owl.app.elsalmon.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import owl.app.elsalmon.R;
import owl.app.elsalmon.email.Config;
import owl.app.elsalmon.fragments.GaleriaFragment;
import owl.app.elsalmon.fragments.MenuPrincipalFragment;
import owl.app.elsalmon.fragments.OwlFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        FragmentPorDefault();
    }

    private void setToolbar() {
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.salmon);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pescaderia Salmón");
    }

    private void FragmentPorDefault() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new MenuPrincipalFragment())
                //la linea de abajo es para poder volver al fragment
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportActionBar().setTitle("Pescaderia Salmón");
        if(Config.Boolean){
            finish();
        }
        Config.Boolean = true;
    }

    //Aqui hemos inflado el action bar en nuestro layout principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.owl, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.owl:
                //nos lleva al fragment de login
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, new OwlFragment())
                        //la linea de abajo es para poder volver al fragment
                        .addToBackStack(null)
                        .commit();
                Config.Boolean = false;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

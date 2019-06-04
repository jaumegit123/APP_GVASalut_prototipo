package com.jaumemiralles.gvasalut_datospersonales3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** El adaptador de los fragmentos */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /** El controlador de las pestanyas/secciones */
    private ViewPager mViewPager;

    /** Los botones para volver hacía atrás y el teléfono */
    private ImageButton btnBack;
    private ImageButton btnTlf;

    /** Título de la actividad (toolbar) y estado */
    private TextView nombreCompleto;
    private TextView tEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Creamos el adaptador que retornará un fragmento para cada sección
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Configuramos el ViewPager con el adaptador de secciones
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        btnBack = findViewById(R.id.btn_back);
        btnTlf = findViewById(R.id.btn_tlf);

        // Acción de los botones
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Acció de tornar enrere.", Snackbar.LENGTH_LONG).show();
            }
        });

        btnTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Ring riiiing", Snackbar.LENGTH_LONG).show();
            }
        });

        // Personalizamos el título y la barra de estado
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nombreCompleto = findViewById(R.id.tvNombreCompleto);
        nombreCompleto.setText("África Ortega Marín");

        tEstado = findViewById(R.id.tvEstado);
        tEstado.setText("DE ALTA");

        //tEstado.setText("DE BAJA");
        //tEstado.setTextColor(Color.parseColor("#CD5C5C"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Aquí anejamos los clics del elemento de la barra de acción
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Aquí creamos nuestro adaptador personalizado para que nos
     *  devuelva el fragmento correspondiente */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private int N_TABS = 2; // En total 2 pestanyas

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return FragmentDatos.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return N_TABS;
        }
    }
}

package com.jaumemiralles.gvasalut_datospersonales3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDatos extends Fragment {

    private static String ARG_PLACEHOLDER = "com.jaumemiralles.gvasalut_datospersonales3.TAB";

    // Datos personales y sanitarios
    private TextView tNombre;
    private TextView tApe1;
    private TextView tApe2;
    private TextView tDni;
    private TextView tFechaNac;
    private TextView tPasaporte;
    private TextView tDomicilio;
    private TextView tDir1;
    private TextView tDir2;
    private TextView tDir3;
    private TextView tDirTemp;
    private TextView tTelf;
    private TextView t11;
    private TextView t12;
    private TextView t13;
    private TextView t14;
    private TextView tTitlBenf;
    private TextView tNSS;
    private TextView tEmpadr;
    private TextView tAportFarm;

    // Buzón de Notificaciones

    public static FragmentDatos newInstance(int sectionNumber) {
        FragmentDatos fragment = new FragmentDatos();
        Bundle args = new Bundle();
        args.putInt(ARG_PLACEHOLDER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View layout = null;

        switch(getArguments().getInt(ARG_PLACEHOLDER)){
            case 1:
                layout = inflater.inflate(R.layout.fragment_datos_personales, container, false);

                // Sincronizamos los componentes necesarios
                tNombre = layout.findViewById(R.id.tvNombre);
                tApe1 = layout.findViewById(R.id.tvApe1);
                tApe2 = layout.findViewById(R.id.tvApe2);
                tDni = layout.findViewById(R.id.tvDni);
                tFechaNac = layout.findViewById(R.id.tvFechaNac);
                tPasaporte = layout.findViewById(R.id.tvPasaporte);

                tDomicilio = layout.findViewById(R.id.tvDomicilio);
                tDir1 = layout.findViewById(R.id.tvDir1);
                tDir2 = layout.findViewById(R.id.tvDir2);
                tDir3 = layout.findViewById(R.id.tvDir3);
                tDirTemp = layout.findViewById(R.id.tvDirTemp);
                tTelf = layout.findViewById(R.id.tvTelf);

                t11 = layout.findViewById(R.id.textView11);
                t12 = layout.findViewById(R.id.textView12);
                t13 = layout.findViewById(R.id.textView13);
                t14 = layout.findViewById(R.id.textView14);

                // Los cargamos
                tNombre.setText("África");
                tApe1.setText("Ortega");
                tApe2.setText("Marín");
                tFechaNac.setText("16-04-1989");
                tDni.setText("12345678A");
                tPasaporte.setText("87654321B");
                tDomicilio.setText("Calle Buena Ventura nº1, Puerta 10, Valencia, Valencia, 46001");
                tDir1.setText("...");
                tDir2.setText("...");
                tDir3.setText("...");
                tDirTemp.setText("...");
                tTelf.setText("966666666 / 611111111");

                // En caso de no haber direcciones adicionales, las ocultamos
                t11.setVisibility(View.GONE);
                t12.setVisibility(View.GONE);
                t13.setVisibility(View.GONE);
                t14.setVisibility(View.GONE);
                tDir1.setVisibility(View.GONE);
                tDir2.setVisibility(View.GONE);
                tDir3.setVisibility(View.GONE);
                tDirTemp.setVisibility(View.GONE);

                tTitlBenf = layout.findViewById(R.id.tvTitlBenf);
                tNSS = layout.findViewById(R.id.tvNSS);
                tEmpadr = layout.findViewById(R.id.tvEmpadr);
                tAportFarm = layout.findViewById(R.id.tvAportFarm);

                tTitlBenf.setText("Titular");
                tNSS.setText("46/00000000/11");
                tEmpadr.setText("Si");
                tAportFarm.setText("AC-40%");
                break;
            case 2:
                layout = inflater.inflate(R.layout.fragment_notificaciones, container, false);
                break;
        }

        return layout;
    }

}

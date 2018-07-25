package com.example.christianxavier.agbrbucaramangapilotos.controlador;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.christianxavier.agbrbucaramangapilotos.R;

/**
 * Created by christianxavier on 20/07/2017.
 */

public class MensualidadHolder extends RecyclerView.ViewHolder {

    private View view;

    public MensualidadHolder(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void setNombres(String nombres) {
        TextView tv = (TextView)view.findViewById(R.id.nombreM);
        tv.setText(nombres);
    }

    public void setApodo(String apodo) {
        TextView tv = (TextView)view.findViewById(R.id.apodoM);
        tv.setText(apodo);
    }

    public void setCodigo(String codigo) {
        TextView tv = (TextView)view.findViewById(R.id.codigoM);
        tv.setText(codigo);
    }

    public void setEstado(String estado) {
        TextView tv = (TextView)view.findViewById(R.id.estadoM);
        tv.setText(estado);
    }

    public void setFallas(String fallas) {
        TextView tv = (TextView)view.findViewById(R.id.fallasM);
        tv.setText(fallas);
    }

    public void setMes(String mes) {
        TextView tv = (TextView)view.findViewById(R.id.mesM);
        tv.setText(mes);
    }

    public void setFalla1(String falla1) {
        TextView tv = (TextView)view.findViewById(R.id.falla1);
        tv.setText(falla1);
    }

    public void setFalla2(String falla2) {
        TextView tv = (TextView)view.findViewById(R.id.falla2);
        tv.setText(falla2);
    }

    public void setFalla3(String falla3) {
        TextView tv = (TextView)view.findViewById(R.id.falla3);
        tv.setText(falla3);
    }

    public void setOtros(String otros) {
        TextView tv = (TextView)view.findViewById(R.id.otrosM);
        tv.setText(otros);
    }
}

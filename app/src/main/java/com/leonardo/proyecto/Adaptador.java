package com.leonardo.proyecto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.leonardo.proyecto.modelo.Clima;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context contexto;
    private ArrayList<Clima> listItems;

    public Adaptador(Context contexto, ArrayList<Clima> listItems) {
        this.contexto = contexto;
        this.listItems = listItems;
    }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}

package com.example.colorsrgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        TextView red = view.findViewById(R.id.tv_v_cc_Red);
        TextView green = view.findViewById(R.id.tv_v_cc_green);
        TextView blue = view.findViewById(R.id.tv_v_cc_blue);
        TextView hex = view.findViewById(R.id.tv_v_cc_hex);
        TextView red_c = view.findViewById(R.id.tv_c_cc_red);
        TextView green_c = view.findViewById(R.id.tv_c_cc_green);
        TextView blue_c = view.findViewById(R.id.tv_c_cc_blue);
        TextView hex_c = view.findViewById(R.id.tv_c_cc_hex);

        ColorInfo col = listOfColors.get(i);

        red.setText(Integer.toString(col.getRed()));
        green.setText(Integer.toString(col.getGreen()));
        blue.setText(Integer.toString(col.getBlue()));
        hex.setText(col.getHex().toUpperCase());
        view.setBackgroundColor(Color.rgb(col.getRed(),col.getGreen(),col.getBlue()));

        //half of 255*3 is ~382
        if(col.getBlue()+col.getGreen()+col.getRed() >= 383) //If I had more time I would probably find a better way to do this but this works for now
        {
            hex.setTextColor(Color.rgb(0,0,0));
            red.setTextColor(Color.rgb(0,0,0));
            green.setTextColor(Color.rgb(0,0,0));
            blue.setTextColor(Color.rgb(0,0,0));
            hex_c.setTextColor(Color.rgb(0,0,0));
            red_c.setTextColor(Color.rgb(0,0,0));
            green_c.setTextColor(Color.rgb(0,0,0));
            blue_c.setTextColor(Color.rgb(0,0,0));
        }
        else {
            hex.setTextColor(Color.rgb(255,255,255));
            red.setTextColor(Color.rgb(255,255,255));
            green.setTextColor(Color.rgb(255,255,255));
            blue.setTextColor(Color.rgb(255,255,255));
            hex_c.setTextColor(Color.rgb(255,255,255));
            red_c.setTextColor(Color.rgb(255,255,255));
            green_c.setTextColor(Color.rgb(255,255,255));
            blue_c.setTextColor(Color.rgb(255,255,255));
        }

        return view;
    }
}

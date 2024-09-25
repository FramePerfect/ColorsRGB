package com.example.colorsrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_save_color;
    TextView lbl_red_dyn;
    TextView lbl_green_dyn;
    TextView lbl_blue_dyn;
    TextView lbl_hex_dyn;
    TextView lbl_red_const;
    TextView lbl_green_const;
    TextView lbl_blue_const;
    TextView lbl_hex_const;
    ListView lv_color_list;
    SeekBar sb_red;
    SeekBar sb_green;
    SeekBar sb_blue;

    ArrayList<ColorInfo> listOfColors;

    ColorListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_save_color = findViewById(R.id.btn_save_color);
        lbl_red_dyn = findViewById(R.id.lbl_red_dyn);
        lbl_green_dyn = findViewById(R.id.lbl_green_dyn);
        lbl_blue_dyn = findViewById(R.id.lbl_blue_dyn);
        lbl_hex_dyn = findViewById(R.id.lbl_hex_dyn);
        lbl_red_const = findViewById(R.id.lbl_red_const);
        lbl_green_const = findViewById(R.id.lbl_green_const);
        lbl_blue_const = findViewById(R.id.lbl_blue_const);
        lbl_hex_const = findViewById(R.id.lbl_hex_const);
        lv_color_list = findViewById(R.id.lv_color_list);
        sb_blue = findViewById(R.id.sb_blue);
        sb_red = findViewById(R.id.sb_red);
        sb_green = findViewById(R.id.sb_green);

        addNewColorButtonListener();
        addSeekBarListeners();
        listItemListener();

        listOfColors = new ArrayList<ColorInfo>();

        resetValues();
        fillListView();
    }
    private void addNewColorButtonListener() {

        btn_save_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addColorToList();
                resetValues();
            }
        });
    }
    private void addSeekBarListeners(){
        sb_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lbl_blue_dyn.setText(Integer.toString(sb_blue.getProgress()));
                setBgColor();
                int r = sb_red.getProgress();
                int g = sb_green.getProgress();
                int bl = sb_blue.getProgress();
                lbl_hex_dyn.setText(rgbToHex(r,g,bl).toUpperCase());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lbl_green_dyn.setText(Integer.toString(sb_green.getProgress()));
                setBgColor();
                int r = sb_red.getProgress();
                int g = sb_green.getProgress();
                int bl = sb_blue.getProgress();
                lbl_hex_dyn.setText(rgbToHex(r,g,bl).toUpperCase());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lbl_red_dyn.setText(Integer.toString(sb_red.getProgress()));
                setBgColor();
                int r = sb_red.getProgress();
                int g = sb_green.getProgress();
                int bl = sb_blue.getProgress();
                lbl_hex_dyn.setText(rgbToHex(r,g,bl).toUpperCase());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void listItemListener(){
        lv_color_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                colorSelected(i);

            }
        });



    }
    private void addColorToList(){
        int r = sb_red.getProgress();
        int g = sb_green.getProgress();
        int b = sb_blue.getProgress();

        ColorInfo colorToAdd = new ColorInfo(r,g,b,rgbToHex(r,g,b));
        listOfColors.add(colorToAdd);
        adapter.notifyDataSetChanged();
    }
    private String rgbToHex(int r, int g, int b){
        return Integer.toHexString(Color.rgb(r,g,b));
    }
    private void fillListView(){
        adapter = new ColorListAdapter(this,listOfColors);
        lv_color_list.setAdapter(adapter);
    }
    private void setBgColor(){
        int r = sb_red.getProgress();
        int g = sb_green.getProgress();
        int b = sb_blue.getProgress();

        findViewById(R.id.main).setBackgroundColor(Color.rgb(r,g,b));
        if(r+g+b <= 250){
            int c = Color.rgb(255,255,255);
            setTxtColors(c);
        }
        else {
            int c = Color.rgb(0,0,0);
            setTxtColors(c);
        }
    }
    private void resetValues(){
        sb_red.setProgress(0);
        sb_green.setProgress(0);
        sb_blue.setProgress(0);
        lbl_hex_dyn.setText(rgbToHex(0,0,0).toUpperCase());
        setBgColor();
    }
    private void setTxtColors(int c){
        lbl_hex_dyn.setTextColor(c);
        lbl_red_dyn.setTextColor(c);
        lbl_green_dyn.setTextColor(c);
        lbl_blue_dyn.setTextColor(c);
        lbl_hex_const.setTextColor(c);
        lbl_red_const.setTextColor(c);
        lbl_green_const.setTextColor(c);
        lbl_blue_const.setTextColor(c);

    }
    private void colorSelected(int i){
        sb_red.setProgress(listOfColors.get(i).getRed());
        sb_green.setProgress(listOfColors.get(i).getGreen());
        sb_blue.setProgress(listOfColors.get(i).getBlue());
        setBgColor();
        int r = sb_red.getProgress();
        int g = sb_green.getProgress();
        int b = sb_blue.getProgress();
        lbl_hex_dyn.setText(rgbToHex(r,g,b).toUpperCase());

    }

}
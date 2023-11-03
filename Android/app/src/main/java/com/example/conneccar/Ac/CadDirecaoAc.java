package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.conneccar.R;

public class CadDirecaoAc extends AppCompatActivity {

    private Spinner spSeg1, spSeg2, spSeg3;
    private Spinner spConf1, spConf2, spConf3;
    private Spinner spEco1, spEco2, spEco3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_direcao);

        getSupportActionBar().hide();

        spSeg1 = findViewById(R.id.spSeg1);
        spSeg2 = findViewById(R.id.spSeg2);
        spSeg3 = findViewById(R.id.spSeg3);
        spConf1 = findViewById(R.id.spConf1);
        spConf2 = findViewById(R.id.spConf2);
        spConf3 = findViewById(R.id.spConf3);
        spEco1 = findViewById(R.id.spEco1);
        spEco2 = findViewById(R.id.spEco2);
        spEco3 = findViewById(R.id.spEco3);

        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSeg1.setAdapter(adapter);
        spSeg2.setAdapter(adapter);
        spSeg3.setAdapter(adapter);
        spConf1.setAdapter(adapter);
        spConf2.setAdapter(adapter);
        spConf3.setAdapter(adapter);
        spEco1.setAdapter(adapter);
        spEco2.setAdapter(adapter);
        spEco3.setAdapter(adapter);
    }
}
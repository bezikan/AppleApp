package com.example.anna.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PotwierdzenieActivity extends AppCompatActivity {

    TextView tvLista, tvPods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potwierdzenie);
        tvPods=(TextView)findViewById(R.id.tv_lista);
        zaladujActivity();
    }

    private void zaladujActivity(){

        MediaPlayer mPlayer = MediaPlayer.create(PotwierdzenieActivity.this, R.raw.ijudman);
        mPlayer.start();



        Bundle extras = getIntent().getExtras();
        String v1 = extras.getString("lista");
        String v2 = extras.getString("rachunek");
        String v3 = extras.getString("platnosc");

        tvPods.setText(v1+"\nMetoda płatności: "+v3+",\nKwota: "+v2+" zł"+"\n\nSmacznego ;)");





    }
}

package com.example.anna.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class MenuActivity extends AppCompatActivity {

    CheckBox kawa, herbata, omlet, nalesniki, ciasto, kanapka;
    RadioButton karta, kasa;
    TextView rachunek;
    ImageView logo;
    EditText napiwek;
    Button zamowBtn;
    int napiwekInt;
    int kwota;
    AlertDialog.Builder potwierdzenie;
    List<String> listaProduktów1;
    StringBuilder listaProduktow;
    String platnosc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        zaladujActivity();


    }

    private void zaladujActivity() {
        kawa=(CheckBox)findViewById(R.id.kawa);
        herbata=(CheckBox)findViewById(R.id.herbata);
        omlet=(CheckBox)findViewById(R.id.omlet);
        nalesniki=(CheckBox)findViewById(R.id.nalesniki);
        ciasto=(CheckBox)findViewById(R.id.ciasto);
        kanapka=(CheckBox)findViewById(R.id.kanapka);
        //rachunek=(TextView)findViewById(R.id.rachunek);
        logo=(ImageView)findViewById(R.id.logoImage);
        napiwek=(EditText)findViewById(R.id.napiwek);
        napiwek.clearFocus();
        zamowBtn=(Button)findViewById(R.id.zamowBtn);
        potwierdzenie = new AlertDialog.Builder(this);
        listaProduktow =new StringBuilder();
        karta=(RadioButton)findViewById(R.id.karta);
        kasa=(RadioButton)findViewById(R.id.kasa);
        kasa.setSelected(true);
        kwota=0;
        onClickZamow();
    }



    public void onClickZamow() {

        zamowBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(kawa.isChecked()){
                    kwota+=4;
                    listaProduktow.append("Kawa expresso\n");
                }
                if(herbata.isChecked()){
                    kwota+=2;
                    listaProduktow.append("Herbata\n");
                }
                if(omlet.isChecked()){
                    kwota+=6;
                    listaProduktow.append("Omlet\n");
                }
                if(nalesniki.isChecked()){
                    kwota+=8;
                    listaProduktow.append("Nalesniki\n");
                }
                if(ciasto.isChecked()){
                    kwota+=5;
                    listaProduktow.append("Ciasto szarlotka\n");
                }
                if(kanapka.isChecked()){
                    kwota+=4;
                    listaProduktow.append("Kanapka z jajkiem\n");
                }

                napiwekInt = Integer.parseInt(napiwek.getText().toString());
                kwota+=napiwekInt;

                if(karta.isChecked()){
                    platnosc = "Karta";
                }
                if(kasa.isChecked()) {
                    platnosc = "Gotówka";
                }



                //Toast.makeText(getApplicationContext(),String.valueOf(kwota), Toast.LENGTH_LONG).show();
                /*
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        i.putExtra("Value1", "Android By Javatpoint");
        i.putExtra("Value2", "Simple Tutorial");
        // Set the request code to any code you like, you can identify the
        // callback via this code
        startActivity(i);
                */
                Intent i = new Intent(getApplicationContext(), PotwierdzenieActivity.class);
                i.putExtra("lista", listaProduktow.toString());
                i.putExtra("rachunek",String.valueOf(kwota));
                i.putExtra("platnosc", platnosc);
                startActivity(i);
                zaladujActivity();




            }
        });



    }




    // private void addListenerOnButtonClick() { }

}

package com.mj.srmaudiometer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class Eartest extends AppCompatActivity {
int start;
int intensity=10,frequency=250,j=0,count=0;
public  static int[] thresholdl=new int[6];
public static int[] thresholdr=new int[6];
public static int[] threshold=new int[12];
Button yes,no,stop;
TextView in,fre,ear,test;
MediaPlayer mpno,mpyes;
boolean x=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eartest);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        ear=findViewById(R.id.ear);
        test=findViewById(R.id.test);
        mpno = MediaPlayer.create(getApplicationContext(), R.raw.no);
        mpyes = MediaPlayer.create(getApplicationContext(), R.raw.yes);
        in=findViewById(R.id.intensity);
        fre=findViewById(R.id.frequency);
        stop=findViewById(R.id.stop);
         stop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


             }
         });
yes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v){

        mpyes.start();
        intensity=intensity-2;
        x=true;
        in.setText("Intensity : "+intensity+"db");

    }
});

no.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        mpno.start();
        if(x)
        {
            threshold[j]=intensity+2;
            j++;
            x=false;
            frequency=frequency*2;
            intensity=10;
            if(frequency==16000)
            {
               count++;
                if(count==1)
                {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Eartest.this);
                    View layoutView = getLayoutInflater().inflate(R.layout.dialog_postive_layout, null);
                    Button dialogButton = layoutView.findViewById(R.id.btnDialog);
                    dialogBuilder.setView(layoutView);
                 final AlertDialog   alertDialog = dialogBuilder.create();
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    alertDialog.show();
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog.dismiss();
                        }
                    });

                    ear.setText("Test is currently Running in\nRight Ear");
                    test.setText("Test- 2");
                    frequency=250;
                }else
                if(count==2)
                {
                    Intent graphintent=new Intent(Eartest.this,GraphActivity.class);
                    graphintent.putExtra("threshold",threshold);
                    startActivity(graphintent);


                }


            }
            fre.setText("Frequency : "+frequency+"HZ");
            in.setText("Intensity : " + intensity + "DB");



        }
        else {
            intensity = intensity + 10;
            in.setText("Intensity : " + intensity + "DB");
        }


    }
});

 }



}

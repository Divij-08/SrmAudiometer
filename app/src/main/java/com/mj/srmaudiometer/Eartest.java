package com.mj.srmaudiometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class Eartest extends AppCompatActivity {
    public  static  int count=0;
int start;
int intensity=10,frequency=250,j=0;
int[] thresholdl=new int[8];
int[] thresholdr=new int[8];
Button yes,no,stop;
TextView in,fre,ear,test;

boolean x=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eartest);
         yes=findViewById(R.id.yes);
         no=findViewById(R.id.no);
        ear=findViewById(R.id.ear);
        test=findViewById(R.id.test);

        in=findViewById(R.id.intensity);
         fre=findViewById(R.id.frequency);
         stop=findViewById(R.id.stop);
         if(count==1)
         {
              ear.setText("Test is currently Running in\nRight Ear");
              test.setText("Test- 2");

         }
         count++;
         stop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


             }
         });
yes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v){

        intensity=intensity-2;
        x=true;
        in.setText("Intensity : "+intensity+"db");

    }
});

no.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(x)
        {
            frequency=frequency*2;
            intensity=10;
            if(frequency==16000)
            {
                Intent instructions=new Intent(getApplicationContext(), com.mj.srmaudiometer.instructions.class);
               // instructions.putExtra("rightear","rightear");
                startActivity(instructions);
                if(count==1)
                {
                    //pass leftl

                }
                if(count==2)
                {
                    //pass rightl

                }
               // Toast.makeText(getApplicationContext(),"left test complete",Toast.LENGTH_SHORT).show();
            }
            fre.setText("Frequency : "+frequency+"HZ");
            in.setText("Intensity : " + intensity + "DB");
            if(count==1)
            {thresholdl[j]=intensity;}
            if(count==2)
            {thresholdr[j]=intensity;}
            j++;
            x=false;

        }
        else {
            intensity = intensity + 10;
            in.setText("Intensity : " + intensity + "DB");
        }


    }
});

 }



}

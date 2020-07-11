package com.mj.srmaudiometer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;
import com.softmoore.android.graphlib.Label;
import com.softmoore.android.graphlib.Point;


public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        int sum1=0,sum2=0;
        int[] threshold;
        threshold=new int[12];

        Intent Eartestintent = getIntent();
        threshold= Eartestintent.getIntArrayExtra("threshold");


        for(int i=0;i<6;i++)
        {
            Log.i("threshold left",threshold[i]+"");
            sum1=sum1+threshold[i];
            Log.i("threshold right",threshold[i+6]+"");
            sum2=sum2+threshold[i+6];
        }

        int result1 = sum1/6;
        int result2 = sum2/6;
        Point[] points =
                {
                        new Point(250, threshold[0]), new Point(500, threshold[1]),  new Point(1000, threshold[2]),
                        new Point(2000, threshold[3]),   new Point(4000, threshold[4]),  new Point(8000,threshold[5])

                };

        Point[] points2 =
                {
                        new Point(250, threshold[6]), new Point(500, threshold[7]),  new Point(1000, threshold[8]),
                        new Point(2000, threshold[9]),   new Point(4000, threshold[10]),  new Point(8000,threshold[11])

                };
        Graph graph = new Graph.Builder()
                .setWorldCoordinates(-750, 10000, -10, 100)
                .setXTicks(new double[] {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000} )
                .setYTicks(new double[]{2,6,10 ,14,18,22,26,30,34,38,42,46,50,54,58,62,66,70,74,78,82,86,90})
                .addLineGraph(points,Color.RED)
                .addLineGraph(points2 ,Color.BLUE)
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Empty Graph");
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Frequencies");

        TextView mResult = findViewById(R.id.result);
        TextView mConclusion = findViewById(R.id.conclusion);

        if(result1<=25 && result2<=25)
        {
            mConclusion.setText("Normal");
        }
        else if(result1<=25 && result2>25 && result2<=40 || result2<=25 && result1>25 && result1<=40 || result2>25 && result2<=40 && result1>25 && result1<=40 )
        {
            mConclusion.setText("Mild Hearing Loss");
        }

        else if(result1>40 && result1<=55 && result2<=40 || result2>40 && result2<=55 && result1<=40 || result2>40 && result2<=55 && result1>40 && result1<=55 )
        {
            mConclusion.setText("Moderate profound Hearing Loss");
        }
        else if(result1>55 && result1<=70 && result2<=55 || result2>55 && result2<=70 && result1<=55 || result2>55 && result2<=70 && result1>55 && result1<=70 )
        {
            mConclusion.setText(" Moderate to Severe profound Hearing Loss");
        }
        else if(result1>70 && result1<=90 && result2<=70 || result2>70 && result2<=90 &&  result1<=70 || result2>70 && result2<=90 && result1>70 && result1<=90 )
        {
            mConclusion.setText("Severe profound Hearing Loss");
        }
        else if(result1>90 && result2<90 || result2>90 && result1<=90 || result2>90 && result1>90 )
        {
            mConclusion.setText("Profound Deaf");
        }




    }
}

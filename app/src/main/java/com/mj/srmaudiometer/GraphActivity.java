package com.mj.srmaudiometer;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;
import com.softmoore.android.graphlib.Label;
import com.softmoore.android.graphlib.Point;

import static android.graphics.Color.*;

public class GraphActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        int arr[];
        int[] thresholdl,thresholdr;
        thresholdl=new int[6];
        thresholdr=new int[6];
        Intent Eartestintent = getIntent();
        thresholdl= Eartestintent.getIntArrayExtra("thresholdl");
        thresholdr= Eartestintent.getIntArrayExtra("thresholdr");
        Point[] points =
                {
                        new Point(250, thresholdl[0]), new Point(500, thresholdl[1]),  new Point(1000, thresholdl[2]),
                        new Point(2000, thresholdl[3]),   new Point(4000, thresholdl[4]),  new Point(8000,thresholdl[5])

                };

       Point[] points2 =
              {
                       new Point(250, thresholdr[0]), new Point(500, thresholdr[1]),  new Point(1000, thresholdr[2]),
                       new Point(2000, thresholdr[3]),   new Point(4000, thresholdr[4]),  new Point(8000,thresholdr[5])

                };


        Graph graph = new Graph.Builder()
                .setWorldCoordinates(-2000, 10000, -10, 50)
                .setXTicks(new double[] {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000} )
                .setYTicks(new double[]{10 ,14,18,22,26,30})
                .addPoints(points, RED)
                .addLineGraph(points2 , BLUE)
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Empty Graph");
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Frequencies");

    }
}
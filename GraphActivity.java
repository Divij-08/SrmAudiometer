package com.divij.srmaudiometer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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
        int arr[];
        arr= new int[]{18, 20, 16, 22, 20, 18};
        Point[] points =
                {
                        new Point(250, arr[0]), new Point(500, arr[1]),  new Point(1000, arr[2]),
                        new Point(2000, arr[3]),   new Point(4000, arr[4]),  new Point(8000,arr[5])

                };
        /*Point[] points2=
                {
                        new Point(250, 20), new Point(500, 24),  new Point(1000, 22),
                        new Point(2000, 24,   new Point(4000, 14),  new Point(8000,16)

                };*/
        Point[] points2 =
                {
                        new Point(250, 18), new Point(500, 24),  new Point(1000, 18),
                        new Point(2000, 14),   new Point(4000, 18),  new Point(8000,24)

                };
        Graph graph = new Graph.Builder()
                .setWorldCoordinates(-2000, 10000, -10, 50)
                .setXTicks(new double[] {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000} )
                .setYTicks(new double[]{10 ,14,18,22,26,30})
                .addLineGraph(points,Color.RED)
                .addLineGraph(points2 ,Color.BLUE)
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Empty Graph");
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Frequencies");




    }
}
package com.example.topic3_gestures;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Añadimos el listener al botón (el boton es una vista)
        //https://stackoverflow.com/questions/39836303/cannot-resolve-symbol-setontouchlistener
        View myView = findViewById(R.id.button);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // ... Respond to touch events
                return true;
            }
        });
    }
    // This example shows an Activity, but you would use the same approach if
    // you were subclassing a View.
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d("movimiento", "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d("movimiento", "Action was MOVE");
                Log.d("movimientoAccion", MotionEvent.actionToString(MotionEvent.ACTION_MOVE));
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d("movimiento", "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d("movimiento", "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d("movimiento", "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                //capturar otras acciones
                Log.d("movimiento", "Cosa ocurrida diferente");
                return super.onTouchEvent(event);
        }

    }



}
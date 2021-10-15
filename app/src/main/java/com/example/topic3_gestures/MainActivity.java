package com.example.topic3_gestures;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Añadimos el listener al botón (el boton es una vista)
        //https://stackoverflow.com/questions/39836303/cannot-resolve-symbol-setontouchlistener
        View myView = findViewById(R.id.button);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v , MotionEvent event) {
                //Le mando hacer algo
                Context context = getApplicationContext();
                CharSequence text = "Hello toast! Evento!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                //
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    //Insert desired code here
                    Log.d("movimiento", "ACCIONNNNNNNN APOYO");
                    return true;
                }
                return false;

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
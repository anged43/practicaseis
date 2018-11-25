package com.example.angel.practicaseis;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sensoracelerometro extends AppCompatActivity implements SensorEventListener {
    TextView testo;
    SensorManager sensorManager;
    private Sensor acelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensoracelerometro);

        testo = (TextView)findViewById(R.id.text);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x, y ,z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[3];
        testo.setText("");
        testo.append("\n El valor de x: "+ x +" el de y: "+ y +" y el de z: "+z);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,acelerometro,sensorManager.SENSOR_DELAY_NORMAL);
    }
    protected  void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}

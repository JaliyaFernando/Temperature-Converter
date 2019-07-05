package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tempe= findViewById(R.id.temp);
        final RadioButton cel2far = findViewById(R.id.c2f);
        final RadioButton far2cel = findViewById(R.id.f2c);
        final Button convert = findViewById(R.id.convert);
        final EditText answer = findViewById(R.id.ans);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempe.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter a value",Toast.LENGTH_LONG).show();
                }
                else {
                    double value = new Double(tempe.getText().toString());
                    if(far2cel.isChecked())
                        value = UnitConverter.farenheit2celsius(value);
                    else
                        value = UnitConverter.celsius2Farenheit(value);

                    answer.setText(new Double(value).toString());

                }
            }
        });
    }

}

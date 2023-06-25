package com.hfad.radiancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AngleChooseType chooseAngleType = new AngleChooseType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalculation(View view) {
        TextView outputDegree = (TextView) findViewById(R.id.outputNumber);
        TextView inputDegree = (TextView) findViewById(R.id.inputNumber);
        Spinner chooseAngle = (Spinner) findViewById(R.id.chooseAngle);
        Spinner chooseAngleOther = (Spinner) findViewById(R.id.chooseAngleOther);
        String angleType = String.valueOf(chooseAngle.getSelectedItemId());
        String angleTypeOther = String.valueOf(chooseAngleOther.getSelectedItemId());

        String degree = String.valueOf(inputDegree.getText());
        TextView errorText = (TextView) findViewById(R.id.error);
        if (degree.isEmpty()) {
            errorText.setText("Введите число");
            outputDegree.setText("");
        } else {
            errorText.setText("");
            chooseAngleType.setAngleValue(Integer.parseInt(angleType), degree);
            double calcAngle = chooseAngleType.getChooseAngle(Integer.parseInt(angleTypeOther));
            outputDegree.setText(String.valueOf(calcAngle));
        }
    }
}
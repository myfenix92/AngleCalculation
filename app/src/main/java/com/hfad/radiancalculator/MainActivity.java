package com.hfad.radiancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AngleChooseType chooseAngleType = new AngleChooseType();
    private List<String> lastValues = new ArrayList<>();
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

        TextView lastValuesText = (TextView) findViewById(R.id.lastValues);


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
            lastValues.add(String.valueOf(calcAngle));
            StringBuilder lastValuesFormatted = new StringBuilder();
            for (String lastValue : lastValues) {
                lastValuesFormatted.append(lastValue).append('\n');
            }
            lastValuesText.setText(lastValuesFormatted);
        }
    }
}
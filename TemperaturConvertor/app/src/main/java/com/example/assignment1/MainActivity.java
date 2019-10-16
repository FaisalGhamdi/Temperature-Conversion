// Faisal Alghamdi
// 10/8/19

package com.example.assignment1;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView; // lbl
import android.text.method.ScrollingMovementMethod;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

      double f = 0;
      double c = 0;
      double toFahrenheit = 0;
      double toCelsius = 0;
      String checkRb = "";
      String result = "";
      String historyOutput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View v) {

        TextView history = findViewById(R.id.historyTxt);
        TextView fDegree = findViewById(R.id.topDegreeTxt);
        TextView bottomDegree = findViewById(R.id.outputLbl);
        history.setMovementMethod(new ScrollingMovementMethod());

        // check which radio button is checked
        if (checkRb.equalsIgnoreCase("fahernheit")) {

            f = Double.parseDouble(fDegree.getText().toString());
            toFahrenheit = (f - 32.0) / 1.8;
            result = String.format("%.1f", toFahrenheit);
            bottomDegree.setText(result);
            String orig = history.getText().toString();
            historyOutput = f + "F==>" + result +"C";
            history.setText( historyOutput + "\r\n" + orig);

        } else if (checkRb.equalsIgnoreCase("celsius")) {

            c = Double.parseDouble(fDegree.getText().toString());
            toCelsius = (c * 1.8) + 32;
            result = String.format("%.1f", toCelsius);
            bottomDegree.setText(result);
            String orig = history.getText().toString();
            historyOutput = c + "C==>" + result + "F";
            history.setText( historyOutput + "\n" + orig);

        } else { // Default if there is no saved prefrence

            f = Double.parseDouble(fDegree.getText().toString());
            toFahrenheit = (f - 32.0) / 1.8;
            result = String.format("%.1f", toFahrenheit);
            bottomDegree.setText(result);
            String orig = history.getText().toString();
            historyOutput = f + "F==>" + result +"C";
            history.setText( historyOutput + "\r\n" + orig);
        }
    }

    public void toFahernheit (View v) {

        checkRb = "fahernheit";
        TextView fLbl = findViewById(R.id.topDegreelbl);
        TextView cLbl = findViewById(R.id.bottomDegreeLbl);
        fLbl.setText("Fahernheit to Celsius");
        cLbl.setText("Celsius to Fahernheit");
        TextView fDegree = findViewById(R.id.topDegreeTxt);

        // clear prev value, if there is
        fDegree.setText("");
        TextView bottomValue = findViewById(R.id.outputLbl);
        bottomValue.setText("");

    }

    public void toCelsius (View v) {

        checkRb = "celsius";
        TextView fLbl = findViewById(R.id.topDegreelbl);
        TextView cLbl = findViewById(R.id.bottomDegreeLbl);
        fLbl.setText("Celsius to Fahernheit");
        cLbl.setText("Fahernheit to Celsius");
        TextView fDegree = findViewById(R.id.topDegreeTxt);

        // clear prev value, if there is
        fDegree.setText("");
        TextView bottomValue = findViewById(R.id.outputLbl);
        bottomValue.setText("");

    }

    public void clear (View v) {
        TextView history = findViewById(R.id.historyTxt);
        history.setText("");
    }

}

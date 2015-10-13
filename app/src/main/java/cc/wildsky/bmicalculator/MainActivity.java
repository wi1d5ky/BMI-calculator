package cc.wildsky.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cal (View v) {
        EditText heightView = (EditText)findViewById(R.id.inputHeight);
        EditText weightView = (EditText)findViewById(R.id.inputWeight);
        TextView t = (TextView) findViewById(R.id.result);
        TextView ask = (TextView) findViewById(R.id.ask);
        String response = "";
        String ans = "";

        try {
            Double height = Double.parseDouble(heightView.getText().toString());
            Double weight = Double.parseDouble(weightView.getText().toString());

            Double result = weight / (Math.pow(2, height / 100));
            ans = Double.toString(result);
            String s = String.valueOf(ans);
            ans = s.substring(0, s.indexOf(".") + 3)+ "!!";
            response = "你的 BMI 是…";
        }
        catch(Exception ex) {
            response = "輸入資料不正確！";
            ans = "請重新輸入一次Q_Q";
            Toast.makeText(v.getContext(), response, Toast.LENGTH_LONG).show();
        }
        ask.setText(response);
        t.setText(ans);
        heightView.setText("");
        weightView.setText("");
    }
}

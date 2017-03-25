package com.jcodee.mod3class4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testSoap.wcf.RELCalculatorSoap;
import com.example.testSoap.wcf.RELHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etValue1)
    EditText etValue1;
    @BindView(R.id.etValue2)
    EditText etValue2;
    @BindView(R.id.tvResultado)
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnAdd, R.id.btnDivide, R.id.btnMultiply, R.id.btnSustract})
    public void onClick(View view) {

        final String value1 = etValue1.getText().toString();
        final String value2 = etValue2.getText().toString();
        final RELCalculatorSoap calculatorSoap = new RELCalculatorSoap();

        switch (view.getId()) {
            case R.id.btnAdd:

                new AsyncTask<String, Void, String>() {
                    int resultAdd = 0;

                    @Override
                    protected String doInBackground(String... params) {

                        try {
                            resultAdd = calculatorSoap.Add(Integer.parseInt(value1),
                                    Integer.parseInt(value2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        tvResultado.setText(String.valueOf(resultAdd));
                    }
                }.execute();

                break;
            case R.id.btnDivide:

                new AsyncTask<String, Void, String>() {
                    String resultDivide = "";

                    @Override
                    protected String doInBackground(String... params) {

                        try {
                            resultDivide = calculatorSoap.Divide(value1, value2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        tvResultado.setText(resultDivide);
                    }
                }.execute();

                break;
            case R.id.btnMultiply:
                new AsyncTask<String, Void, String>() {
                    String resultMultiply = "";

                    @Override
                    protected String doInBackground(String... params) {

                        try {
                            resultMultiply = calculatorSoap.Multiply(value1, value2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        tvResultado.setText(resultMultiply);
                    }
                }.execute();
                break;
            case R.id.btnSustract:
                new AsyncTask<String, Void, String>() {
                    int resultSustract = 0;

                    @Override
                    protected String doInBackground(String... params) {

                        try {
                            resultSustract = calculatorSoap.Subtract(Integer.parseInt(value1),
                                    Integer.parseInt(value2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        tvResultado.setText(String.valueOf(resultSustract));
                    }
                }.execute();
                break;
        }
    }
}

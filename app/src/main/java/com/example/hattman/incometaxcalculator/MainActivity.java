package com.example.hattman.incometaxcalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button calculateButton;
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn0 = (Button) findViewById(R.id.buttonSingle);
        btn0.setBackgroundResource(R.drawable.singleclicked);

        //calculateButton = (Button) findViewById(R.id.button);

        //calculateButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Toast.makeText(getApplicationContext(), "Daddy Loves You!", Toast.LENGTH_SHORT).show();
        //    }
        //});

    }

    public void onButtonSingleClick(View v) {
        status = 0;
        TextView statusText = (TextView)findViewById(R.id.statusView);
        statusText.setText("Filing Single");

        Button btn0 = (Button) findViewById(R.id.buttonSingle);
        btn0.setBackgroundResource(R.drawable.singleclicked);

        Button btn1 = (Button) findViewById(R.id.buttonJointly);
        btn1.setBackgroundResource(R.drawable.marriedjointly);
        Button btn2 = (Button) findViewById(R.id.buttonSeperate);
        btn2.setBackgroundResource(R.drawable.marriedseperate);
        Button btn3 = (Button) findViewById(R.id.buttonHousehold);
        btn3.setBackgroundResource(R.drawable.headhousehold);
    }

    public void onButtonJointlyClick(View v) {
        status = 1;
        TextView statusText = (TextView)findViewById(R.id.statusView);
        statusText.setText("Married Filing Jointly");

        Button btn0 = (Button) findViewById(R.id.buttonJointly);
        btn0.setBackgroundResource(R.drawable.marriedjointlyclicked);

        Button btn1 = (Button) findViewById(R.id.buttonSingle);
        btn1.setBackgroundResource(R.drawable.single);
        Button btn2 = (Button) findViewById(R.id.buttonSeperate);
        btn2.setBackgroundResource(R.drawable.marriedseperate);
        Button btn3 = (Button) findViewById(R.id.buttonHousehold);
        btn3.setBackgroundResource(R.drawable.headhousehold);
    }

    public void onButtonSeperateClick(View v) {
        status = 2;
        TextView statusText = (TextView)findViewById(R.id.statusView);
        statusText.setText("Married Filing Seperately");

        Button btn0 = (Button) findViewById(R.id.buttonSeperate);
        btn0.setBackgroundResource(R.drawable.marriedseperateclicked);

        Button btn1 = (Button) findViewById(R.id.buttonSingle);
        btn1.setBackgroundResource(R.drawable.single);
        Button btn2 = (Button) findViewById(R.id.buttonJointly);
        btn2.setBackgroundResource(R.drawable.marriedjointly);
        Button btn3 = (Button) findViewById(R.id.buttonHousehold);
        btn3.setBackgroundResource(R.drawable.headhousehold);
    }

    public void onButtonHouseholdClick(View v) {
        status = 3;
        TextView statusText = (TextView)findViewById(R.id.statusView);
        statusText.setText("Head of Household");

        Button btn0 = (Button) findViewById(R.id.buttonHousehold);
        btn0.setBackgroundResource(R.drawable.headhouseholdclicked);

        Button btn1 = (Button) findViewById(R.id.buttonSingle);
        btn1.setBackgroundResource(R.drawable.single);
        Button btn2 = (Button) findViewById(R.id.buttonJointly);
        btn2.setBackgroundResource(R.drawable.marriedjointly);
        Button btn3 = (Button) findViewById(R.id.buttonSeperate);
        btn3.setBackgroundResource(R.drawable.marriedseperate);
    }

    public void onButtonCalculateClick(View v) {
        double income, tax, total;

        tax = 0;

        EditText yearlyIncome = (EditText)findViewById(R.id.yearlyIncome);
        TextView t1 = (TextView)findViewById(R.id.taxesOwed);

        income = Integer.parseInt(yearlyIncome.getText().toString());

        // Compute tax for single filers
        if (status == 0)
        {
            if (income <= 8350)
                tax = income * 0.10;
            else if (income <= 33950)
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <= 82250)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            else if (income <= 171550)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
                        (income - 82250) * 0.28;
            else if (income <= 372950)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
                        (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
            else
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                        (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
        }

        // Compute tax for married filing jointly or qualifying widow(er)
        else if (status == 1)
        {
            if (income <= 16700)
                tax = income * 0.10;
            else if (income <= 67900)
                tax = 16700 * 0.10 + (income - 16700) * 0.15;
            else if (income <= 137050)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
            else if (income <= 208850)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 +
                        (income - 137050) * 0.28;
            else if (income <= 372950)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 +
                        (208850 - 137050) * 0.28 + (income - 208850) * 0.33;
            else
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 +
                        (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 +
                        (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
        }

        // Compute tax for married filing separately
        else if (status == 2)
        {
            if (income <= 8350)
                tax = income * 0.10;
            else if (income <= 33950)
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <= 68525)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            else if (income <= 104425)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 +
                        (income - 68525) * 0.28;
            else if (income <= 186475)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 +
                        (104425 - 68525) * 0.28 + (income - 104426) * 0.33;
            else
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +
                        (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
        }

        // Compute tax for head of household
        else if (status == 3)
        {
            if (income <= 11950)
                tax = income * 0.10;
            else if (income <= 45500)
                tax = 11950 * 0.10 + (income - 11950) * 0.15;
            else if (income <= 117450)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (income - 45500) * 0.25;
            else if (income <= 190200)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 +
                        (income - 117450) * 0.28;
            else if (income <= 372950)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 +
                        (190200 - 117450) * 0.28 + (income - 190200) * 0.33;
            else
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                        (117451 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
                        (372950 - 190200) * 0.33 + (income - 372950) * 0.35;

        }

        else {}

         // Do the rest
         total = ((tax * 100) / 100.0);
         t1.setText("$" + Double.toString(total));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

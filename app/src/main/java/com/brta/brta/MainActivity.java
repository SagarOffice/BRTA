package com.brta.brta;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner groupSpinner;
    Spinner digitSpinner;
    EditText vechileNo;
    EditText driverInfoEt;
    TextView showText;
    Button submitBtn;

    String[] group = new String[]{"ka", "Kha", "gha", "cha", "kfjd", "fjdff", "kfjdfj"};
    String[] vechileDigitString = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        groupSpinner = (Spinner) findViewById(R.id.groupVeichle);
        digitSpinner = (Spinner) findViewById(R.id.disitVaichle);
        vechileNo = (EditText) findViewById(R.id.veichleNo);
        showText = (TextView) findViewById(R.id.showTextTv);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        driverInfoEt = (EditText) findViewById(R.id.driverInfoEt);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, group);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupSpinner.setAdapter(dataAdapter);


        final ArrayAdapter<String> vechileDigit = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, vechileDigitString);
        vechileDigit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        digitSpinner.setAdapter(vechileDigit);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String group = groupSpinner.getSelectedItem().toString();
                String digit = digitSpinner.getSelectedItem().toString();
                String no = vechileNo.getText().toString();
                String driver = driverInfoEt.getText().toString();

                if(group.length()>0 || digit.length()>0 || no.length()>0 || driver.length()>0){
                    showText.setText(group+"-"+digit+"-"+no+"\n"+driver);
                }else{
                    Toast.makeText(MainActivity.this, "Please, Input All Data", Toast.LENGTH_SHORT).show();
                }
                if(group.length()>0){
                    Intent intent = new Intent(MainActivity.this,VehicleInfo.class);
                    startActivity(intent);
                }
                if(group.length()>0 && driver.length()>0){
                    Intent intent = new Intent(MainActivity.this,InformationActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }
}

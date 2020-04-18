package com.example.classactivityretake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // the two text input boxes
    EditText name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
    }
    public void saveData(View view){
        DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        String res= dataBaseHandler.saveData(name.getText().toString(),email.getText().toString());

        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        name.setText("");
        email.setText("");
    }
}

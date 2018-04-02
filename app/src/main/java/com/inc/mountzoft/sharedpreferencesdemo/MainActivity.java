package com.inc.mountzoft.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userDataInput;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    public void saveData(View view){
        userDataInput = (EditText)findViewById(R.id.user_name);

        editor.putString("USER_NAME",userDataInput.getText().toString());
        editor.commit();

        Toast.makeText(this, "Data saved, click Display Data button to see the saved data",
                Toast.LENGTH_LONG).show();
    }

    public void displayData(View view){
        Intent intent = new Intent(this,NewActivity.class);
        startActivity(intent);
    }
}

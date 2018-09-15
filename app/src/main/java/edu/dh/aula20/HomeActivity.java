package edu.dh.aula20;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static edu.dh.aula20.MainActivity.EMAIL;
import static edu.dh.aula20.MainActivity.GET_RESULT;
import static edu.dh.aula20.MainActivity.NAME;
import static edu.dh.aula20.MainActivity.PASSWORD;

public class HomeActivity extends AppCompatActivity {

private TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewHello = findViewById(R.id.textViewHello);

        if (getIntent() !=null && getIntent().getExtras()!=null){
            String name = getIntent().getStringExtra(NAME);
            String password = getIntent().getStringExtra(PASSWORD);
            String email = getIntent().getStringExtra(EMAIL);

            textViewHello.setText(name);
        }

    }

    public void calculete(View view) {
        Intent intent =new Intent();
        intent.putExtra("resultado", "Deu bom");

        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}

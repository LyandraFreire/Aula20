package edu.dh.aula20;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

public class MainActivity extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "passowrd";
    public static final int GET_RESULT = 200;

    private TextInputLayout textInputLayouName;
    private TextInputLayout textInputLayouEmail;
    private TextInputLayout textInputLayouPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayouName=findViewById(R.id.nm_name);
        textInputLayouEmail=findViewById(R.id.em_email);
        textInputLayouPassword = findViewById(R.id.sn_password);
        btnRegister = findViewById(R.id.cad_cadastrar);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textInputLayouName.getEditText().getText().toString();
                String email = textInputLayouEmail.getEditText().getText().toString();
                String password = textInputLayouPassword.getEditText().getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(NAME,name);
                bundle.putString(EMAIL,email);
                bundle.putString(PASSWORD,password);

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                intent.putExtras(bundle);

                startActivityForResult(intent,GET_RESULT);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Activity.RESULT_OK && requestCode == GET_RESULT){
            Toast.makeText( this,data.getStringExtra("resultado"),Toast.LENGTH_SHORT);
        }
    }
}

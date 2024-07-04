package com.codegama.todolistapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codegama.todolistapplication.R;
import com.codegama.todolistapplication.database.PortalDB;
import com.codegama.todolistapplication.model.User;

public class sign_up extends Activity {
    Button signin;
    public String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        signin = findViewById(R.id.sign_in);
        EditText usernameTextField = (EditText)findViewById(R.id.user);
        EditText passwordTextField = (EditText)findViewById(R.id.pass);
        EditText emailTextField = (EditText)findViewById(R.id.email);
        Button SignUpBTN = (Button) findViewById(R.id.signup_button);
        PortalDB db = new PortalDB(this);
        Button signUpBTN = (Button) findViewById(R.id.signup_button);
        username = usernameTextField.getText().toString();

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameTextField.getText().toString();
                boolean flag ;
                User user1 = new User(usernameTextField.getText().toString(),emailTextField.getText().toString(),passwordTextField.getText().toString());
                flag = db.addNewUser(user1);
                if(flag){
                    Toast.makeText(getApplicationContext(), "Enregistré avec succès", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_LONG).show();
                }
                System.out.println("omar "+usernameTextField.getText());


                Intent intent = new Intent(sign_up.this, MainActivity.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_up.this, sign_in.class);
                startActivity(intent);
            }
        });
    }
}

package com.codegama.todolistapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codegama.todolistapplication.R;
import com.codegama.todolistapplication.database.PortalDB;


public class sign_in extends AppCompatActivity {
    Button signup;
    public String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        signup = findViewById(R.id.signup_button);
        Button signIn = (Button) findViewById(R.id.sign_in);
        EditText usernameTextField = (EditText)findViewById(R.id.user);
        EditText passwordTextField = (EditText)findViewById(R.id.pass);
        PortalDB db = new PortalDB(this);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User;
                userName = usernameTextField.getText().toString();
                String password = passwordTextField.getText().toString();
                User = db.login( db, userName, password);

                if (User.equals("Not Found")) {
                    Toast.makeText(getApplicationContext(), "Utilisateur non trouvé", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Connexion avec succès", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(sign_in.this, MainActivity.class);
                    intent.putExtra("USERNAME", userName);
                    startActivity(intent);
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in.this, sign_up.class);
                startActivity(intent);

            }
        });
        TextView forgot = (TextView) findViewById(R.id.forget_pass);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in.this, reset_pass.class);
                startActivity(intent);
            }
        });
}

}

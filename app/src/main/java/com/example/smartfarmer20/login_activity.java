package com.example.smartfarmer20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_activity extends AppCompatActivity implements View.OnClickListener {

    private TextView CreateAccount;
    private EditText emailLogin,passwordLogin;
    private FirebaseAuth mAuth;
    private Button LoginButton;
    private ProgressBar loginprogressbar;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        mAuth = FirebaseAuth.getInstance();
        CreateAccount=(TextView)findViewById(R.id.createAccountId);
        emailLogin=(EditText)findViewById(R.id.login_email_editText);
        passwordLogin=(EditText)findViewById(R.id.login_password_editText);
        LoginButton=(Button)findViewById(R.id.login_button);
        loginprogressbar=findViewById(R.id.progresssbar_id);
        loginprogressbar.setVisibility(View.INVISIBLE);

        LoginButton.setOnClickListener(this);
        CreateAccount.setOnClickListener(this);

        //onBackPressed();


    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.createAccountId){
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.login_button){
            LoginButton.setVisibility(view.INVISIBLE);
            loginprogressbar.setVisibility(view.VISIBLE);
            user_login();
        }
    }
    @Override
    public void onBackPressed() {
        alertDialogBuilder = new AlertDialog.Builder(login_activity.this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Do you want to exit?");
        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(login_activity.this,"Canceled",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void user_login() {
        final String emailStringLogin = emailLogin.getText().toString().trim();
        final String passStringLogin = passwordLogin.getText().toString().trim();
        if(emailStringLogin.isEmpty())
        {
            LoginButton.setVisibility(View.VISIBLE);
            loginprogressbar.setVisibility(View.INVISIBLE);
            emailLogin.setError("Enter an email address");
            emailLogin.requestFocus();
            return;
        }

       if(!Patterns.EMAIL_ADDRESS.matcher(emailStringLogin).matches())
        {
            LoginButton.setVisibility(View.VISIBLE);
            loginprogressbar.setVisibility(View.INVISIBLE);
            emailLogin.setError("Enter a valid email address");
            emailLogin.requestFocus();
            return;
        }

        if(passStringLogin.isEmpty())
        {
            LoginButton.setVisibility(View.VISIBLE);
            loginprogressbar.setVisibility(View.INVISIBLE);
            passwordLogin.setError("Enter a password");
            passwordLogin.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailStringLogin,passStringLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                else{
                    LoginButton.setVisibility(View.VISIBLE);
                    loginprogressbar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}

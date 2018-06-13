package com.example.victor.sharephoto;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "EmailPassword";

    private FirebaseAuth mAuth;

    private EditText mEmailFieldRegistration;
    private EditText mPasswordFieldRegistration;

    private Button mAccept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_registration);

        // Views
        mEmailFieldRegistration = findViewById(R.id.mEmailFieldRegistration);
        mPasswordFieldRegistration = findViewById(R.id.mPasswordFieldRegistration);

        // Button
        findViewById(R.id.mAccept).setOnClickListener(this);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);

                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END create_user_with_email]
    }

    private boolean validateForm(){
        boolean valid = true;

        String email = mEmailFieldRegistration.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailFieldRegistration.setError("Required.");
            valid = false;
        } else {
            mEmailFieldRegistration.setError(null);
        }

        String password = mPasswordFieldRegistration.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordFieldRegistration.setError("Required.");
            valid = false;
        } else {
            mPasswordFieldRegistration.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.mAccept){
            createAccount(mEmailFieldRegistration.getText().toString(), mPasswordFieldRegistration.getText().toString());
        }
    }
}

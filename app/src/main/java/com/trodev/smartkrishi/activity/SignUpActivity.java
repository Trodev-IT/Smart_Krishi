package com.trodev.smartkrishi.activity;

//import static com.google.firebase.database.core.operation.OperationSource.Source.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.trodev.smartkrishi.MainActivity;
import com.trodev.smartkrishi.R;
import com.trodev.smartkrishi.User;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView signin;
    private MaterialButton signup;
    private EditText username, emailET, divisionET, ageET, numberET, passwordET;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    AutoCompleteTextView autocompletetxt;
    ArrayAdapter<String> adapterItem;
    String[] item= {"Select Division","Dhaka", "Sylhet", "Rajshahi", "Chittagonj", "Barishal", "Khulna", "Maymensing"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /*hide action bar*/
        getSupportActionBar().hide();

        /*Select Division from list*/
        autocompletetxt= findViewById(R.id.divisionEt);
        adapterItem= new ArrayAdapter<String>(this, R.layout.list_division, item);
        autocompletetxt.setAdapter(adapterItem);
        autocompletetxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String item= adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Division "+item, Toast.LENGTH_SHORT).show();
            }
        });

        signup = findViewById(R.id.signup);
        signup.setOnClickListener(this);
        signin = findViewById(R.id.signin);
        signin.setOnClickListener(this);

        /*auth profile from firebase*/
        firebaseAuth = FirebaseAuth.getInstance();

        /*init widget views*/
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(this);
        username = findViewById(R.id.username);
        emailET = findViewById(R.id.emailEt);
        divisionET = findViewById(R.id.divisionEt);
        ageET = findViewById(R.id.ageEt);
        numberET = findViewById(R.id.numberEt);
        passwordET = findViewById(R.id.passwordEt);
        progressBar = findViewById(R.id.progressBar);
    }

    // go to SignIn form with clicking
    @Override
    public void onClick(View view) {
        int itemId = view.getId();
        if (itemId == R.id.signin) {
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            Toast.makeText(SignUpActivity.this, "লগিন করুন", Toast.LENGTH_SHORT).show();
            finish();
        } else if (itemId == R.id.signup) {
            registarUser();

        }
    }
    private void registarUser() {
        String usersname, email, division, age, number, password;
        usersname = username.getText().toString().trim();
        email = emailET.getText().toString().trim();
        division = divisionET.getText().toString().trim();
        age = ageET.getText().toString().trim();
        number = numberET.getText().toString().trim();
        password = passwordET.getText().toString().trim();

        if (usersname.isEmpty()) {
            username.setError("নাম প্রয়োজন");
            username.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            emailET.setError("ইমেইল প্রয়োজন");
            emailET.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailET.setError("দয়াকরে সঠিক ইমেইল প্রদান করুন!");
            emailET.requestFocus();
            return;
        }

        if (division.isEmpty()) {
                divisionET.setError("বিভাগ প্রয়োজন");
                divisionET.requestFocus();
                return;
        }

        if (age.isEmpty()) {
                ageET.setError("বয়স প্রয়োজন");
                ageET.requestFocus();
                return;
        }

        if (number.isEmpty()) {
                numberET.setError("মোবাইল নাম্বার প্রয়োজন");
                numberET.requestFocus();
                return;
        }

        if (password.length() <= 7) {
                passwordET.setError("পাসওয়ার্ড অবশ্যই ৮ ক্যারেক্টারের হতে হবে");
                passwordET.requestFocus();
                return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //Firebase Database

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(usersname, email, division, age, number, password);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                progressBar.setVisibility(View.GONE);
                                                Toast.makeText(SignUpActivity.this, "রেজিস্ট্রেশন সফল হয়েছে", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                                finish();

                                            } else {

                                                progressBar.setVisibility(View.VISIBLE);
                                                Toast.makeText(SignUpActivity.this, "রেজিস্ট্রেশন সফল হয়নি", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    });

                        }
                    }
                });

        }
    }

package com.example.surftrac.Page_Interactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.surftrac.DB.AppDataBase;
import com.example.surftrac.DB.UserDAO;
import com.example.surftrac.R;
import com.example.surftrac.table_objects.User;

import java.util.List;

public class Login extends AppCompatActivity {

    private EditText nameInput;
    private EditText mPassword;
    private String mUserId;
    public User mUser;
    public  boolean adminTest;

    private String mUserNameString;
    private String mPasswordString;
    private UserDAO userAccessPoint;

    private void getValueFromDisplay() {
        mUserNameString = nameInput.getText().toString();
        mPasswordString = mPassword.getText().toString();
    }

    // validate password
    private boolean validatePassword(){
        return mUser.getPassword().equals(mPasswordString);
    }

    // get db
    private void getDatabase(){
        userAccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.USER_TABLE)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }

    private void getDefaultUsers(){
        List<User> users = userAccessPoint.getAllUsers();
        if(users.size() <= 0){
            User default_user = new User("testUser1", "testUser1", false);
            User default_admin = new User("admin2", "admin2", true);
            userAccessPoint.insert(default_admin, default_user);
        }
    }

    private boolean checkForUserInDb(){
        mUser = userAccessPoint.getUserByUserName(mUserNameString);
        if(mUser == null){
            Toast.makeText(this, "No user found by the name " + mUserNameString, Toast.LENGTH_SHORT).show();
            return false;
        }
        adminTest = mUser.isAdmin();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getDatabase();
        getDefaultUsers();
        wireUpDisplay();
    }

    private void wireUpDisplay(){
        Button mLogin = findViewById(R.id.loginButton_logPg);
        nameInput = findViewById(R.id.username_edittext);
        mPassword = findViewById(R.id.Password_edittext);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValueFromDisplay();
                if(checkForUserInDb()){
                    if(!validatePassword()){
                        Toast.makeText(Login.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    } else{
                        Intent intent = HomePage.intentFactory(getApplicationContext(), mUserNameString, adminTest);
                        intent.putExtra("Key", adminTest);
                        intent.putExtra("user", mUserNameString);
                        startActivity(intent);
                    }
                }
            }
        });
    }


    public static Intent intentFactory (Context context) {
        Intent intent = new Intent(context, Login.class);
        return intent;
    }

}
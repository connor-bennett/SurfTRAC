package com.example.surftrac.Page_Interactions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.surftrac.DB.AppDataBase;
import com.example.surftrac.DB.UserDAO;
import com.example.surftrac.R;
import com.example.surftrac.table_objects.User;

import java.util.List;

public class SignUp extends AppCompatActivity {

    List<User> allUsers;

    EditText mUserName;
    EditText mPassword;
    Button mSignUpButton;

    String UsernameString;
    String PasswordString;

    UserDAO UserDaoAccessPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

      getDatabase();
      wireUpDisplay();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    public boolean addUser(){
        if(!checkForUserInDB()){
            User new_user = new User(UsernameString, PasswordString, false);
            UserDaoAccessPoint.insert(new_user);
            return true;
        }else{
            return false;
        }
    }

    public boolean checkForUserInDB(){
        allUsers = UserDaoAccessPoint.getAllUsers();
        boolean hasUser = false;
        for(User user: allUsers){
            if(user.getUsername().equals(UsernameString) && user.getPassword().equals(PasswordString)){
                hasUser = true;
            }
        }
        return hasUser;
    }

    public void wireUpDisplay(){
        mUserName = findViewById(R.id.SignUp_username_edittext);
        mPassword = findViewById(R.id.SignUp_password_edittext);
        mSignUpButton = findViewById(R.id.SignUpNow);


        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValuesFromDisplay();
                if(addUser()){
                    Toast.makeText(SignUp.this, "You're in, Welcome!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, HomePage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignUp.this, "Sorry user already exits", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void getDatabase(){
        UserDaoAccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.USER_TABLE)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }

    public void getValuesFromDisplay(){
        UsernameString = mUserName.getText().toString();
        PasswordString = mPassword.getText().toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sub_item_log_out:
                Toast.makeText(this, "You are not logged in", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Clicked Back", Toast.LENGTH_SHORT).show();
                Intent intent_one = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent_one);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static Intent intentFactory (Context context) {
        return new Intent(context, SignUp.class);
    }


}
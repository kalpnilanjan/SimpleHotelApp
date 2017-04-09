package vineet.kalpnil.uddhav.com.vukhotel;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin, btnReg;
    EditText lUsername,lPassword;
    String username,password;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lUsername= (EditText) findViewById(R.id.username);
        lPassword= (EditText) findViewById(R.id.password);
        btnLogin= (Button) findViewById(R.id.email_sign_in_button);
        btnLogin.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
        btnReg = (Button) findViewById(R.id.register_button);
        btnReg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                String username = lUsername.getText().toString();
                String password = lPassword.getText().toString();
                User user = new User(username, password);
                authenticate(user);
                break;
            case R.id.register_button:
                Intent i = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(i);
                break;

        }

    }

    private void authenticate(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.fetchUserDataAsyncTask(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser) {
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);
        startActivity(new Intent(this, Main2Activity.class));
    }


}


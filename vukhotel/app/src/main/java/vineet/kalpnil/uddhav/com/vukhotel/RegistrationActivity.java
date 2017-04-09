package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spr;
    private EditText sUsername, sName, sPhone, sPassword, sEmail;
    private Button reg;
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spr = (Spinner) findViewById(R.id.sp);
        spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sEmail = (EditText) findViewById(R.id.emailedit);
        sPassword = (EditText) findViewById(R.id.et3);
        sPhone = (EditText) findViewById(R.id.mobileNum);
        sName = (EditText) findViewById(R.id.et);
        sUsername = (EditText) findViewById((R.id.et2));
        reg = (Button) findViewById(R.id.reg1);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reg1:
                String name = sName.getText().toString();
                String username = sUsername.getText().toString();
                String password = sPassword.getText().toString();
                String email = sEmail.getText().toString();
                String phone = sPhone.getText().toString();
                String gender = selectedItem;
                boolean valid = validate();
                if (valid) {
                    //Intent toMain = new Intent(RegistrationActivity.this, Main2Activity.class);
                    //startActivity(toMain);
                    User user = new User(name, username, password, phone,email,gender);
                    registerUser(user);
                }
                else {
                    Toast.makeText(this,"UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
                }
                break;


        }
    }


/*

    public void Register(View v) {
        boolean valid = validate();
        if (valid) {
            Intent toMain = new Intent(RegistrationActivity.this, Main2Activity.class);
            startActivity(toMain);
        } else {
        }

    }
*/
    public boolean validate() {

        String em1 = sEmail.getText().toString();
        String pass = sPassword.getText().toString();
        String mNum1 = sPhone.getText().toString();
        String fName = sName.getText().toString();
        String uName = sUsername.getText().toString();
        boolean valid = false;

        if (isValidFullName(fName) && isValidUserName(uName) && isValidPassword(pass) && isValidNumber(mNum1) && isValidEmail(em1)) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
        }
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 5) {
            return true;
        } else {
            Toast.makeText(this, "Password should be more than 5 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean isValidNumber(String mNum1) {
        if (mNum1.length() == 10) {
            return true;
        } else {
            Toast.makeText(this, "Enter valid mobile number", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean isValidFullName(String fName) {
        String namePattern = "^[A-Za-z]+$";

        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(fName);
        if (fName != null && matcher.matches()) {
            return true;
        } else {
            Toast.makeText(this, "Enter valid name", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean isValidUserName(String uName) {
        if (uName != null && uName != "") {
            return true;
        } else {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

}
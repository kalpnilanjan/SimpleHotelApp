package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class checkout extends AppCompatActivity {
    private Button btn;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userLocalStore = new UserLocalStore(this);
        setContentView(R.layout.activity_checkout);
        btn = (Button) findViewById(R.id.checkout);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                Intent loginIntent = new Intent(checkout.this, LoginActivity.class);
                startActivity(loginIntent);

            }
        });
        User user = userLocalStore.getLoggedInUser();
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


}

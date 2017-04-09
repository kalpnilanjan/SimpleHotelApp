package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class bookRoom extends AppCompatActivity {
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView s1 = (TextView) findViewById(R.id.room);
        Spinner s2 = (Spinner) findViewById(R.id.numOFRoom);
         b = (Button) findViewById(R.id.book);
        Intent intent = getIntent();
        String name = intent.getStringExtra("room");
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        s1.setText(name);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomain = new Intent(bookRoom.this,Main2Activity.class);
                startActivity(tomain);
            }
        });

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

        // add the room name and numbers in user table
        // subtract free rooms from total
        //then go back to main activiy
}

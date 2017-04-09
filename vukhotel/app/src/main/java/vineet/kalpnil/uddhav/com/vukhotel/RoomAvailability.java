package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RoomAvailability extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_availability);
        Button btn1 = (Button) findViewById(R.id.imageButton1);
        Button btn2 = (Button) findViewById(R.id.imageButton2);
        Button btn3 = (Button) findViewById(R.id.imageButton3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent book = new Intent(RoomAvailability.this, bookRoom.class);
                book.putExtra("room", "FAMILY SUITE");
                startActivity(book);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent book = new Intent(RoomAvailability.this, bookRoom.class);
                book.putExtra("room", "HONEYMOON SUITE");
                startActivity(book);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent book = new Intent(RoomAvailability.this, bookRoom.class);
                book.putExtra("room", "BUSINESS SUITE");
                startActivity(book);
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
}

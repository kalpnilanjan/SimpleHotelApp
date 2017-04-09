package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //ImageView image =(ImageView) findViewById(R.id.startimage);
        //image.setImageResource(R.drawable.start);
        Thread timer = new Thread(){

            public void run(){
                try {
                    sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Class ourClass;
                    try {
                        ourClass = Class.forName("vineet.kalpnil.uddhav.com.vukhotel.Main2Activity");
                        Intent openStart = new Intent(StartActivity.this,ourClass);
                        startActivity(openStart);
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }


        };
        timer.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}

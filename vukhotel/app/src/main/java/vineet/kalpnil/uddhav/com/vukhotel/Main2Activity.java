package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private String branch[];
    public MyViewAdapter adapter;
    UserLocalStore userLocalStore;
    int icons[] = {R.color.lightblue,R.color.lightblue,R.color.lightblue,R.color.lightblue,R.color.lightblue};
    public static List<Information> getData(int[] icons,String[] titles)
    {
        List<Information> data=new ArrayList<>();
        for(int i=0;i<titles.length && i<icons.length; i++)
        {
            Information current=new Information();
            current.iconId=icons[i% icons.length];
            current.title=titles[i%titles.length];
            data.add(current);
        }
        return data;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        branch=getResources().getStringArray(R.array.main1);
        recyclerView = (RecyclerView) findViewById(R.id.hang_recycler_view);
        adapter = new MyViewAdapter(getData(icons,getResources().getStringArray(R.array.main1)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        userLocalStore = new UserLocalStore(this);
        User user = userLocalStore.getLoggedInUser();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
            displayUserDetails();
        }
    }

    private boolean authenticate() {
        if (userLocalStore.getLoggedInUser() == null) {
            Intent intent = new Intent(Main2Activity.this, LoginActivity.class);
            startActivity(intent);
            return false;
        }
        return true;
    }

    private void displayUserDetails() {
        User user = userLocalStore.getLoggedInUser();
        Toast.makeText(Main2Activity.this, user.username.toString(), Toast.LENGTH_SHORT).show();
    }
}

package vineet.kalpnil.uddhav.com.vukhotel;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class roomservice extends AppCompatActivity {
    private RecyclerView recyclerView;
    public RoomServiceAdapter adapter;
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
        setContentView(R.layout.activity_roomservice);
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.hang_recycler_view);
        adapter = new RoomServiceAdapter(getData(icons,getResources().getStringArray(R.array.rs1)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

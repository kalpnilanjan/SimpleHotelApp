package vineet.kalpnil.uddhav.com.vukhotel;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by abc on 30-Mar-16.
 */
public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.MyViewHolder> {
    List<Information> data = Collections.emptyList();
    private LayoutInflater inflater;
    int icons[] = {R.color.colorAccent,R.color.colorPrimaryDark,R.color.lightblue,R.color.lightblue,R.color.lightblue};

    public MyViewAdapter(List<Information> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.gen_card_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        //holder.txt2.setBackgroundColor(icons[position]);
        //holder.cd.setBackgroundColor(icons[position]);
        //holder.icon.setImageResource(current.iconId);
        holder.txt2.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //ImageView icon;
        CardView cd;
        TextView txt2;

        public MyViewHolder(View itemView) {
            super(itemView);
            cd = (CardView) itemView.findViewById(R.id.cardv);
            txt2 = (TextView) itemView.findViewById(R.id.txt1);
            //icon = (ImageView) itemView.findViewById(R.id.img_rec);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            switch (getAdapterPosition()) {

                // JITNE CARDS UTNE CASES DAAL DENA
                case 0:
                    //YAHAN  PE ACTIVITY KA NAAM DAALNA JOH OPEN KARNA HAI
                    Intent in = new Intent(v.getContext(),RoomAvailability.class);
                    v.getContext().startActivity(in);
                    break;
                //case 1:
                    //Intent in1 = new Intent(v.getContext(),roomservice.class);
                    //v.getContext().startActivity(in1);
                    //break;
                case 1:
                    //YAHAN  PE ACTIVITY KA NAAM DAALNA JOH OPEN KARNA HAI
                    Intent in2 = new Intent(v.getContext(),roomservice.class);
                    v.getContext().startActivity(in2);

                    break;
                case 2:
                    //YAHAN  PE ACTIVITY KA NAAM DAALNA JOH OPEN KARNA HAI
                    Intent in3 = new Intent(v.getContext(),bill.class);
                    v.getContext().startActivity(in3);
                    break;
                case 3:
                    //YAHAN  PE ACTIVITY KA NAAM DAALNA JOH OPEN KARNA HAI
                    Intent in4 = new Intent(v.getContext(),checkout.class);
                    v.getContext().startActivity(in4);
                    break;
            }
        }

    }
}

package hire.omnify.com.machinetestomnify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by linux on 16/8/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Integer> numbersArrayList;

    public RecyclerAdapter(Context context,ArrayList<Integer> numbersArray) {
        this.context = context;
        this.numbersArrayList = numbersArray;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {

            holder.txtNumbers.setText(String.valueOf(numbersArrayList.get(position)));

    }

    @Override
    public int getItemCount() {
        return numbersArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNumbers;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtNumbers = (TextView) itemView.findViewById(R.id.txtNumbers);

        }
    }
}

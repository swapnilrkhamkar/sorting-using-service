package hire.omnify.com.machinetestomnify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by linux on 15/8/17.
 */

public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int[] numbersArray = new int[]{27, 39, 40, 10, 20, 37, 19, 35, 31, 45, 97, 28, 21, 70, 82, 95, 81, 75, 65, 46};
    private Button btnRandomNo,btnSort;
    private ArrayList<Integer> numbersArrayList;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        btnRandomNo = (Button) view.findViewById(R.id.btnRandomNo);
        btnSort = (Button) view.findViewById(R.id.btnSort);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        numbersArrayList = new ArrayList<>();

        for (int i = 0; i < numbersArray.length; i++){

            numbersArrayList.add(numbersArray[i]);
        }

        recyclerAdapter = new RecyclerAdapter(getContext(),numbersArrayList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();

        btnRandomNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();

                numbersArrayList = new ArrayList<>();

                    for (int i = numbersArray.length-1; i > 0; i--) {

                        int j = random.nextInt(i);

                        int temp = numbersArray[i];
                        numbersArray[i] = numbersArray[j];
                        numbersArray[j] = temp;

                        numbersArrayList.add(numbersArray[i]);

                    }



                Log.d("test","Arraylist Size " + numbersArrayList.size());

                recyclerAdapter = new RecyclerAdapter(getContext(), numbersArrayList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager = getFragmentManager();

                Bundle bundle = new Bundle();

                bundle.putIntArray("Array",numbersArray);
                secondFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, secondFragment, "Data");
                fragmentTransaction.addToBackStack("Data");
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}

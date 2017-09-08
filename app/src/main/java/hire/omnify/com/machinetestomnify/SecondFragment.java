package hire.omnify.com.machinetestomnify;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by linux on 16/8/17.
 */

public class SecondFragment extends Fragment {

    private RecyclerView recyclerViewQuickSort,recyclerViewMergeSort;
    private RecyclerAdapter recyclerAdapter,recyclerAdapter1;
    private RecyclerView.LayoutManager layoutManager,layoutManager1;
    private ArrayList<Integer> numbersArrayList,numbersArrayList1;
    private int[] numbersArray;
    private TextView txtQuicksort,txtMergesort;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();

        if (bundle != null) {

            numbersArray = bundle.getIntArray("Array");

        }

        Intent serviceIntent = new Intent((getActivity()), QuickSortService.class);
        Bundle bundle1 = new Bundle();
        bundle1.putIntArray("Array",numbersArray);
        serviceIntent.putExtras(bundle1);
        getActivity().startService(serviceIntent);
        getActivity().stopService(serviceIntent);

        Intent serviceIntent1 = new Intent((getActivity()), MergeSortService.class);
        Bundle bundle2 = new Bundle();
        bundle2.putIntArray("Array",numbersArray);
        serviceIntent1.putExtras(bundle2);
        getActivity().startService(serviceIntent1);
        getActivity().stopService(serviceIntent1);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, null);

        recyclerViewQuickSort = (RecyclerView) view.findViewById(R.id.recyclerViewQuickSort);
        recyclerViewMergeSort = (RecyclerView) view.findViewById(R.id.recyclerViewMergeSort);
        txtQuicksort = (TextView) view.findViewById(R.id.txtQuicksort);
        txtMergesort = (TextView) view.findViewById(R.id.txtMergesort);


        recyclerViewQuickSort.setHasFixedSize(true);
            recyclerViewMergeSort.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewQuickSort.setLayoutManager(layoutManager);
            recyclerViewMergeSort.setLayoutManager(layoutManager1);

            QuickSortService quickSortService = new QuickSortService();
            quickSortService.sort(numbersArray);

            numbersArrayList = new ArrayList<>();

            for (int i = 0;i < numbersArray.length;i++){

                numbersArrayList.add(numbersArray[i]);

            }

            recyclerAdapter = new RecyclerAdapter(getContext(), numbersArrayList);
            recyclerViewQuickSort.setAdapter(recyclerAdapter);
            recyclerAdapter.notifyDataSetChanged();

            MergeSortService mergeSortService = new MergeSortService();
            mergeSortService.sort(numbersArray);

            numbersArrayList1 = new ArrayList<>();

            for (int i = 0;i < numbersArray.length;i++){

                numbersArrayList1.add(numbersArray[i]);

            }

            recyclerAdapter1 = new RecyclerAdapter(getContext(), numbersArrayList1);
            recyclerViewMergeSort.setAdapter(recyclerAdapter1);
            recyclerAdapter1.notifyDataSetChanged();

        return view;

    }
}


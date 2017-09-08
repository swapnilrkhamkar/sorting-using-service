package hire.omnify.com.machinetestomnify;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by linux on 16/8/17.
 */

public class QuickSortService extends Service {

    private int[] numbersArray;
    private int number;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("test","onCreate of QuickSort has been service called");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                numbersArray = bundle.getIntArray("Array");

                if (numbersArray != null) {

                    sort(numbersArray);
                    Log.d("test", "Array[0] " + numbersArray[0]);
                    Log.d("test", "Array[1] " + numbersArray[1]);
                    Log.d("test", "Array[2] " + numbersArray[2]);
                    Log.d("test", "Array[3] " + numbersArray[3]);
                    Log.d("test", "Array[4] " + numbersArray[4]);
                    Log.d("test", "Array[5] " + numbersArray[5]);
                    Log.d("test", "Array[6] " + numbersArray[6]);
                    Log.d("test", "Array[7] " + numbersArray[7]);
                    Log.d("test", "Array[8] " + numbersArray[8]);
                    Log.d("test", "Array[9] " + numbersArray[9]);
                    Log.d("test", "Array[10] " + numbersArray[10]);
                    Log.d("test", "Array[11] " + numbersArray[11]);
                    Log.d("test", "Array[12] " + numbersArray[12]);
                    Log.d("test", "Array[13] " + numbersArray[13]);
                    Log.d("test", "Array[14] " + numbersArray[14]);
                    Log.d("test", "Array[15] " + numbersArray[15]);
                    Log.d("test", "Array[16] " + numbersArray[16]);
                    Log.d("test", "Array[17] " + numbersArray[17]);
                    Log.d("test", "Array[18] " + numbersArray[18]);
                    Log.d("test", "Array[19] " + numbersArray[numbersArray.length - 1]);

                } else {
                    Log.d("test", "Array is null....");
                }
            } else {
                Log.d("test", "Bundle list is null....");

            }

        return super.onStartCommand(intent,flags,startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void sort(int[] values) {

        if (values == null || values.length == 0){
            return;
        }
        this.numbersArray = values;
        number = values.length;
        quicksort(0, number - 1);

        }

    private void quicksort(int low, int high) {
        int i = low, j = high;

        int pivot = numbersArray[low + (high-low)/2];

        while (i <= j) {

            while (numbersArray[i] < pivot) {
                i++;
            }

            while (numbersArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbersArray[i];
        numbersArray[i] = numbersArray[j];
        numbersArray[j] = temp;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy of QuickSort service has been called");
    }
}


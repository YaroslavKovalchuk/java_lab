package task_2_arrays_collection.logical_task_for_arrays;

import java.util.Arrays;

public class Tasks {

    public int[] createNewArray(int[] t1,int[] t2){
        int[] arr = new int[1];
        if (t1.length < t2.length) {
            arr = new int[t1.length];
        }else

        for (int i = 0; i < t1.length; i++){
            for (int j = 0; j < t2.length; j++){
                if (t1[i]==(t2[j])){
                    arr[i] = t1[i];
                }
            }
        }
        return t;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "t=" + Arrays.toString(t) +
                '}';
    }
}

package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort<T extends Comparable<? super T>>extends BaseSort {
    DirectSort(T[] items) {
        super(items);
    }


    @Override
    public void Sort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < items.length; i++) {
            int j = i - 1;
            if (bigger(items[i], items[j])) {
                continue;
            }
            T tmp = (T) items[i];
            while (j >= 0 && bigger(items[j], tmp)) {
                items[j + 1] = items[j];
                moveStep++;
                j--;
            }
        }
    }

    @Override
    public void sort() {

    }
}


            //    private Integer[] items;
//    private long duration;
//    private int compareCount;
//    int swapCount;
//    int moveStep;
//
//    public DirectSort(Integer[] items){
//        this.items=items;
//        compareCount=0;
//    }
//    boolean bigger(Integer a,Integer b){
//        compareCount++;
//        return a.compareTo(b)>0;
//    }
//
//    @Override
//    public void Sort() {
//
//    }
//
//    void swap(int i, int j){
//        int tmp=items[i];
//        items[i]=items[j];
//        items[j]=tmp;
//        swapCount++;
//    }
//    public String getResult(){
//        String display = "";
//        for (Integer i : items) {
//            display = display.concat(i + ",");
//        }
//        return display.substring(0, display.length() - 1);
//    }
//    public void sort(){
//        for(int i = 0;i<items.length-1;i++){
//            int minpos=i;
//            for(int j=i+1;j<items.length;j++){
//                if(items[minpos].compareTo(items[j])>0){
//                    minpos=j;
//                }
//            }
//            swap(minpos,i);
//        }
//    }

//    public int getSwapCount() {
//        return swapCount;
//    }
//
//    public int getMoveStep() {
//        return moveStep;
//    }
//
//    public long getDuration(){
//        return duration;
//    }
//    public int getCompareCount(){
//        return compareCount;
//    }
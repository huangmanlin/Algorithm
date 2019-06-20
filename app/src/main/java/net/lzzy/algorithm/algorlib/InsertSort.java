package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort<T extends Comparable<T>>extends BaseSort<T>{
      InsertSort(T[]items){
        super(items);
    }

    @Override
    public void Sort() {

    }

    @Override
    public void sort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < items.length; i++) {
            int j = i - 1;
            if (bigger(items[i], items[j])) {
                continue;
            }
            Integer tmp = (Integer) items[i];
            while (j >= 0 && bigger(items[j], (T) tmp)) {
                items[j + 1] = items[j];
                moveStep++;
                j--;
            }
        }
    }
}

package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class BaseSort<T extends Comparable<? super T>> {
    //region 1.field字段   最小权限原则

    T[] items;
    long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;
    //endregion

    BaseSort(T[] items) {
        this.items = items;
        compareCount = 0;
        swapCount = 0;
        moveStep = 0;
    }

    boolean bigger(T a, T b) {
        compareCount++;
        return a.compareTo(b) > 0;
    }

    public abstract void Sort();


    void swap(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
        swapCount++;
    }

    public String getResult() {
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0, display.length() - 1);
    }

    public void sortWithTime() {
        long start = System.currentTimeMillis();
        Sort();
        duration = System.currentTimeMillis() - start;
    }

    public abstract void sort();

    public long getDuration() {
        return duration;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getMoveStep() {
        return moveStep;
    }
}

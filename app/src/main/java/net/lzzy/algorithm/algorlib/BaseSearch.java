package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public abstract class BaseSearch<T extends Comparable<? super T>> {
    T[] items;       //可接收参与排序的数据集合
    long time;
    int compareCount;    //比较
    int compareMove;       //移动
    long directSort;       //排序结果

    public BaseSearch(T[] items) {       //数据集合
        this.items = items;
        compareCount = 0;
        compareMove = 0;
    }

    public BaseSearch() {

    }

    boolean equal(T a, T b) {         //用于比较两个元素大小的方法
        compareCount++;
        return a.compareTo(b) == 0;
    }

    int compare(T a, T b) {
        compareCount++;
        return a.compareTo(b);
    }

    public String getResult() {        //返回排序结果的方法
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0, display.length() - 1);
    }

    public abstract int search(T key);

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCompareCount() {
        return compareCount;
    }

    void setCompareCount(int compareCount) {
        this.compareCount = compareCount;
    }

    public int getCompareMove() {
        return compareMove;
    }

    public void setCompareMove(int compareMove) {
        this.compareMove = compareMove;
    }

}
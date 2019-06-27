package net.lzzy.algorithm.algorlib;

import android.content.ClipData;

import java.io.OptionalDataException;

import static java.util.Objects.compare;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class BinarySearch<T extends Comparable<? super T>> extends BaseSearch<T> {
    BinarySearch(T[] items) {
        super(items);
    }

    @Override
    public int search(T key) {
        int start = 0;
        int end = items.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            int comp = compare(key, items[middle]);
            if (comp == 0) {
                setTime(System.currentTimeMillis() - start);
                return middle;
            } else if (comp > 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        setTime(System.currentTimeMillis() - start);
        return -1;
    }
}

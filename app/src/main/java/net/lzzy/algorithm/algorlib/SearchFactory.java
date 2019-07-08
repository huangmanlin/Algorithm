package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class SearchFactory{
    public static <T extends Comparable<? super T>>BaseSearch<T>getInstance(int key,T[]items){
        BaseSearch search;
        switch (key ){
            case 1:
                search=new DirectSearch<>(items);
                break;
            case 2:
                search=new BinarySearch<>(items);
                break;
            case 3:
                search=new BinaryTree(items);
                break;
                default:
                    return null;
        }
        return search;
    }
    public static String[]getSearchName(){
        return new String[] {
                "选择查找法","顺序查找","二分查找","二叉排序树"
        };
    }

}

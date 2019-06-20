package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.InsertSort;
import net.lzzy.algorithm.algorlib.SortFactory;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spinner;
//    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        initSpinner();

    }

    private void initSpinner() {
        spinner=findViewById(R.id.activity_main_sp);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,SortFactory.getSortNames()));
    }

    private void initviews() {
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer> sort= SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer>sortNotNull= Objects.requireNonNull(sort);
                sortNotNull.sortWithTime();
//                DirectSort sort=new DirectSort(items);
//                sort.sort();
                String result=sortNotNull.getResult();
             tvResult.setText(result);
                     Toast.makeText(this,"总时长:"+sort.getDuration(), Toast.LENGTH_SHORT).show();
//                directSort();
//                intsertSort();
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现

        //分为有序区和无序区，每一趟排序都在有序区依次对比，记录对比区域的最小元素的位置
        //然后把无序区第一个元素和所记录的最小元素进行交换，无序区少一个，有序区多一个，循环往复直至无序区
        //元素数量为0
        for(int i = 0;i<items.length-1;i++){
            int minpos=i;
            for(int j=i+1;j<items.length;j++){
                if(items[minpos].compareTo(items[j])>0){
                    minpos=j;
                }
            }
            swap(minpos,i);
        }
    }

    private void intsertSort() {
        //todo:直接插入排序
        for(int i = 1; i < items.length; i++){
            if(items[i] < items[i - 1]){
                int temp=items[i];          //监视哨temp
                int keys=i-1;               //keys表示为有序区域的最后一位
                for (int j=keys;j>0 && temp<items[j];j--){    //从第i-1位向前并移位，直至找到小于第i位停止
                    items[j+1]=items[j];
                    keys--;      //有序区域的位置减少
                }
                items[keys+1]=temp;
            }
        }
    }

    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}


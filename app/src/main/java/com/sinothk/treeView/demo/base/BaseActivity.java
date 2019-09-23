package com.sinothk.treeView.demo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.treeView.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangke on 2017-1-15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected List<Node> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    private void initDatas() {
        // id , pid , label , 其他属性
        mDatas.add(new Node<>("1", "-1", "商务部"));

        mDatas.add(new Node<>(12 + "", 1 + "", "赵某"));
        mDatas.add(new Node<>(13 + "", 1 + "", "谢总"));
        mDatas.add(new Node<>(14 + "", 1 + "", "赵偶"));

        mDatas.add(new Node<>("2", "-1", "研发部"));

        mDatas.add(new Node<>(22 + "", 2 + "", "李某"));
        mDatas.add(new Node<>(23 + "", 2 + "", "张明"));
        mDatas.add(new Node<>(24 + "", 2 + "", "丸子"));
    }
}

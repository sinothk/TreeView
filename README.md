# TreeView
TreeView


# Step 1. Add the JitPack repository to your build file

  ## Add it in your root build.gradle at the end of repositories:
      allprojects {
        repositories {
          ...
          maven { url 'https://www.jitpack.io' }
        }
      }

  ## Step 2. Add the dependency
    dependencies {
            implementation 'com.github.sinothk:TreeView:1.19.0923'
    }
# 使用
  ## ListView
      public class ListViewActivity extends AppCompatActivity {
        int num = 0;
        private TreeListViewAdapter mAdapter;

        protected List<Node> mDatas = new ArrayList<>();

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

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_demo);

            initDatas();

            RecyclerView mRecyTree = (RecyclerView) findViewById(R.id.recyclerview);
            mRecyTree.setVisibility(View.GONE);


            ListView mTree = (ListView) findViewById(R.id.lv_tree);
            //第一个参数  ListView
            //第二个参数  上下文
            //第三个参数  数据集
            //第四个参数  默认展开层级数 0为不展开
            //第五个参数  展开的图标
            //第六个参数  闭合的图标
            mAdapter = new SimpleTreeAdapter(mTree, ListViewActivity.this, mDatas, 1, R.mipmap.tree_ex, R.mipmap.tree_ec);
            mTree.setAdapter(mAdapter);
        }

        /**
         * 添加数据
         *
         * @param v
         */
        public void click(View v) {

    //        List<Node> mlist = new ArrayList<>();
    //        if (num == 0)
    //            mlist.add(new Node("22", "0", "我是添加的root节点", new FileNode()));
    //
    //        //添加一个根节点
    //        mlist.add(new Node("223", "0", "我也是添加的root节点", new FileNode()));
    //
    //        //加在新节点上
    //        mlist.add(new Node("333" + num, "22", "我是添加的1" + num));
    //        mlist.add(new Node("44444" + num, "22", "我是添加的2" + num));
    //        //加到现有数据的父节点上
    //        mlist.add(new Node("444454" + num, "1", "我是添加的3" + num));
    //
    //        num++;
    //
    //        mAdapter.addData(0, mlist);
        }

        /**
         * 显示选中数据
         */
        public void clickShow(View v) {
            StringBuilder sb = new StringBuilder();
            //获取排序过的nodes
            //如果不需要刻意直接用 mDatas既可
            final List<Node> allNodes = mAdapter.getAllNodes();
            for (int i = 0; i < allNodes.size(); i++) {
                if (allNodes.get(i).isChecked()) {
                    sb.append(allNodes.get(i).getName() + ",");
                }
            }
            String strNodesName = sb.toString();
            if (!TextUtils.isEmpty(strNodesName))
                Toast.makeText(this, strNodesName.substring(0, strNodesName.length() - 1), Toast.LENGTH_SHORT).show();
        }

        public void delete(View view) {
            if (mAdapter.getAllNodes().size() > 0) {
                mAdapter.removeData(mAdapter.getAllNodes().get(mAdapter.getAllNodes().size() - 1));
            }
        }
    }
    
   ## RecyclerView
       public class RecyclerViewActivity extends AppCompatActivity {

        private TreeRecyclerAdapter mAdapter;
        int num = 0;
        protected List<Node> mDatas = new ArrayList<>();

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

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_demo);

            initDatas();

            ListView mListTree = (ListView) findViewById(R.id.lv_tree);
            mListTree.setVisibility(View.GONE);

            RecyclerView mTree = (RecyclerView) findViewById(R.id.recyclerview);
            mTree.setLayoutManager(new LinearLayoutManager(this));
            //第一个参数  RecyclerView
            //第二个参数  上下文
            //第三个参数  数据集
            //第四个参数  默认展开层级数 0为不展开
            //第五个参数  展开的图标
            //第六个参数  闭合的图标
            mAdapter = new SimpleTreeRecyclerAdapter(mTree, RecyclerViewActivity.this,
                    mDatas, 0, R.mipmap.tree_ex, R.mipmap.tree_ec);

            mTree.setAdapter(mAdapter);
        }

        /**
         * 添加数据
         *
         * @param v
         */
        public void click(View v) {

            List<Node> mlist = new ArrayList<>();
            if (num == 0)
                mlist.add(new Node("22", "0", "我是添加的root", new FileNode()));

            //添加一个根节点
            mlist.add(new Node("223", "0", "我也是添加的root节点", new FileNode()));

            //加在新节点上
            mlist.add(new Node("333" + num, "22", "我是添加的1" + num));
            mlist.add(new Node("44444" + num, "22", "我是添加的2" + num));
            //加到现有数据的父节点上
            mlist.add(new Node("444454" + num, "1", "我是添加的3" + num));

            num++;
            mAdapter.addData(0, mlist);
        }

        /**
         * 显示选中数据
         */
        public void clickShow(View v) {
            StringBuilder sb = new StringBuilder();

            final List<Node> allNodes = mAdapter.getAllNodes();

            for (int i = 0; i < allNodes.size(); i++) {

                if (allNodes.get(i).isChecked()) {
                    sb.append(allNodes.get(i).getName() + ",");
                }

            }
            String strNodesName = sb.toString();

            if (!TextUtils.isEmpty(strNodesName))
                Toast.makeText(this, strNodesName.substring(0, strNodesName.length() - 1), Toast.LENGTH_SHORT).show();
        }

        public void delete(View view) {
            if (mAdapter.getAllNodes().size() > 0) {
                mAdapter.removeData(mAdapter.getAllNodes().get(mAdapter.getAllNodes().size() - 1));
            }
        }
    }

# 预览
  <img>[https://github.com/sinothk/TreeView/blob/master/app/img/img01.jpg]

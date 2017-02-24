package codingbo.mvpdemo.tasks;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import codingbo.mvpdemo.R;

/**
 * Created by bob
 * on 17.1.16.
 */

public class TaskFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.ll_tasks_container)
    LinearLayout mLlTasksContainer;
    @BindView(R.id.iv_no_tasks)
    ImageView mIvNoTasks;
    @BindView(R.id.tx_no_tasks)
    TextView mTxNoTasks;
    @BindView(R.id.noTasks)
    LinearLayout mNoTasks;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    public TaskFragment() {
    }

    public TaskFragment newInstance() {
        return new TaskFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.task_frag, container, false);
        ButterKnife.bind(this, root);

        return root;
    }

}

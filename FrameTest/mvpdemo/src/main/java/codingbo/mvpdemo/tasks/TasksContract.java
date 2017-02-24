package codingbo.mvpdemo.tasks;

import java.util.List;

import codingbo.mvpdemo.BasePresenter;
import codingbo.mvpdemo.BaseView;
import codingbo.mvpdemo.data.Task;

/**
 * Created by bob
 * on 17.2.7.
 */

public class TasksContract {
    /**
     * view操作
     */
    interface View extends BaseView {
        /**
         * 加载数据标志
         *
         * @param active true false
         */
        void setLodingIndicator(boolean active);

        /**
         * 显示任务
         *
         * @param tasks 任务
         */
        void showTask(List<Task> tasks);

        /**
         * 显示(跳转)添加任务界面
         */
        void showAddTask();

        /**
         * 显示跳转任务详情界面
         *
         * @param taskId 任务Id
         */
        void showTaskDetailUi(String taskId);

        /**
         * 提示标记为完成
         */
        void showTaskMarkedComplete();

        /**
         * 提示标记为活跃
         */
        void showTaskMarkedActive();

        /**
         * 提示已清除完成的任务
         */
        void showTaskComletedTaskCleared();

        /**
         * 提示加载数据错误
         */
        void showLoadingTasksError();

        /**
         * 显示没有任务
         */
        void showNoTasks();

        /**
         * 设置标题为 待办事项
         */
        void showActiveFilterLabel();

        /**
         * 设置标题为 已办事项
         */
        void showCompletedFilterLabel();

        /**
         * 设置标题为 全部事项
         */
        void showAllFilterLabel();

        /**
         * 显示无待办提醒
         */
        void showNoActiveTasks();

        /**
         * 提示无完成事项
         */
        void showNoCompletedTasks();

        /**
         * 提示保存任务成功
         */
        void showSuccessfullySavedMessage();

        /**
         * 当前view是否显示
         *
         * @return
         */
        boolean isActive();

        /**
         * 显示筛选弹出菜单
         */
        void showFilteringPopUpMenu();
    }

    /**
     * presenter
     */
    interface Presenter extends BasePresenter {


    }
}

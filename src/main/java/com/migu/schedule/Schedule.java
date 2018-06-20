package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 类名和方法不能修改
 */
public class Schedule {

    /**
     * 服务节点集合
     */
    private List<Integer> nodes = new ArrayList<>();

    /**
     * 任务队列
     */
    private Map<Integer, Integer> taskQueue = new HashMap<>();

    /**
     * 初始化系统
     *
     * @return 结果码
     */
    public int init() {
        nodes.clear();
        taskQueue.clear();
        return ReturnCodeKeys.E001;
    }

    /**
     * 注册服务
     *
     * @param nodeId 服务节点编码
     * @return 结果码
     */
    public int registerNode(int nodeId) {
        if (nodeId > 0) {
            if (nodes.contains(nodeId)) {
                return ReturnCodeKeys.E005;
            }
            nodes.add(nodeId);
            return ReturnCodeKeys.E003;
        } else {
            return ReturnCodeKeys.E004;
        }
    }

    /**
     * 根据服务节点编码服务注销
     *
     * @param nodeId 服务节点编码
     * @return 结果码
     */
    public int unregisterNode(int nodeId) {
        if (nodeId > 0) {
            if (!nodes.contains(nodeId)) {
                return ReturnCodeKeys.E007;
            }
            nodes.remove(Integer.valueOf(nodeId));
            return ReturnCodeKeys.E006;
        } else {
            return ReturnCodeKeys.E004;
        }
    }

    /**
     * 新增任务
     *
     * @param taskId      任务编码
     * @param consumption 消耗资源率
     * @return 结果码
     */
    public int addTask(int taskId, int consumption) {
        if (taskId > 0) {
            if (taskQueue.containsKey(taskId)) {
                return ReturnCodeKeys.E010;
            }
            taskQueue.put(taskId, consumption);
            return ReturnCodeKeys.E008;
        } else {
            return ReturnCodeKeys.E009;
        }
    }

    /**
     * 根据任务编码删除任务
     *
     * @param taskId 任务编码
     * @return 结果码
     */
    public int deleteTask(int taskId) {
        if (taskId > 0) {
            if (!taskQueue.containsKey(taskId)) {
                return ReturnCodeKeys.E012;
            }
            taskQueue.remove(taskId);
            return ReturnCodeKeys.E011;
        } else {
            return ReturnCodeKeys.E009;
        }
    }

    /**
     * 任务调度
     *
     * @param threshold 任务调度阈值
     * @return 结果码
     */
    public int scheduleTask(int threshold) {
        if (threshold > 0) {

        } else {
            return ReturnCodeKeys.E002;
        }
        return ReturnCodeKeys.E000;
    }

    /**
     * 查询任务状态列表
     *
     * @param tasks 任务状体列表
     * @return 结果码
     */
    public int queryTaskStatus(List<TaskInfo> tasks) {
        if (tasks == null) {
            return ReturnCodeKeys.E016;
        }
        return ReturnCodeKeys.E000;
    }

}

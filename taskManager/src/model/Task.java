package model;

public class Task {
    private String taskName;
    private String taskDetail;
    private int taskIssueDate;
    public int taskId;

    public Task() {
    }

    public Task(String taskName, String taskDetail) {
        this.taskName = taskName;
        this.taskDetail = taskDetail;
    }

    public String getTasksName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskIssueDate() {
        return taskIssueDate;
    }

    public void setTaskIssueDate(int taskIssueDate) {
        this.taskIssueDate = taskIssueDate;
    }
}

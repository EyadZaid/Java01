package training.expires;

public class Task {
    private Action func;
    private TaskStatus status;


    public Task(Action func) {
        this.func = func;
        status = TaskStatus.STOPPED;
    }

    public void execute() {
        func.apply();
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }
}

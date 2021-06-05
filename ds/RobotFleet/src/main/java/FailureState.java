public class FailureState implements IRobotState {

    @Override
    public IRobotState active(IRobot robot) {
        return new ActiveState();
    }

    @Override
    public IRobotState reboot(IRobot robot) {
        robot.reboot();
        return new RebootState();
    }

    @Override
    public IRobotState work(IRobot robot) {
        return new WorkState();
    }

    @Override
    public IRobotState failure(IRobot robot) {
        return new FailureState();
    }
}

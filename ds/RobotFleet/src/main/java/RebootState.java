public class RebootState implements IRobotState {
    @Override
    public IRobotState active(IRobot robot) {
        throw new IllegalStateException();
    }

    @Override
    public IRobotState reboot(IRobot robot) {
        return this;
    }

    @Override
    public IRobotState work(IRobot robot) {
        throw new IllegalStateException();
    }

    @Override
    public IRobotState failure(IRobot robot) {
        throw new IllegalStateException();
    }
}

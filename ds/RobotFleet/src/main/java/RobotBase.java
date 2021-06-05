import java.util.ArrayList;
import java.util.List;

public class RobotBase implements IRobot{
    private String name;
    private String callSign;
    private IState state;
    private RobotModel model;
    private final List<ITool> tools;

    public RobotBase() {
        tools = new ArrayList<>();
    }

    @Override
    public void dispatch() {

    }

    @Override
    public void reboot() {

    }

    @Override
    public void diagnostics() {

    }
}

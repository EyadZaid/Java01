import java.util.ArrayList;
import java.util.List;

public class RobotBase implements IRobot{
    private String name;
    private String callSign;
    private final List<ITool> tools;
    private RobotModel model;

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

package uk.co.easty;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SwingTravisTestTest {

    private FrameFixture window;
    private final static Logger LOGGER = Logger.getLogger(SwingTravisTestTest.class.getName());

    @BeforeClass
    public static void setUpOnce() {
//        Robot robot = BasicRobot.robotWithNewAwtHierarchy();
//        robot.settings().delayBetweenEvents(1000);

        FailOnThreadViolationRepaintManager.install();
    }

    @org.testng.annotations.BeforeMethod
    public void setUp() {
        SwingTravisTest frame = GuiActionRunner.execute(() -> new SwingTravisTest());
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.maximize();

//        Robot robot = BasicRobot.robotWithNewAwtHierarchy();
//        robot.settings().delayBetweenEvents(1000);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
    }

    @org.testng.annotations.Test
    public void test1() throws InterruptedException {
        window.button("button1").click();

        assertThat(window.dialog().label("OptionPane.label").requireText("Button 1 clicked!"));

        window.dialog().button().click();

        window.button("button2").click();

        assertThat(window.dialog().label("OptionPane.label").requireText("Button 2 clicked!"));

        window.dialog().button().click();
    }
}
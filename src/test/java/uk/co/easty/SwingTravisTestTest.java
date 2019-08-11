package uk.co.easty;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SwingTravisTestTest {

    private FrameFixture window;
    private final static Logger LOGGER = Logger.getLogger(SwingTravisTestTest.class.getName());

    @BeforeClass
    public static void setUpOnce() {
        LOGGER.info("### setUpOnce...");

        //        Robot robot = BasicRobot.robotWithNewAwtHierarchy();
//        robot.settings().delayBetweenEvents(1000);

        FailOnThreadViolationRepaintManager.install();
    }

    @org.testng.annotations.BeforeMethod
    public void setUp() {
        LOGGER.info("### setUp...");

        SwingTravisTest frame = GuiActionRunner.execute(() -> new SwingTravisTest());
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//        window.maximize();
        window.resizeTo(new Dimension(400, 200));

//        Robot robot = BasicRobot.robotWithNewAwtHierarchy();
//        robot.settings().delayBetweenEvents(1000);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        LOGGER.info("### tearDown...");
    }

    @org.testng.annotations.Test
    public void test1() throws InterruptedException {
        LOGGER.info("### test1...");

        LOGGER.info("### test1: button1 click");
        window.button("button1").click();

        LOGGER.info("### test1: check text 1");
        assertThat(window.dialog().label("OptionPane.label").requireText("Button 1 clicked!"));

        LOGGER.info("### test1: click dialog button 1");
        window.dialog().button().click();

        LOGGER.info("### test1: button2 click");
        window.button("button2").click();

        LOGGER.info("### test1: check text 2");
        assertThat(window.dialog().label("OptionPane.label").requireText("Button 2 clicked!"));

        LOGGER.info("### test1: click dialog button 2");
        window.dialog().button().click();
    }
}
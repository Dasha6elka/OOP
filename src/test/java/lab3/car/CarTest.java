package lab3.car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car = new Car();
    private EDirection BACK = EDirection.BACK;
    private EDirection STAY = EDirection.STAY;
    private EDirection FORWARD = EDirection.FORWARD;

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void turnOnEngineWorks() {
        car.turnOnEngine();
        assertTrue(car.getEngineState());
        assertEquals(0, car.getGear());
        assertEquals(STAY, car.getDirection());
    }

    @Test
    public void turnOffEngineWorks() {
        car.turnOnEngine();
        car.turnOffEngine();
        assertFalse(car.getEngineState());
        assertEquals(0, car.getSpeed());
        assertEquals(0, car.getGear());
    }

    @Test
    public void setGearWorks() {
        assertTrue(car.setGear(0));
        assertFalse(car.setGear(2));
        car.turnOnEngine();
        assertTrue(car.setGear(1));
        car.setSpeed(25);
        car.setGear(2);
        assertEquals(2, car.getGear());
        car.setSpeed(35);
        car.setGear(3);
        assertEquals(3, car.getGear());
        car.setSpeed(45);
        car.setGear(4);
        assertEquals(4, car.getGear());
        car.setSpeed(55);
        car.setGear(5);
        assertEquals(5, car.getGear());

    }

    @Test
    public void setSpeedWorks() {
        car.turnOnEngine();
        car.setGear(1);
        assertTrue(car.setSpeed(10));
        assertFalse(car.setSpeed(50));
        car.setSpeed(25);
        car.setGear(2);
        assertTrue(car.setSpeed(30));
        assertFalse(car.setSpeed(60));
        car.setSpeed(40);
        car.setGear(3);
        assertTrue(car.setSpeed(50));
        assertFalse(car.setSpeed(70));
        car.setSpeed(55);
        car.setGear(4);
        assertTrue(car.setSpeed(70));
        assertFalse(car.setSpeed(100));
        car.setSpeed(70);
        car.setGear(5);
        assertTrue(car.setSpeed(120));
        assertFalse(car.setSpeed(160));
    }

    @Test
    public void neutralGearWorks() {
        car.turnOnEngine();
        car.setGear(1);
        assertEquals(1, car.getGear());
        car.setSpeed(25);
        assertEquals(25, car.getSpeed());
        car.setGear(2);
        assertEquals(2, car.getGear());
        car.setSpeed(40);
        assertEquals(40, car.getSpeed());
        car.setGear(0);
        assertEquals(0, car.getGear());
        assertTrue(car.setSpeed(35));
        assertFalse(car.setSpeed(45));
    }

    @Test
    public void neutralGearWithAny() {
        car.turnOnEngine();
        car.setGear(-1);
        assertEquals(-1, car.getGear());
        car.setSpeed(5);
        assertEquals(BACK, car.getDirection());
        assertEquals(5, car.getSpeed());
        car.setGear(0);
        assertEquals(0, car.getGear());
        car.setSpeed(0);
        assertEquals(STAY, car.getDirection());
        assertEquals(0, car.getSpeed());
        car.setGear(1);
        assertEquals(1, car.getGear());
        car.setSpeed(25);
        assertEquals(FORWARD, car.getDirection());
        assertEquals(25, car.getSpeed());
        assertTrue(car.setGear(0));
        car.setGear(2);
        car.setSpeed(40);
        assertTrue(car.setGear(0));
        car.setGear(3);
        car.setSpeed(55);
        assertTrue(car.setGear(0));
        car.setGear(4);
        car.setSpeed(70);
        assertTrue(car.setGear(0));
        car.setGear(5);
    }

    @Test
    public void reverseGearWorks() {
        car.turnOnEngine();
        car.setGear(-1);
        assertEquals(STAY, car.getDirection());
        car.setSpeed(10);
        car.setGear(0);
        assertFalse(car.setGear(1));
        assertFalse(car.setGear(2));
        assertFalse(car.setGear(3));
        assertFalse(car.setGear(4));
        assertFalse(car.setGear(5));
        car.setSpeed(0);
        assertTrue(car.setGear(1));
    }

    @Test
    public void testComplexFlow() {
        car.turnOnEngine();
        car.setGear(1);
        assertTrue(car.getEngineState());
        assertEquals(1, car.getGear());
        assertFalse(car.setSpeed(31));
        assertEquals(STAY, car.getDirection());
        car.setSpeed(10);
        assertEquals(10, car.getSpeed());
        assertEquals(FORWARD, car.getDirection());
        car.setGear(0);
        assertEquals(0, car.getGear());
        assertFalse(car.setGear(2));
        assertEquals(0, car.getGear());
        car.setGear(1);
        car.setSpeed(20);
        assertEquals(FORWARD, car.getDirection());
        assertEquals(1, car.getGear());
        assertEquals(20, car.getSpeed());
        car.setSpeed(30);
        assertEquals(30, car.getSpeed());
        assertFalse(car.setSpeed(40));
        assertEquals(30, car.getSpeed());
        assertFalse(car.setGear(-1));
        assertEquals(FORWARD, car.getDirection());
        assertEquals(1, car.getGear());
        car.setGear(3);
        assertEquals(3, car.getGear());
        assertFalse(car.setSpeed(29));
        assertFalse(car.setSpeed(61));
        car.setGear(2);
        assertEquals(2, car.getGear());
        assertFalse(car.setSpeed(19));
        assertEquals(30, car.getSpeed());
        assertFalse(car.setSpeed(51));
        assertEquals(30, car.getSpeed());
        car.setGear(3);
        car.setSpeed(60);
        assertEquals(3, car.getGear());
        assertEquals(60, car.getSpeed());
        car.setGear(0);
        assertEquals(0, car.getGear());
        assertFalse(car.setSpeed(61));
        assertEquals(60, car.getSpeed());
        car.setSpeed(59);
        assertEquals(59, car.getSpeed());
        car.setSpeed(20);
        assertEquals(20, car.getSpeed());
        car.setSpeed(0);
        assertEquals(0, car.getGear());
        assertFalse(car.setSpeed(10));
        assertEquals(0, car.getSpeed());
        car.setGear(1);
        car.setSpeed(10);
        assertEquals(1, car.getGear());
        assertEquals(10, car.getSpeed());
        assertFalse(car.turnOffEngine());
        car.setSpeed(0);
        assertEquals(0, car.getSpeed());
        assertFalse(car.turnOffEngine());
        car.setGear(0);
        assertEquals(0, car.getGear());
        car.turnOffEngine();
        assertFalse(car.getEngineState());
        assertFalse(car.setSpeed(10));
        assertFalse(car.setGear(1));
        assertEquals(0, car.getSpeed());
        assertEquals(0, car.getGear());
    }
}

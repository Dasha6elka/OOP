package lab3.car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car = new Car();

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void turnOnEngineWorks() {
        car.TurnOnEngine();
        assertTrue(car.engineState);
        assertEquals(0, car.gear);
        assertEquals("stay", car.direction);
    }

    @Test
    public void turnOffEngineWorks() {
        car.TurnOnEngine();
        car.TurnOffEngine();
        assertFalse(car.engineState);
        assertEquals(0, car.speed);
        assertEquals(0, car.gear);
    }

    @Test
    public void setGearWorks() {
        assertTrue(car.SetGear(0));
        assertFalse(car.SetGear(2));
        car.TurnOnEngine();
        assertTrue(car.SetGear(1));
    }

    @Test
    public void setSpeedWorks() {
        car.TurnOnEngine();
        car.SetGear(1);
        assertTrue(car.SetSpeed(10));
        assertFalse(car.SetSpeed(50));
        car.SetSpeed(25);
        car.SetGear(2);
        assertTrue(car.SetSpeed(30));
        assertFalse(car.SetSpeed(60));
        car.SetSpeed(40);
        car.SetGear(3);
        assertTrue(car.SetSpeed(50));
        assertFalse(car.SetSpeed(70));
        car.SetSpeed(55);
        car.SetGear(4);
        assertTrue(car.SetSpeed(70));
        assertFalse(car.SetSpeed(100));
        car.SetSpeed(70);
        car.SetGear(5);
        assertTrue(car.SetSpeed(120));
        assertFalse(car.SetSpeed(160));
    }

    @Test
    public void neutralGearWorks() {
        car.TurnOnEngine();
        car.SetGear(1);
        assertEquals(1, car.gear);
        car.SetSpeed(25);
        assertEquals(25, car.speed);
        car.SetGear(2);
        assertEquals(2, car.gear);
        car.SetSpeed(40);
        assertEquals(40, car.speed);
        car.SetGear(0);
        assertEquals(0, car.gear);
        assertTrue(car.SetSpeed(35));
        assertFalse(car.SetSpeed(45));
    }

    @Test
    public void neutralGearWithAny() {
        car.TurnOnEngine();
        car.SetGear(-1);
        assertEquals(-1, car.gear);
        car.SetSpeed(5);
        assertEquals("back", car.direction);
        assertEquals(5, car.speed);
        car.SetGear(0);
        assertEquals(0, car.gear);
        car.SetSpeed(0);
        assertEquals("stay", car.direction);
        assertEquals(0, car.speed);
        car.SetGear(1);
        assertEquals(1, car.gear);
        car.SetSpeed(25);
        assertEquals("forward", car.direction);
        assertEquals(25, car.speed);
        assertTrue(car.SetGear(0));
        car.SetGear(2);
        car.SetSpeed(40);
        assertTrue(car.SetGear(0));
        car.SetGear(3);
        car.SetSpeed(55);
        assertTrue(car.SetGear(0));
        car.SetGear(4);
        car.SetSpeed(70);
        assertTrue(car.SetGear(0));
        car.SetGear(5);
    }

    @Test
    public void reverseGearWorks() {
        car.TurnOnEngine();
        car.SetGear(-1);
        assertEquals("stay", car.direction);
        car.SetSpeed(10);
        car.SetGear(0);
        assertFalse(car.SetGear(1));
        assertFalse(car.SetGear(2));
        assertFalse(car.SetGear(3));
        assertFalse(car.SetGear(4));
        assertFalse(car.SetGear(5));
        car.SetSpeed(0);
        assertTrue(car.SetGear(1));
    }

    @Test
    public void testAll() {
        car.TurnOnEngine();
        car.SetGear(1);
        assertTrue(car.engineState);
        assertEquals(1, car.gear);
        assertFalse(car.SetSpeed(31));
        assertEquals("stay", car.direction);
        car.SetSpeed(10);
        assertEquals(10, car.speed);
        assertEquals("forward", car.direction);
        car.SetGear(0);
        assertEquals(0, car.gear);
        assertFalse(car.SetGear(2));
        assertEquals(0, car.gear);
        car.SetGear(1);
        car.SetSpeed(20);
        assertEquals("forward", car.direction);
        assertEquals(1, car.gear);
        assertEquals(20, car.speed);
        car.SetSpeed(30);
        assertEquals(30, car.speed);
        assertFalse(car.SetSpeed(40));
        assertEquals(30, car.speed);
        assertFalse(car.SetGear(-1));
        assertEquals("forward", car.direction);
        assertEquals(1, car.gear);
        car.SetGear(3);
        assertEquals(3, car.gear);
        assertFalse(car.SetSpeed(29));
        assertFalse(car.SetSpeed(61));
        car.SetGear(2);
        assertEquals(2, car.gear);
        assertFalse(car.SetSpeed(19));
        assertEquals(30, car.speed);
        assertFalse(car.SetSpeed(51));
        assertEquals(30, car.speed);
        car.SetGear(3);
        car.SetSpeed(60);
        assertEquals(3, car.gear);
        assertEquals(60, car.speed);
        car.SetGear(0);
        assertEquals(0, car.gear);
        assertFalse(car.SetSpeed(61));
        assertEquals(60, car.speed);
        car.SetSpeed(59);
        assertEquals(59, car.speed);
        car.SetSpeed(20);
        assertEquals(20, car.speed);
        car.SetSpeed(0);
        assertEquals(0, car.gear);
        assertFalse(car.SetSpeed(10));
        assertEquals(0, car.speed);
        car.SetGear(1);
        car.SetSpeed(10);
        assertEquals(1, car.gear);
        assertEquals(10, car.speed);
        assertFalse(car.TurnOffEngine());
        car.SetSpeed(0);
        assertEquals(0, car.speed);
        assertFalse(car.TurnOffEngine());
        car.SetGear(0);
        assertEquals(0, car.gear);
        car.TurnOffEngine();
        assertFalse(car.engineState);
        assertFalse(car.SetSpeed(10));
        assertFalse(car.SetGear(1));
        assertEquals(0, car.speed);
        assertEquals(0, car.gear);
    }
}

package lab4.figures;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testGreatestMassWorks() {
        List<Double> masses = new LinkedList<>();
        masses.add((double) 45);
        masses.add((double) 789);
        masses.add(34.543);
        masses.add(12.89);
        masses.add((double) 54);
        double mass = 789;
        assertEquals(mass, Main.greatestMass(masses), 0.001);
    }

    @Test
    public void testGetMassInWaterWorks() {
        double volume = 4;
        double massInWaterRight = 4000;
        assertEquals(massInWaterRight, Main.getMassInWater(volume), 0.001);
    }

    @Test
    public void testLowestMassWorks() {
        List<Double> masses = new LinkedList<>();
        masses.add(Main.getMassInWater(45));
        masses.add(Main.getMassInWater(789));
        masses.add(Main.getMassInWater(34.543));
        masses.add(Main.getMassInWater(12.89));
        masses.add(Main.getMassInWater(54));
        double mass = 12890;
        assertEquals(mass, Main.lowestMass(masses), 0.001);
    }
}

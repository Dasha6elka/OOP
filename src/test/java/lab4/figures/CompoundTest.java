package lab4.figures;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompoundTest {
    private Body cone = new Cone(2, 3, 4, 1, 1);
    private Body cone1 = new Cone(3, 4, 5, 1, 1);
    private Body cone2 = new Cone(4, 5, 6, 1, 1);
    private Compound compound = new Compound(0, 0, 0);

    @Test
    public void getMass() {
        compound.compoundFigures.add(cone);
        compound.compoundFigures.add(cone1);
        compound.compoundFigures.add(cone2);
        double actual = 15;
        assertEquals(compound.GetMass(), actual, 0.001);
    }

    @Test
    public void getVolume() {
        compound.compoundFigures.add(cone);
        compound.compoundFigures.add(cone1);
        compound.compoundFigures.add(cone2);
        double actual = 12;
        assertEquals(compound.GetVolume(), actual, 0.001);
    }

    @Test
    public void getDensity() {
        compound.compoundFigures.add(cone);
        compound.compoundFigures.add(cone1);
        compound.compoundFigures.add(cone2);
        double actual = 1.25;
        assertEquals(compound.GetDensity(), actual, 0.001);
    }
}

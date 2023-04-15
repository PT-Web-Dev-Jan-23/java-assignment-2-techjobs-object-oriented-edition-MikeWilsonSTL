package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job one = new Job();
        Job two = new Job();
        assertNotEquals(one.getId(), two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job acme = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(acme.getName() instanceof String);
        assertTrue(acme.getEmployer() instanceof  Employer);
        assertTrue(acme.getLocation() instanceof Location);
        assertTrue(acme.getPositionType() instanceof PositionType);
        assertTrue(acme.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(acme.getName(), "Product tester");
        assertEquals(acme.getEmployer().getValue(), "ACME");
        assertEquals(acme.getLocation().getValue(), "Desert");
        assertEquals(acme.getPositionType().getValue(), "Quality control");
        assertEquals(acme.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality() {
        Job one = new Job();
        Job two = new Job();

        assertFalse(one.equals(two));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job acme = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(acme.toString().charAt(0), '\n');
        assertEquals(acme.toString().charAt(acme.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job acme = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String desiredResult = "\nID: 5\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(acme.toString(), desiredResult);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job acme = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job empty = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String desiredACMEResult = "\nID: 3\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(acme.toString(), desiredACMEResult);
        assertEquals(empty.toString(), "OOPS! This job does not seem to exist.");
    }

}

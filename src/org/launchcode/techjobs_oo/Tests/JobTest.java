package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;
    Job testJob5;

    @Before
    public void createTestJobs(){
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJob5 = new Job("", new Employer(""), new Location("Desert"),
                new PositionType(""), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){

        assertEquals(1, testJob2.getId()-testJob1.getId(), 0);
    }

    @Test
    public void testJobConstructor(){
        assertEquals("Product Tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality Control", testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());

        assertTrue(testJob3 instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJob3.equals(testJob4));

    }

    @Test
    public void testToStringOutput(){
        assertTrue("First line should be blank", testJob3.toString().charAt(0) == ' ');
        assertTrue("Last line should be blank", testJob3.toString().charAt(testJob3.toString().length()-1) == ' ');

        String expectedString =
                " \n" +
                "ID: 3\n" +
                "Name: Product Tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality Control\n" +
                "Core Competency: Persistence\n" +
                " ";

        assertEquals(expectedString, testJob3.toString());

        String testBlanksString =
                        " \n" +
                        "ID: 5\n" +
                        "Name: Data not available\n" +
                        "Employer: Data not available\n" +
                        "Location: Desert\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Persistence\n" +
                        " ";

        assertEquals(testBlanksString, testJob5.toString());
    }
}


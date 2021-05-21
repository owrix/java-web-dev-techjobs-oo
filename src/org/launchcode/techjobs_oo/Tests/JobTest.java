package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import static org.junit.Assert.*;

public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;

    @Before
    public void createTestJobs(){
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product Tester", "ACME", "Desert", "Quality Control", "Persistence");
        testJob4 = new Job("Product Tester", "ACME", "Desert", "Quality Control", "Persistence");
    }

    @Test
    public void testSettingJobId(){

        assertEquals(1, testJob2.getId()-testJob1.getId(), 0);
    }

    @Test
    public void testJobConstructor(){
        assertEquals("Product Tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer());
        assertEquals("Desert", testJob3.getLocation());
        assertEquals("Quality Control", testJob3.getPositionType());
        assertEquals("Persistence", testJob3.getCoreCompetency());

        assertTrue(testJob3 instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJob3.equals(testJob4));

    }

    @Test
    public void testToStringOutput(){
        assertTrue("First line should be blank", testJob3.toString().charAt(0) == ' ');
//        assertTrue("Last line should be blank", testJob3.toString().charAt(testJob3.toString().length()-1) == ' ');

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



    }
}


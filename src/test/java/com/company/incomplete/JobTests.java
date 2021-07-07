package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JobTests {

    public Job job1 = new Job();
    public Job job2 = new Job();
    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
        Assertions.assertEquals(job1.getId() + 1, job2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Ice cream taster", new Employer("Comcast"), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Assertions.assertEquals("Ice cream taster", job.getName());
        Assertions.assertTrue(job.getEmployer() instanceof Employer);
        Assertions.assertEquals("Comcast", job.getEmployer().toString());
        Assertions.assertTrue(job.getLocation() instanceof Location);
        Assertions.assertEquals("Home", job.getLocation().toString());
        Assertions.assertTrue(job.getPositionType() instanceof PositionType);
        Assertions.assertEquals("UX", job.getPositionType().toString());
        Assertions.assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        Assertions.assertEquals("Tasting ability", job.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {
        Job sameJob = new Job("Ice cream taster", new Employer("Comcast"), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Job sameJob2 = new Job("Ice cream taster", new Employer("Comcast"), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Assertions.assertNotEquals(sameJob, sameJob2);
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        Job someJob = new Job("Ice cream taster", new Employer("Comcast"), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Assertions.assertEquals( someJob.toString().charAt(0), '\n');
        Assertions.assertEquals( someJob.toString().charAt(someJob.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        Job testJob = new Job("Ice cream taster", new Employer("Comcast"), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Assertions.assertEquals("\nID: " + testJob.getId()+ "\nName: Ice cream taster\nEmployer: Comcast\nLocation: Home\nPosition Type: UX\nCore Competency: Tasting ability\n", testJob.toString());
    }

    @Test
    public void testToStringDataNotAvailable() {
        Job emptyJob = new Job("Ice cream taster", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Assertions.assertEquals("\nID: " + emptyJob.getId() + "\nName: Ice cream taster\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", emptyJob.toString());


    }
}

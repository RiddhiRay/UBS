package com.ubs.opsit.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock = new TimeConverterImpl();
    private String theTime;

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }
    @When("the second is 0")
    public void whenTheSecondIs0() {
    }

    @Then("the yellow light should look like\nY")
    public void thenTheYellowLightShouldLookLikeY() {
    	assertThat(berlinClock.getSeconds(0)).isEqualTo("Y");
    }
    
    @Then("the first hours line should have no of lines\n4")
    public void thenTheFirstHoursLineShouldHaveNoOfLines4() {
      assertThat(berlinClock.getFirstLineHours(4).length()).isEqualTo(4);
    }
    
    @When("the hours is 24")
    public void whenTheHoursIs24() {
    }

    @Then("the first line hours should look like\nRRRR")
    public void thenTheFirstLineHoursShouldLookLikeRRRR() {
    	assertThat(berlinClock.getFirstLineHours(24)).isEqualTo("RRRR");
    }
    
    @Then("the second hours line should have no of lights\n4")
    public void thenTheSecondHoursLineShouldHaveNoOfLights4() {
    	assertThat(berlinClock.getSecondLineHours(4).length()).isEqualTo(4);
    }
    
    @When("the second line hours is 13")
    public void whenTheSecondLineHoursIs13() {
    }

    @Then("the second line hours should look like\nRRRO")
    public void thenTheSecondLineHoursShouldLookLikeRRRO() {
    	assertThat(berlinClock.getSecondLineHours(13)).isEqualTo("RRRO");
    }
    
    @Then("the first minutes line should have no of lights\n11")
    public void thenTheFirstMinutesLineShouldHaveNoOfLights11() {
    	assertThat(berlinClock.getFirstLineMinutes(34).length()).isEqualTo(11);
    }
    
    @Then("the sequence will be RRO")
    public void thenTheSequenceWillBeRRO() {
    	String str = berlinClock.getFirstLineMinutes(32);
    	assertThat(str.substring(2, 3)).isEqualTo("R");
    	assertThat(str.substring(5, 6)).isEqualTo("R");
    	assertThat(str.substring(8, 9)).isEqualTo("O");
    }
    
    @Then("the first minute line should look like this\nYYROOOOOOOO")
    public void thenTheFirstMinuteLineShouldLookLikeThisYYROOOOOOOO() {
    	assertThat(berlinClock.getFirstLineMinutes(17)).isEqualTo("YYROOOOOOOO");
    }
    
    @Then("the Second minutes line should have no of lights\n4")
    public void thenTheSecondMinutesLineShouldHaveNoOfLights4() {
    	assertThat(berlinClock.getSecondLineMinutes(4).length()).isEqualTo(4);
    }
    
    @Then("the second minute line should look like this\nYYOO")
    public void thenTheSecondMinuteLineShouldLookLikeThisYYOO() {
    	assertThat(berlinClock.getSecondLineMinutes(17)).isEqualTo("YYOO");
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }
}

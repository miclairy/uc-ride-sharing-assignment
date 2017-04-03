package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Data;
import model.StopPoint;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by cba62 on 3/04/17.
 */
public class searchSteps {

    StopPoint stop;
    StopPoint stopPoint;
    StopPoint stopPoint2;
    ObservableList<StopPoint> result = FXCollections.observableArrayList();
    ObservableList<StopPoint> searched = FXCollections.observableArrayList();


    @Given("^there is some stop points$")
    public void thereIsSomeStopPoints() {
        stop = new StopPoint(6, "Hare");
        stopPoint = new StopPoint(8, "Bear");
        stopPoint2 = new StopPoint(6, "Bear");
        Data.stopPointsList.add(stop);
        Data.stopPointsList.add(stopPoint);
        Data.stopPointsList.add(stopPoint2);

    }

    @When("^when I search for a stop point buy entering \"([^\"]*)\"$")
    public void whenISearchForAStopPointBuyEntering(String searchString) throws Throwable {
        searched = Data.stopPointsSearch(searchString);
    }

    @Then("^the search results should show (\\d+) hare street as a result\\.$")
    public void theSearchResultsShouldShowHareStreetAsAResult(int arg1) {
        result.add(stopPoint);
        result.add(stopPoint2);
        assertEquals(result.sorted(), searched);
        result.remove(stopPoint);
        result.add(stop);
        assertEquals(result.sorted(), Data.stopPointsSearch("6"));
    }

}

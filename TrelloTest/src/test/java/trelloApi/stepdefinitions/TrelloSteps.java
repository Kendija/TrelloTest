package trelloApi.stepdefinitions;
// option + enter - import some option in case of an error
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.ro.Cand;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import trelloApi.domain.Board;
import trelloApi.domain.List;
import trelloApi.helpers.TestCaseContext;

import static trelloApi.clients.TrelloClient.*;
import static trelloApi.constants.ProjectConstants.BOARD_ID;

public class TrelloSteps {
    @Given("The test board exists and contains the correct information")
    public void GetBoardAndCheckInfo(){
        Response resp = getBoardInfo();
        Board defaultBoard = resp.as(Board.class);
        System.out.println("Board id: " + defaultBoard.getId());
        System.out.println("Board name: " + defaultBoard.getName());
        Assertions.assertThat(defaultBoard.getId())
                .as("We assert that board id is correct")
                .isEqualTo(BOARD_ID);
        Assertions.assertThat(defaultBoard.getName())
                .as("We assert that board name is correct")
                .isEqualTo("Default");

        TestCaseContext.setBoard(defaultBoard);
    }
    @Then("I change the board title to {string}")
    public void ChangeBoardTitle(String name){
        Response resp = changeBoardName(name);
        Board board = resp.as(Board.class);
        TestCaseContext.setBoard(board);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are changing the name to " + name);
    }
    @Cand("I check that board name was updated to {string}")
    public void CheckBoardTitle(String name){
        Board testBoard = TestCaseContext.getBoard();

        Assertions.assertThat(testBoard.getName())
                .as("Checking if the Board name was updated")
                .isEqualTo(name);
    }
    @Then("I add list with title {string} to the board")
    public void AddListToBoard(String name){
        Response resp = createList(name);
        List myList = resp.as(List.class);
        TestCaseContext.setList(myList);
    }
}

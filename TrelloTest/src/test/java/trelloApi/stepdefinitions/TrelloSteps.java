package trelloApi.stepdefinitions;
// option + enter - import some option in case of an error
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.ro.Cand;

public class TrelloSteps {
    @Given("The test board exists and contains the correct information")
    public void GetBoardAndCheckInfo(){
        System.out.println("We check the board");
    }
    @Then("I change the board title to {string}")
    public void ChangeBoardTitle(String name){
        System.out.println("The new title is " + name);
    }
    @Cand("I check that board name was updated to {string}")
    public void CheckBoardTitle(String name){
        System.out.println("The new title is " + name);
    }
    @Then("I add list with title {string} to the board")
    public void AddListToBoard(String name){
        System.out.println("The new title is " + name);
    }
}

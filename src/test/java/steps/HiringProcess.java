package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

import static components.ComponentAwaiter.*;

public class HiringProcess {
    private JSONObject response;
    private JSONArray array;
    private JSONArray newArray;

    @Given("a GET is performed on the endpoint {string}")
    public void a_get_is_performed_on_the_endpoint(String endpoint) {
        String InitJSON = ExecuteRequest(endpoint);
        response = new JSONObject(InitJSON);
    }

    @When("validates which candidates are over {int} years old to go to the first process")
    public void validates_which_candidates_are_over_years_old_to_go_to_the_first_process(Integer number) {
        array = response.getJSONArray("applicants");
        for (Object applicants : array) {
            if (applicants instanceof JSONObject) {
                int age = ((JSONObject) applicants).getInt("age");
                if (age > number) {
                    Object list = ((JSONObject) applicants).get("name");
                    System.out.println("The candidate " + list + " passed the first selection because it has " + age + " years");
                }
            }
        }
    }

    @When("which candidates have as true in the area of experience for the second process")
    public void which_candidates_have_as_true_in_the_area_of_experience_for_the_second_process() {
        array = response.getJSONArray("applicants");
        for (Object applicants : array) {
            if (applicants instanceof JSONObject) {
                int age = ((JSONObject) applicants).getInt("age");
                Object experience = ((JSONObject) applicants).get("experience");
                if (age > 18 && experience.equals(true)) {
                    Object list = ((JSONObject) applicants).get("name");
                    System.out.println("The candidate " + list + " passed the second selection because he has experience with true and " + age + " years");
                }
            }
        }
    }

    @Then("and which candidates fall under the rules of the companies")
    public void and_which_candidates_fall_under_the_rules_of_the_companies() {
        array = response.getJSONArray("companies");
        newArray = response.getJSONArray("applicants");
        for (Object companies : array) {
            if (companies instanceof JSONObject) {
                String companyName = ((JSONObject) companies).getString("name");
                int minAge = ((JSONObject) companies).getInt("min_age");
                int maxSalary = ((JSONObject) companies).getInt("max_salary");
                for (Object applicants : newArray) {
                    if (applicants instanceof JSONObject) {
                        int desiredSalary = ((JSONObject) applicants).getInt("desired_salary");
                        int age = ((JSONObject) applicants).getInt("age");
                        Object experienceS = ((JSONObject) applicants).get("experience");
                        if (age > 18 && experienceS.equals(true)) {
                            if (desiredSalary <= maxSalary && age >= minAge) {
                                String candidateName = (String) ((JSONObject) applicants).get("name");
                                System.out.println("Candidate " + candidateName + " is eligible for company " + companyName);
                            }
                        }
                    }
                }
            }
        }
    }


}

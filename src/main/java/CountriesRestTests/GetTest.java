package CountriesRestTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.get;

import com.jayway.restassured.response.Response;
import org.json.JSONArray; 
import org.json.JSONException; 

public class GetTest {


	@Test
	public void getRequestFindCapital() throws JSONException {
		
		//make get request to fetch capital of norway
		Response resp = get("http://restcountries.eu/rest/v1/name/norway");
		
		JSONArray jsonResponse = new JSONArray(resp.asString());
		
		//Fetching value of capital parameter
		String capital = jsonResponse.getJSONObject(0).getString("capital");
		
		//Asserting that capital of Norway is Oslo
		AssertJUnit.assertEquals(capital, "Oslo");
	}
}

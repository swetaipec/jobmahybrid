package testcases;

//import java.awt.List;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpResponse;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class LinksCheck
{

	WebDriver driver;
	private int invalidLinksCount;

	public LinksCheck(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void validateInvalidLinks() {

		try {

			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are "
					+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript"))
					{
						verifyURLStatus(url);
					} 
					else
					{
						invalidLinksCount++;
					}
				}
			}

			System.out.println("Total no. of invalid links are "+ invalidLinksCount);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public void verifyURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = (HttpResponse) client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
			if (((org.apache.http.HttpResponse) response).getStatusLine().getStatusCode() != 200)
				invalidLinksCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






}

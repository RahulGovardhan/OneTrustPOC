package requirement;

import lib.data.TestData.CareersData;
import lib.data.TestData.HomePageData;
import lib.module.Module;
import lib.page.CareersPage;
import lib.page.HomePage;
import org.testng.annotations.Test;
import configuration.Configuration;

public class OneTrust extends Configuration{

	@Test
	public void FetchCurrentOpenings()throws Exception{

    	HomePage home = new HomePage(super.driver, super.wait);
    	Module module = new Module(super.driver, super.wait);
    	CareersPage careers = new CareersPage(super.driver, super.wait);
    	
    	home.lauchUrl(HomePageData.URL)
    		.verifyTitle(HomePageData.TITLE);
    	
    	module.navigateToCarriers();
    	
    	careers.verifyTitle(CareersData.TITLE)
    		   .getCurrentOpenings(CareersData.Countries.ATLANTA)
    		   .getCurrentOpenings(CareersData.Countries.FRANKFURT)
    		   .getCurrentOpenings(CareersData.Countries.LONDON)
    		   .getCurrentOpenings(CareersData.Countries.SAN_FRANSISCO)
    		   .getCurrentOpenings(CareersData.Countries.SINGAPORE)
    		   .getCurrentOpenings(CareersData.Countries.TORONTO);
    }
}

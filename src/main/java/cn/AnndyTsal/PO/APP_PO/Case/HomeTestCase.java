/**
 * 测试用例
 * */
package cn.AnndyTsal.PO.APP_PO.Case;

import java.util.Map;

import org.testng.annotations.Test;

import cn.AnndyTsal.PO.APP_PO.Base.DriverBase;
import cn.AnndyTsal.PO.APP_PO.Buss.HomeBuss;

public class HomeTestCase extends CaseBase{
	
	private DriverBase driver;
	private HomeBuss hb;
	
	public HomeTestCase(){
		
		this.driver = initDriver();		
		hb = new HomeBuss(driver);	
	}
	
	@Test
	public void extCase(){
		
		Map<Integer, String> buss = hb.homeBuss();
		
		System.out.println(buss.toString());
		
		driver.close();
	}

}

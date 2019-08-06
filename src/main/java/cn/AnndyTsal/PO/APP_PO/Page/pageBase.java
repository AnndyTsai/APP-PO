/**
 * Page页面的基类 所有页面都需要继承
 * */
package cn.AnndyTsal.PO.APP_PO.Page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.AnndyTsal.PO.APP_PO.Base.DriverBase;
import io.appium.java_client.MobileElement;

public class pageBase {
	
	private static final Logger log = LogManager.getLogger(pageBase.class.getName());
	private DriverBase driver;

	/**
	 * 构造方法 初始化DriverBase对象
	 */
	public pageBase(DriverBase driver) {
		
		this.driver = driver;
	}

	/**
	 * element方法
	 */
	public MobileElement element(By by) {

		return driver.findMobileElement(by);
	}
	
	/**
	 * element集合的方法
	 */
	public List<MobileElement> elements(By by) {

		return driver.findMobileElements(by);
	}

	/**
	 * 封装click方法
	 */
	public void click(MobileElement element) {

		element.click();
	}

	/**
	 * 封装sendkeys方法
	 */
	public void sendKeys(MobileElement element, String value) {

		element.clear();
		element.sendKeys(value);
		log.info("[Class-pageBase][Method-sendKeys] "+element.toString()+"元素输入"+value);

	}

	/**
	 * 封装滑动的操作
	 */
	public void driverSwipe(int startx, int starty, int endx, int endy) {
		
		log.info("[Class-pageBase][Method-driverSwipe] 滑动坐标从["+startx+" "+starty+"]-->["+endx+" "+endy+"]");
		
		driver.driverSwipe(startx, starty, endx, endy);
	}

	/**
	 * 封装获取APP高度 宽度的操作
	 * 
	 * @return List集合长度为2*n 基数表示X轴宽度； 偶数表示Y轴 高度
	 */
	public List<Integer> getWidthAndHeight() {
		
		log.info("[Class-pageBase][Method-getWidthAndHeight] 获取到分辨率为："+driver.getXY().toString());

		return driver.getXY();
	}

	/**
	 * 关闭APP
	 */
	public void closeAPP() {
		
		driver.close();
		log.info("[Class-pageBase][Method-closeAPP] 关闭APP，结束当前执行...");
	}

	/**
	 * 对APP坐标的长按操作
	 */
	public void LongPressPoint(int x, int y, int duration) {

		driver.LongPressPoint(x, y, duration);
		log.info("[Class-pageBase][Method-LongPressPoint] 对坐标["+x+","+y+"]进行长按操作，延时"+duration+"毫秒");
	}

	/**
	 * 对元素进行长按操作
	 */
	public void LongPressElement(MobileElement element, int duration) {

		driver.LongPressElement(element, duration);
		log.info("[Class-pageBase][Method-LongPressPoint] 对元素"+element.toString()+"进行长按操作，延时"+duration+"毫秒");
	}

	/**
	 * 对坐标进行点击
	 */
	public void tapPoint(int fingers, int x, int y, int duration) {

		driver.driverTap(fingers, x, y, duration);
		log.info("[Class-pageBase][Method-LongPressPoint] "+fingers+"根手指对坐标["+x+","+y+"]进行点击操作，延时"+duration+"毫秒");
	}

	/**
	 * 对元素进行点击操作
	 */
	public void tapElement(int fingers, MobileElement element, int duration) {

		driver.driverTap(fingers, element, duration);
		log.info("[Class-pageBase][Method-LongPressPoint] "+fingers+"根手指对元素"+element.toString()+"进行点击操作，延时"+duration+"毫秒");
	}
}

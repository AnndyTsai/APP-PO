/**
 * Home页面的操作层
 * */
package cn.AnndyTsal.PO.APP_PO.Handle;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.AnndyTsal.PO.APP_PO.Base.DriverBase;
import cn.AnndyTsal.PO.APP_PO.Buss.HomeBuss;
import cn.AnndyTsal.PO.APP_PO.Page.homePage;
import io.appium.java_client.MobileElement;

public class HomeHandle {

	private homePage hp;
	private static final Logger log = LogManager.getLogger(HomeHandle.class.getName());

	public HomeHandle(DriverBase driver) {

		hp = new homePage(driver);
	}

	/**
	 * 点击"允许"授权操作
	 */
	public void clickAllowed() {
		
		MobileElement allowed = hp.isAllowed();
		
		if (allowed == null) {

			log.info("[Class-HomeHandle][Method-clickAllowed] isAllowed元素为空");

		} else {

			hp.click(allowed);
		}
	}

	/**
	 * 点击"我同意"授权操作
	 */
	public void clickAgree() {
		
		MobileElement note = hp.note();
		
		if (note == null) {

			log.info("[Class-HomeHandle][Method-clickAgree] note元素为空");

		} else {

			hp.click(note);
		}
	}

	/**
	 * 点击"热榜"
	 */
	public void clickHotTopics() {
		
		MobileElement hotTopics = hp.hotTopics();

		if (hotTopics == null) {

			log.info("[Class-HomeHandle][Method-hotTopics] hotTopics元素为空");

		} else {

			hp.click(hotTopics);
		}
	}

	/**
	 * 点击"全站"
	 */
	public void clickAllTopics() {
		
		MobileElement allTopics = hp.allTopics();

		if (allTopics == null) {

			log.info("[Class-HomeHandle][Method-allTopics] allTopics元素为空");

		} else {

			hp.click(allTopics);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 点击"top10TopicsNo"
	 */
	public List<List<String>> top10Topics() {

		List<MobileElement> top10TopicsNo = hp.top10TopicsNo();
		List<MobileElement> top10TopicsTitle = hp.top10TopicsTitle();
		
		List<List<String>> list = new ArrayList<>();

		List<String> top10TopicsNoList = new ArrayList<>();
		List<String> top10TopicsTitleList = new ArrayList<>();

		if (top10TopicsNo == null && top10TopicsTitle == null) {

			log.info("[Class-HomeHandle][Method-top10Topics] top10TopicsNo或者top10TopicsTitle元素为空");

		} else {
			for (int i = 0; i < top10TopicsNo.size(); i++) {

				top10TopicsNoList.add(top10TopicsNo.get(i).getText());
				top10TopicsTitleList.add(top10TopicsTitle.get(i).getText());
			}
		}

		list.add(top10TopicsNoList);
		list.add(top10TopicsTitleList);

		return list;
	}
	
	/**
	 * 向下滑动的操作
	 * */
	public void Swipe(){
		
		List<Integer> widthAndHeight = hp.getWidthAndHeight();
		int X = widthAndHeight.get(0);
		int Y = widthAndHeight.get(1);
		log.info("[Class-HomeHandle][Method-Swipe] 获取到的屏幕分辨率为["+X+"X"+Y+"]");
		
		//滑动Y轴 从(8/10)*Y 滑动到 (2/10)*Y
		log.info("[Class-HomeHandle][Method-Swipe] 滑动坐标从["+X/2+" "+5*Y/10+"]-->["+X/2+" "+3*Y/10+"]");
		hp.driverSwipe(X/2, 5*Y/10, X/2, 3*Y/10);
	}

}

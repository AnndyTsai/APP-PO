/**
 * Home主界面的元素Element对象
 * */
package cn.AnndyTsal.PO.APP_PO.Page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.AnndyTsal.PO.APP_PO.Base.DriverBase;
import cn.AnndyTsal.PO.APP_PO.Base.by;
import io.appium.java_client.MobileElement;

public class homePage extends pageBase {
	
	private static final Logger log = LogManager.getLogger(homePage.class.getName());

	
	private MobileElement allowedElement = null;
	private by by;
	private MobileElement note;
	private MobileElement hotTopics;
	private MobileElement allTopics;
	private List<MobileElement> top10TopicsTitle;
	private List<MobileElement> top10TopicsNo;

	public homePage(DriverBase driver) {
		super(driver);
		this.by = new by("./config/homePage.properties");
	}
	
	/**
	 * 进入Home也页面前的授权操作的element对象
	 * */
	public MobileElement isAllowed(){
		
		try{
			
			allowedElement = element(by.by("isAllowed"));
			log.info("[Class-homePage][Method-isAllowed] note元素为"+allowedElement.toString());
			
		}catch(Exception e){
			
			log.info("[Class-homePage][Method-isAllowed] 未定位到元素");
		}
		
		return allowedElement;
	}
	/**
	 * 进入Home也页面的隐私保护指引
	 * */
	public MobileElement note(){
		
		try{
			
			note = element(by.by("note"));
			log.info("[Class-homePage][Method-note] note元素为"+note.toString());
			
		}catch(Exception e){
			
			log.info("[Class-homePage][Method-note] 未定位到元素");
		}
		
		return note;
	}
	
	/**
	 * home页面的"热榜"
	 * */
	public MobileElement hotTopics(){
		
		try{
			
			hotTopics = element(by.by("hotTopics"));
			log.info("[Class-homePage][Method-hotTopics] hotTopics元素为"+hotTopics.toString());
			
		}catch(Exception e){
			
			log.info("[Class-homePage][Method-hotTopics] hotTopics未定位到元素");
		}
		
		return hotTopics;
	}
	
	/**
	 * home页面的"热榜"->"全站"
	 * */
	public MobileElement allTopics(){
		
		try{
			
			allTopics = element(by.by("allTopics"));
			log.info("[Class-homePage][Method-allTopics] allTopics元素为"+allTopics.toString());
			
		}catch(Exception e){
			
			log.info("[Class-homePage][Method-allTopics] allTopics未定位到元素");
		}
		
		return allTopics;
	}
	
	/**
	 * home页面的"热榜"->"全站"->热搜排名前10的topics的title
	 * */
	public List<MobileElement> top10TopicsTitle(){
		
		try{
			
			top10TopicsTitle = elements(by.by("top10TopicsTitle"));
			log.info("[Class-homePage][Method-top10TopicsTitle] top10TopicsTitle元素为"+top10TopicsTitle.toString());
		}catch(Exception e){
			
			log.info("[Class-homePage][Method-top10TopicsTitle] top10TopicsTitle未定位到元素");
		}
		
		return top10TopicsTitle;
	}
	
	/**
	 * home页面的"热榜"->"全站"->热搜排名前10的topics的编号
	 * */
	public List<MobileElement> top10TopicsNo(){
		
		try{
			
			top10TopicsNo = elements(by.by("top10TopicsNo"));
			log.info("[Class-homePage][Method-top10TopicsNo] top10TopicsNo元素为"+top10TopicsNo.toString());
			
		}catch(Exception e){
			
			log.info("[Class-homePage][Method-top10TopicsNo] top10TopicsNo未定位到元素");
		}
		
		return top10TopicsNo;
	}
}

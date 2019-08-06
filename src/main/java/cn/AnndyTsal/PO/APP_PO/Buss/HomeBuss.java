/**
 * Home页面的业务层
 * */
package cn.AnndyTsal.PO.APP_PO.Buss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.AnndyTsal.PO.APP_PO.Base.DriverBase;
import cn.AnndyTsal.PO.APP_PO.Handle.HomeHandle;

public class HomeBuss {

	private HomeHandle hd;
	private static final Logger log = LogManager.getLogger(HomeBuss.class.getName());

	public HomeBuss(DriverBase driver) {

		hd = new HomeHandle(driver);
	}

	/**
	 * 业务操作的顺序
	 */
	public Map<Integer, String> homeBuss() {

		int i = 0;

		Map<Integer, String> topics = new HashMap<>();
		hd.clickAllowed();
		//hd.clickAgree();
		hd.clickHotTopics();
		hd.clickAllTopics();
		
		//List<List<String>> top10Topics = hd.top10Topics();	
		while (i <= 1000) {
			
			List<List<String>> top10Topics = hd.top10Topics();
						
			for (int j = 0; j < top10Topics.get(0).size(); j++) {
				
				topics.put(Integer.parseInt(top10Topics.get(0).get(j)), top10Topics.get(1).get(j));			
				
			}			
			log.info("[Class-HomeBuss][Method-buss] 执行第"+i+"次滑动，top10TopicsNo为："+topics.size());
			
			if(topics.size() > 10){
				
				break;
			}
			
			hd.Swipe();
			
			i++;
		}

		return topics;
	}

}

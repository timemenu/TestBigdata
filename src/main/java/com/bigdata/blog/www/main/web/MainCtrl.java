/**
 * 
 */
package com.bigdata.blog.www.main.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bigdata.blog.www.main.service.MainSvc;

/**
 * @author 	: quickmenu
 * @Date	: 2015. 6. 20.
 * @Type	: bigdata
 * @Version	: 1.0
 */
@Controller
public class MainCtrl {

	private static final Logger logger = LoggerFactory.getLogger(MainCtrl.class);
	
	@Autowired
	MainSvc mainSvc;
	
	/**
	 * 메인 페이지 입니다.
	 * @return
	 */
	@RequestMapping(value="/bigdata/main.do")
	public ModelAndView main(HttpServletRequest request) {
		logger.error("quickmenu");
		return null;
	}
	
	@RequestMapping(value="/bigdata/realtime.do")
	public ModelAndView realTime(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("content/main");
		return mav;
	}
	
	@RequestMapping(value="bigdata/logdata.do")
	public @ResponseBody int logData(HttpServletResponse response) throws Exception{
		return mainSvc.getCount();
	}
}

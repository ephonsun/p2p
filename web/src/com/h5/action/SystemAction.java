package com.h5.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.cslc.dao.activity.Activity;
import com.cslc.dao.activity.ActivityDao;
import com.cslc.dao.feedback.Feedback;
import com.cslc.dao.feedback.FeedbackDao;
import com.cslc.dao.question.Question;
import com.cslc.dao.question.QuestionDao;
import com.cslc.dao.score.ScoreDao;
import com.platform.base.BaseAction;
import com.platform.constant.SystemConstant;
import com.platform.util.StringUtil;
import com.platform.util.encrypt.AES;

@ParentPackage("web")
public class SystemAction extends BaseAction {
	@Resource
	private ActivityDao activityDao;

	@Resource
	private ScoreDao scoreDao;
	
	@Resource
	private FeedbackDao feedbackDao;

	@Resource
	private QuestionDao questionDao;
	// 注册成功
	@Action("registsuccess")
	public String registsuccess() {

		return layout(null, null, "注册成功", "/h5/registsuccess.ftl", SystemConstant.LAYOUT_H5);
	}

	// 支付成功
	@Action("paysuccess")
	public String paysuccess() {

		return layout(null, null, "支付成功", "/h5/paysuccess.ftl", SystemConstant.LAYOUT_H5);
	}
	
	
	//有奖活动
		@Action("activity")
		public String activity() {
			Map<String, Object> map = new HashMap<String, Object>();
			  map.put("orderBy", "createtime desc");

			List<Activity> list = activityDao.select(map);
			List<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
			for(Activity activity : list){
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("endtime", StringUtil.convertDateToString(activity.getEndtime(), "yyyy-MM-dd"));
				m.put("starttime", StringUtil.convertDateToString(activity.getStarttime(), "yyyy-MM-dd"));
				m.put("status", activity.getStatus());
				m.put("title", activity.getTitle());
				m.put("img", activity.getImg());
				m.put("share", activity.getShare());
				m.put("url", activity.getUrl());
				alist.add(m);
			}
			request.setAttribute("records", alist);

			return layout(null, null, "有奖活动", "/h5/activity.ftl", SystemConstant.LAYOUT_H5);
		}
	
  
	
	
	
	
	//关于我们
	@Action("about")
	public String about() {

		return layout(null, null, "关于我们", "/h5/about.ftl", SystemConstant.LAYOUT_H5);
	}
	
	//意见反馈
	@Action("suggest")
	public String suggest() {
		
    String login = request.getHeader("login");
    String code = request.getHeader("code");
      
//      String login = getParameter("login");
//      String code =getParameter("code");

      if (null != code && !"".equals(code) && "0".equals(login)) {
          String saccountid = AES.decryptFromBase64(((String) code).replace(" ", "+"),SystemConstant.ACTIVITY_KEY);
            Long accountid = Long.valueOf(saccountid);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("accountid", accountid);
            map.put("orderBy", "createtime desc");
            List<Feedback> list =  feedbackDao.select(map);
            List<Map<String, Object>> blist = new ArrayList<Map<String, Object>>();
            for(Feedback back : list){
            	Map<String, Object> m = new HashMap<String, Object>();
            	m.put("createtime", back.getCreatetime());
            	m.put("reply", back.getReply());
            	m.put("question", back.getQuestion());
            	m.put("replytime", back.getReplytime());
            	m.put("status", back.getStatus());
            	blist.add(m);
            }
            
            
	        request.setAttribute("records", blist);
	        request.setAttribute("login", login);
	        request.setAttribute("code", code);

	    }

      return layout(null, null, "意见反馈", "/h5/suggest.ftl", SystemConstant.LAYOUT_H5);
	}
	
	
	
	//意见提交
	@Action("submitsuggest")
	public String submitsuggest() {
		String login = request.getParameter("login");
		String code = request.getParameter("code");
//    	String login = request.getHeader("login");
//		String code = request.getHeader("code");
        String question = getParameter("question");
        if (null != code && !"".equals(code) && "0".equals(login)) {
            String saccountid = AES.decryptFromBase64(((String) code).replace(" ", "+"),SystemConstant.ACTIVITY_KEY);
              Long accountid = Long.valueOf(saccountid);
              Feedback back = new Feedback();
              back.setAccountid(accountid);
              back.setCreatetime(new Date());
              back.setChannel(Feedback.CHANNEL_APP);
              back.setQuestion(question);
              back.setStatus(Feedback.STATUS_NOT_REPLY);
              feedbackDao.insert(back);
        }
        
        
        return redirect("/suggest.html?login="+login+"&code="+code);
	}
	
	
	
	
	//常见问题
		@Action("question")
		public String question() {
			List<Question> categoryList = new ArrayList<Question>();
			
			List<Map<Byte, String>> cl = Question.getCategoryList();
			for(Map<Byte, String> m : cl){
				for (Byte key : m.keySet()) {  
					Question cat = new Question();
					cat.setQuestion(m.get(key));
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("status", Question.STATUS_ENABLE);
					map.put("category", key);
					map.put("orderBy", "serialno asc");
					List<Question> list = questionDao.select(map);
					cat.setList(list);
					categoryList.add(cat);
				}  
			}
			
      
		        request.setAttribute("records", categoryList);


	      return layout(null, null, "意见反馈", "/h5/question.ftl", SystemConstant.LAYOUT_H5);
		}
		
		
		
		
	
}

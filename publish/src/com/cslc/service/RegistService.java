package com.cslc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cslc.dao.account.Account;
import com.cslc.dao.account.AccountDao;
import com.cslc.dao.accountasset.Accountasset;
import com.cslc.dao.accountasset.AccountassetDao;
import com.cslc.dao.accountconfig.Accountconfig;
import com.cslc.dao.accountconfig.AccountconfigDao;
import com.platform.constant.SystemConstant;
import com.platform.util.MD5Util;
import com.platform.util.StringUtil;
import com.platform.util.UUIDUtil;

@Service("registService")
public class RegistService {
	
	@Resource
	private AccountDao accountDao;
	
	@Resource
	private AccountassetDao accountassetDao;
	
	@Resource
	private AccountconfigDao accountconfigDao;
	
	public String regist(String mobile, String loginpwd, String channel, String invitecode, Map<String, String> uaMap){
		// 手机号
		Map<String, Object> amap = new HashMap<String, Object>();
		amap.put("mobile", mobile);
		if(accountDao.selectCount(amap) > 0){
			return "mobileError";
		}
		
		// 邀请人
		Long inviteid = null;
		if(StringUtil.isNotBlank(invitecode)){
			Map<String, Object> cmap = new HashMap<String, Object>();
			cmap.put("invitecode", invitecode);
			List<Account> alist = accountDao.select(cmap);
			if(alist.size() > 0){
				inviteid = alist.get(0).getId();
			}else{
				return "invitecodeError";
			}
		}
		
		// 生成邀请码
		String myinvitecode = null;
		for(int i = 0; i < 20; i ++){
			String randominvitecode = StringUtil.getRandomCode(5, false, true);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("invitecode", randominvitecode);
			long count = accountDao.selectCount(m);
			if(count == 0){
				myinvitecode = randominvitecode;
				break;
			}
		}
		
		// 初始化账户
		Account a = new Account();
		a.setCategory(Account.CATEGORY_USER);
		a.setStatus(Account.STATUS_NORMAL);
		a.setMobile(mobile);
		a.setInvitecode(myinvitecode);
		a.setInviteid(inviteid);
		a.setDynamicpwd(UUIDUtil.get().substring(0, 16));
		a.setLastlogintime(new Date());
		a.setLoginpwd(MD5Util.encrypt(loginpwd + SystemConstant.LOGINPWD_KEY));
		a.setChannel(channel);
		a.setCreatetime(new Date());
		accountDao.insert(a);
		
		Accountasset asset = new Accountasset();
		asset.setAccountid(a.getId());
		accountassetDao.insert(asset);
		
		Accountconfig config = new Accountconfig();
		config.setAccountid(a.getId());
		if(uaMap != null){
			config.setPhone(uaMap.get("phone"));
			config.setPlatform(uaMap.get("platform"));
			config.setRom(uaMap.get("rom"));
			config.setTerminalid(uaMap.get("terminalid"));
			config.setVersion(uaMap.get("version"));
		}
		accountconfigDao.insert(config);
		return String.valueOf(a.getId());
	}
	
}


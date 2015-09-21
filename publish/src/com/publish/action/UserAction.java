package com.publish.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.cslc.dao.account.Account;
import com.cslc.dao.account.AccountDao;
import com.cslc.dao.accountconfig.Accountconfig;
import com.cslc.dao.accountconfig.AccountconfigDao;
import com.cslc.service.LoginService;
import com.platform.base.BaseAction;
import com.platform.constant.SystemConstant;
import com.platform.util.StringUtil;
import com.publish.CookieUtil;
import com.publish.interceptor.Department;

@ParentPackage("web")
@Namespace("/")
public class UserAction extends BaseAction {

    @Resource
    private AccountDao accountDao;

    @Resource
    private LoginService loginService;

    @Resource
    private AccountconfigDao accountconfigDao;

    @Action("to_login")
    public String toLogin() {
        String url = getParameter("url");
        request.setAttribute("url", url);
        return layout(null, null, "登录", "/user/to_login.ftl", SystemConstant.LAYOUT_ADMIN);
    }

    @Action("login")
    public String login() {
        String mobile = getParameter("mobile");
        String password = request.getParameter("password");
        String url = getParameter("url");

        request.setAttribute("mobile", mobile);

        Account account = loginService.login(mobile, password);
        if (account != null && account.getCategory() == Account.CATEGORY_EMPLOYER) {
            CookieUtil.setUserCookie(account, response);
            if (StringUtil.isBlank(url)) {
            	url = "/admincslc/index.html";
            }
            return redirect(url);
        }
        request.setAttribute("url", url);
        request.setAttribute("errorMsg", "登录失败");
        return layout(null, null, "登录", "/user/to_login.ftl", SystemConstant.LAYOUT_ADMIN);
    }

    @Action("logout")
    public String logout() {
        CookieUtil.delUserCookie(request, response);
        return redirect("/to_login.html");
    }

}

package com.publish.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cslc.dao.account.Account;
import com.cslc.dao.account.AccountDao;
import com.cslc.dao.accountconfig.Accountconfig;
import com.cslc.dao.accountconfig.AccountconfigDao;
import com.cslc.dao.systemdef.Systemdef;
import com.cslc.dao.systemdef.SystemdefDao;
import com.cslc.service.BizService;
import com.cslc.service.LoginService;
import com.platform.base.BaseAction;
import com.platform.constant.SystemConstant;
import com.platform.util.StringUtil;
import com.publish.CookieUtil;
import com.publish.interceptor.Department;

@ParentPackage("web")
@Namespace("/admincms")
public class CmsAction extends BaseAction {

    @Resource
    private AccountDao accountDao;
    
    @Resource
    private SystemdefDao systemdefDao;
    
    @Resource
    private BizService bizService;


    
    /**
     * 显示当前banner
     * 
     * @return
     */
    @Action("selectbanner")
    public String selectBanner() {
        List<Map<String,Object>> list =(List<Map<String, Object>>) JSON.parse(bizService.getSystemval(Systemdef.BANNERS));
        Collections.reverse(list);
        String message = request.getParameter("message");

        request.setAttribute("list", list);
        request.setAttribute("message", message);
        return layout("cms", "selectbanner", "上架banners详情", "/cms/banner.ftl", SystemConstant.LAYOUT_ADMIN);

    }

    /**
     * 上传Banner
     */
//    @Action("insertbanner")
//    public String insertBanner() {
//        String fileurl = uploadimage("/banners", upload, uploadFileName, null);
//
//        return redirect("/changepage/selectbanner.html?fileurl=" + fileurl);
//    }

    /**
     * 修改banner
     * 
     * @return
     */
    @Action("modifybanner")
    public String modifyBanner() {
        // 1、获取所有规则条件字段
        String[] imageUrls = request.getParameterValues("imageUrls");
        String[] linkUrls = request.getParameterValues("linkUrls");

        int matrixSize = imageUrls.length;
        List<Map<String,Object>> bannerList = new ArrayList<Map<String,Object>>();
        for (int i = matrixSize - 1; i >= 0; i--) {
        	Map<String,Object> map = new HashMap<String,Object>();
            if (imageUrls[i] == "" || null == imageUrls[i] || linkUrls[i] == "" || null == linkUrls[i]) {
                String error = "图片地址和banner链接不能为空";
                List<Map<String,Object>> list = (List<Map<String,Object>>) bizService.getSystemjson(Systemdef.BANNERS);
                
                Collections.reverse(list);
                request.setAttribute("list", list);
                request.setAttribute("error", error);
                return layout("cms", "selectbanner", "上架banners详情", "/cms/cms_selectBanner.ftl",
                              SystemConstant.LAYOUT_ADMIN);

            }
       
            map.put("imageUrls", imageUrls[i]);
            map.put("linkUrls", linkUrls[i]);

            bannerList.add(map);
        }

        String systemkey = Systemdef.BANNERS;
        String systemValue = JSON.toJSONString(bannerList);

        Systemdef def = new Systemdef();
        def.setK(systemkey);
        def.setV(systemValue);
        systemdefDao.update(def);

        return redirect("/admincms/selectbanner.html?message=1");

    }

    /**
     * 显示当前启动页面
     * 
     * @return
     */
    @Action("selectstartpage")
    public String selectStartpage() {

        Map<String, Object> startimagemap = bizService.getSystemjson(Systemdef.APP_START_IMAGE);
        
        String android = (String) startimagemap.get("android");
        String ios = (String) startimagemap.get("ios");
        request.setAttribute("android", android);
        request.setAttribute("ios", ios);
        return layout("cms", "selectstartpage", "配置启动页面", "/cms/startpage.ftl", SystemConstant.LAYOUT_ADMIN);

    }
//
//    /**
//     * 上传启动页面
//     */
//    @Action("insertstartpage")
//    public String insertStartpage() {
//        String imagetype = request.getParameter("imagetype");
//
//        String fileurl = uploadimage("/images/startpage", upload, uploadFileName, imagetype);
//
//        return redirect("/changepage/selectstartpage.html?fileurl=" + fileurl);
//
//    }
//
//    private String uploadimage(String folderName, File file, String fileName, String imagetype) {
//        Date date = new Date();
//        String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
//        String filename = StringUtil.convertDateToString(date, "yyyyMMddHHmmss") + suffix;
//        if ("2".equals(imagetype)) {
//            filename = StringUtil.convertDateToString(date, "yyyyMMddHHmmss") + "_android" + suffix;
//        }
//        if ("1".equals(imagetype)) {
//            filename = StringUtil.convertDateToString(date, "yyyyMMddHHmmss") + "_ios" + suffix;
//        }
//        String filepath = folderName + "/" + filename;
//
//        FileOutputStream fos = null;
//        FileInputStream fis = null;
//        try {
//            File folder = new File(SystemConstant.DDSC_IMAGE_LOCATION + folderName);
//            if (!folder.exists()) {
//                folder.mkdirs();
//            }
//            fos = new FileOutputStream(SystemConstant.DDSC_IMAGE_LOCATION + filepath);
//            fis = new FileInputStream(file);
//            byte[] buffer = new byte[1024];
//            int len = 0;
//            while ((len = fis.read(buffer)) > 0) {
//                fos.write(buffer, 0, len);
//            }
//        } catch (Exception e) {
//            return null;
//        } finally {
//            IOUtils.closeQuietly(fos);
//            IOUtils.closeQuietly(fis);
//        }
//        return filepath;
//    }
//
    /**
     * 修改启动页面
     * 
     * @return
     */
    @Action("modifystartpage")
    public String modifyStartpage() {
        String android = request.getParameter("android");
        String ios = request.getParameter("ios");

        String systemkey = Systemdef.APP_START_IMAGE;
        Map<String, Object> startpageMap = new HashMap<String, Object>();

        startpageMap.put("android", android);
        startpageMap.put("ios", ios);
        Systemdef def = new Systemdef();

        String systemValue = JSON.toJSONString(startpageMap);
        def.setK(systemkey);
        def.setV(systemValue);
        systemdefDao.update(def);

        return redirect("/admincms/selectstartpage.html");

    }


    /**
     * 显示配置公告
     * 
     * @return
     */
    @Action("selectwarnning")
    public String selectWarnning() {
        Map<String, Object> warnningMap = bizService.getSystemjson(Systemdef.APP_WARNNING);
        
        String key = (String) warnningMap.get("key");
        String url = (String) warnningMap.get("url");
        String content = (String) warnningMap.get("content");
        request.setAttribute("key", key);
        request.setAttribute("url", url);
        request.setAttribute("content", content);
        return layout("cms", "selectwarnning", "配置公告", "/cms/warnning.ftl", SystemConstant.LAYOUT_ADMIN);

    }

    /**
     * 修改配置公告
     * 
     * @return
     */
    @Action("modifywarnning")
    public String modifyWarnning() {

        String url = request.getParameter("url");
        String content = request.getParameter("content");
        String systemkey = Systemdef.APP_WARNNING;
        Map<String, Object> warnningMap = new HashMap<String, Object>();
        Date date = new Date();
        String key = StringUtil.convertDateToString(date, "yyyyMMddHHmmss");

        warnningMap.put("key", key);
        warnningMap.put("url", url);
        warnningMap.put("content", content);
        Systemdef def = new Systemdef();

        String systemValue = JSON.toJSONString(warnningMap);
        def.setK(systemkey);
        def.setV(systemValue);
        systemdefDao.update(def);

        return redirect("/admincms/selectwarnning.html");

    }

   
    

}

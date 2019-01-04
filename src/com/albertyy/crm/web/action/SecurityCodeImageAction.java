/**  
 
* @Title: SecurityCodeImageAction.java
 
* @Package com.albertyy.crm.web.action
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2019年1月4日 下午5:35:21
 
* @version V1.0  
 
*/

package com.albertyy.crm.web.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.albertyy.crm.utils.SecurityCode;
import com.albertyy.crm.utils.SecurityCode.SecurityCodeLevel;
import com.albertyy.crm.utils.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

/**  
*   
* 项目名称：CRM  
* 类名称：SecurityCodeImageAction  
* 类描述：  验证码
* 创建人：yangyangyang  
* 创建时间：2019年1月4日 下午5:35:21  
* 修改人：yangyangyang  
* 修改时间：2019年1月4日 下午5:35:21  
* 修改备注：  
* @version   
*   
*/

@SuppressWarnings("serial")
public class SecurityCodeImageAction extends ActionSupport implements SessionAware{
    
    //Struts2中Map类型的session
    private Map<String, Object> session;
    
    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    
    public String execute() throws Exception {
        //如果开启Hard模式，可以不区分大小写
        String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
        
        //获取默认难度和长度的验证码
        //String securityCode = SecurityCode.getSecurityCode();
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        //放入session中
        session.put("SESSION_SECURITY_CODE", securityCode);
        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}

/**  
 
* @Title: UploadUtils.java
 
* @Package com.albertyy.crm.utils
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月17日 下午4:43:52
 
* @version V1.0  
 
*/

package com.albertyy.crm.utils;

import java.util.UUID;

/**  
*   
* 项目名称：CRM  
* 类名称：UploadUtils  
* 类描述：  文件上传工具类
* 创建人：yangyangyang  
* 创建时间：2018年12月17日 下午4:43:52  
* 修改人：yangyangyang  
* 修改时间：2018年12月17日 下午4:43:52  
* 修改备注：  
* @version   
*   
*/

public class UploadUtils {
	//获得随机文件名，解决文件名重复问题
     public static String getUuidFileName(String fileName){
    	 int idx=fileName.lastIndexOf(".");
    	 String extions=fileName.substring(idx);
    	 return UUID.randomUUID().toString().replace("-", "")+extions;
     }
     //目录分离方法
     public static String getPath(String uuidFileName){
    	 int code1=uuidFileName.hashCode();
    	 int d1=code1&0xf;//作为一级目录
    	 int code2= code1 >>> 4;
    	 int d2=code2&0xf;//作为二级目录
    	 
    	 return "/"+d1+"/"+d2;
     }
     
     public static void main(String[] args) {
		System.out.println(getUuidFileName("322.txt"));
		System.out.println(getPath(getUuidFileName("322.txt")));
	}
}

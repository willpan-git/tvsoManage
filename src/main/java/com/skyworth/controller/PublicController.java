/**
 * 
 */
package com.skyworth.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.PublicService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: PublicController.java
 * @Description: 公共方法处理的控制层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月23日 下午3:12:07
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月23日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - PublicController",description = "公共方法API", protocols = "json", tags = "Public")
@RestController
@RequestMapping("/tvmanage/public")
public class PublicController {
    @Autowired
    private PublicService publicService;
    
    /**
     * 文件上传根目录(在Spring的application.yml的配置文件中配置):
     * web:
     * upload-path: （jar包所在目录）/resources/static/
     */
    @Value("${web.upload-path}")
    private String loadpath;

    // 下拉框数据源
    @ApiOperation(value = "查询下拉框数据", notes = "根据数据类型查询下拉框数据源")
    @ApiImplicitParam(name = "codeType", value = "参数类型", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/queryBaseType" }, method = RequestMethod.GET)
    public Result<?> queryBaseType(String codeType) {
	try {
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.SUCCESS;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),
		    publicService.queryBaseType(codeType));
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /**
     * 处理文件上传
     * @param file 上传的文件 
     * @return 传入的文件参数若为空，或者传入的文件名称为空时返回值为null,否则返回文件在数据库中存储的相对路径+文件名称
     *         返回值(存储的相对路径+文件名称)=当前年月+随机数
     *         文件存放的绝对路径+文件名称=项目路径+当前年月+随机数
     *         例如： 项目路径:/files/tvmanage/ 当前年月为 :201805 生成随机数为:7a932fe2-61a1-4fd8-ad56-385b289c9cd3
     *             返回值(存储的相对路径+文件名称)=201805/7a932fe2-61a1-4fd8-ad56-385b289c9cd3.jpg
     *             文件存放的绝对路径+文件名称=/file/tvmanage/201805/7a932fe2-61a1-4fd8-ad56-385b289c9cd3.jpg
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @ApiOperation(value = "上传附件功能", notes = "上传附件功能,返回文件存放路劲url")
    @PostMapping(value = { "/uploadFile" }, consumes = "multipart/*", headers = "content-type=multipart/form-data ")
    public Result<?> uploadFile(@ApiParam(value="上传的文件",required=true) @RequestParam("file") MultipartFile file) {
	if (file.isEmpty()) {
	    // 文件为空
	    throw new MyRuntimeException(ResultEnum.UnknownFileException);
	}
	if (file.getOriginalFilename() == null || file.getOriginalFilename().length()< 0) {
	    // 文件名或内容为空
	    throw new MyRuntimeException(ResultEnum.ErrorFileException);
	}	
	// 文件保存路径 (静态资源映射到该地址)
	DateFormat df = new SimpleDateFormat("yyyyMM"); 
        Calendar calendar = Calendar.getInstance();     
	String filePath = loadpath + File.separator + df.format(calendar.getTime()) + File.separator ;
	
	// 获得文件后缀
	String suf = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length - 1];
	// 保存时的文件名(随机数加后缀名)
        String filename = UUID.randomUUID()+"."+suf;
        
	File fileTemp = new File(filePath,filename);	
	// 检测是否存在目录
        if (!fileTemp.getParentFile().exists()) {
            fileTemp.getParentFile().mkdirs();
        }
	// 利用transferTo方法复制到指定目录
	try {
	    file.transferTo(fileTemp);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.UploadFailException);
	}
	// 上传成功
	// 打印日志
	LogUtil.printLog("上传成功!文件:" + file.getOriginalFilename());
	// 返回信息
	ResultEnum resultEnum = ResultEnum.UploadSuccess;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), df.format(calendar.getTime())+"/"+filename);
    }
}

package com.sxg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot 文件上传
 */
//@Controller
@RestController // 表示该类下的方法的返回值会自动做json格式的转换  相当于@Controller @ResponseBody 整合
public class FileUploadController {
    @RequestMapping("/fileUploadController")
    public Map<String,Object> fileUpload(MultipartFile filename) throws Exception{
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("/Users/sxg/ideaUpload"+filename.getOriginalFilename()));//保存哪里去
        Map map = new HashMap();
        map.put("msg","0");
        return map;
    }
}

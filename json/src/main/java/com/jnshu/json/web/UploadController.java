package com.jnshu.json.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UploadController {
    Logger logger= LoggerFactory.getLogger(UploadController.class);

    @RequestMapping("/uploadPage")
    public String uploadPage()throws Exception{
        return "uploadPage";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile file, Model model)throws Exception{
        try {
            //fileName=156767024685475863098_p0.png   原名=75863098_p0.png
            String fileName=System.currentTimeMillis()+file.getOriginalFilename();//获取文件原名
            //request.getServletContext().getRealPath("")=C:\Task9\jpa\src\main\webapp\  File.separator=\
            //定义servlet用于与其servlet容器通信的一组方法，例如，获取文件的MIME类型、分派请求或写入日志文件。//获取全路径
            String destFileName=request.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;
            logger.info(destFileName);

            //创建一个指定路径和名称的空文件
            File destFile=new File(destFileName);

            /*
             *  getParentFile()获取父目录名：C:/Task9/jpa/src/main/webapp/uploaded
             *  创建此抽象路径名命名的目录，包括任何必要但不存在的父目录。注意，如果这个操作失败，它可能成功地创建了一些必要的父目录。
             *  当所有必要的目录创建成功，才会返回true
             */
            destFile.getParentFile().mkdirs();
            //将接收到的文件传输到给定的目标文件。这可以移动文件系统中的文件，复制文件系统中的文件，或者将内存保存的内容保存到目标文件中。如果目标文件已经存在，它将首先被删除。
            file.transferTo(destFile);

            model.addAttribute("fileName",fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败"+e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败"+e.getMessage();
        }
        return "showImg";
    }

}

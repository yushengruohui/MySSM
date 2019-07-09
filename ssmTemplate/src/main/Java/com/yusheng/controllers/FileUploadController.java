package com.yusheng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public String fileDome(HttpServletRequest request, @RequestParam("uploadfile") MultipartFile multipartFile, Model model) {
        //相对路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/") + "uploadFile" + File.separator;
        System.out.println(uploadPath);
        //绝对路径
        //String uploadPath="D:\\IDEA\\workspace\\SSM2\\src\\main\\webapp\\uploadFile"+File.separator;
        //判断上传是否为空
        if (multipartFile != null && !multipartFile.isEmpty()) {
            //获取原始文件名
            String originalFileName = multipartFile.getOriginalFilename();

            //截取文件名前缀，不带后缀
            String prefixFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //截取文件名的后缀
            String subfixFileName = originalFileName.substring(originalFileName.lastIndexOf("."));

            //加工处理文件名，即原文件加上时间，以防止重复文件
            String newFileName = prefixFileName + new Date().getTime() + subfixFileName;

            //上传文件的路径
            String uploadFilePath = uploadPath + newFileName;

            //构建文件对象
            File file = new File(uploadFilePath);

            //上传
            try {
                multipartFile.transferTo(file);
                //把文件名
                model.addAttribute("newFileName", newFileName);
            } catch (IOException e) {
                System.out.println("上传失败");
                e.printStackTrace();
            }
        }

        return "page/jsp/dome2";

    }

    @RequestMapping("/uploads")
    public String fileDome2(HttpServletRequest request, @RequestParam("uploadfile") MultipartFile[] multipartFiles, Model model) {
        String newFileName=null;
        List<String> fileNames=new ArrayList<>();
        //相对路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/") + "uploadFile" + File.separator;
        System.out.println(uploadPath);
        //绝对路径
        //String uploadPath="D:\\IDEA\\workspace\\SSM2\\src\\main\\webapp\\uploadFile"+File.separator;

        //判断上传文件集合是否为空
        if (multipartFiles != null && multipartFiles.length > 0) {
            //遍历文件集合
            for (MultipartFile multipartFile : multipartFiles) {
                //判断文件是否为空
                if (multipartFile != null && !multipartFile.isEmpty()) {
                    //获取原始文件名
                    String originalFileName = multipartFile.getOriginalFilename();

                    //截取文件名前缀，不带后缀
                    String prefixFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));

                    //截取文件名的后缀
                    String subfixFileName = originalFileName.substring(originalFileName.lastIndexOf("."));

                    //加工处理文件名，即原文件加上时间，以防止重复文件
                    newFileName = prefixFileName + new Date().getTime() + subfixFileName;

                    //上传文件的路径
                    String uploadFilePath = uploadPath + newFileName;

                    //构建文件对象
                    File file = new File(uploadFilePath);

                    //上传
                    try {
                        multipartFile.transferTo(file);
                        //把文件名加入数组
                        fileNames.add(newFileName);

                    } catch (IOException e) {
                        System.out.println("上传失败");
                        e.printStackTrace();
                    }
                }
            }

            model.addAttribute("newFileName", newFileName);
        }
        return "page/jsp/dome3";
    }
}

package com.yusheng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/file")
public class FileDownloadController {
    private String downloadPath = null;
    private String downloadFileName = null;

    @RequestMapping("/download")
    public void fileDome(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        //相对路径,下载目录
        downloadPath = request.getSession().getServletContext().getRealPath("/") + "uploadFile" + File.separator;
        //绝对路径
        //downloadPath = "D:\\IDEA\\workspace\\SSM2\\src\\main\\webapp\\uploadFile" + File.separator;
        System.out.println(downloadPath);

        //获取需要下载的文件的文件名
//        String downloadFileName = "历史题目1562594608396.txt";
        downloadFileName = "test.txt";

        //构造一个文件对象(path)
        Path path = Paths.get(downloadPath, downloadFileName);

        //判断文件是否存在
        if (Files.exists(path)) {
            //存在则通过response给浏览器下载文件，但需要先设置响应类型（下载类型）
            String fileSuffix = downloadFileName.substring(downloadFileName.lastIndexOf(".") + 1);
            //System.out.println(fileSuffix);

            //设置ContentType，只有指定响应类型，才能下载
            response.setContentType("application/" + fileSuffix);

            //添加头信息
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(downloadFileName.getBytes("UTF-8"), "ISO8859-1"));

            //通过path对象写出去
            Files.copy(path, response.getOutputStream());
        }
    }
}

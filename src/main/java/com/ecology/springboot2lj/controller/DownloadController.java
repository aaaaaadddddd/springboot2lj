package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.utiles.ResponseCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class DownloadController {

    //文件上传路径(磁盘目录)
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @RequestMapping("/download")
    public String download(){
        return "download";
    }

    /**
     * 文件下载
     *
     * @return
     */
    @RequestMapping("/downloadFile")
    @ResponseBody
    public Object downLoadFile(HttpServletRequest request, HttpServletResponse response) {
        //文件名可以从request中获取, 这里为方便, 暂时写死
        String fileName = "1586791835381.zip";
        //String path = request.getServletContext().getRealPath("/");
        String path = uploadPath;
        File file = new File(path, fileName);
        if (file.exists()) {
            //设置强制下载打开
            //response.setContentType("application/force-download");
            //文件名乱码, 使用new String() 进行反编码
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            //读取文件
            BufferedInputStream bi = null;
            try {
                byte[] buffer = new byte[1024];
                bi = new BufferedInputStream(new FileInputStream(file));
                ServletOutputStream outputStream = response.getOutputStream();
                int i  = -1;
                while (-1 != (i = bi.read(buffer))) {
                    outputStream.write(buffer, 0, i);
                }
                return ResponseCode.success("下载成功");
            } catch (Exception e) {
                return ResponseCode.error("下载失败");
            } finally {
                if (bi != null) {
                    try {
                        bi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ResponseCode.error("文件不存在");
    }

}

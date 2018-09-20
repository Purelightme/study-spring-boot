package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/upload-form",method = RequestMethod.GET)
    public String uploadForm(Model model){
        return "upload";
    }

    @RequestMapping(value = "/do-upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam MultipartFile file){
        if (!file.isEmpty()) {
            String path = "/Users/purelightme/Desktop/boot";
            Path path1 = Paths.get(path + '/' + file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                Files.write(path1,bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "上传成功111";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    @ResponseBody
    @GetMapping(value = "/path")
    public String getPath(){
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        return path + "test";
    }
}

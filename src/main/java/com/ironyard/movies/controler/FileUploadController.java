package com.ironyard.movies.controler;
import com.ironyard.movies.StaticResourceConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Example taken from: https://github.com/spring-guides/gs-uploading-files.git
 */
@Controller
public class FileUploadController {



    @PostMapping("/file/add")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        try {
            // save the incoming file to our directory
            Files.copy(file.getInputStream(), Paths.get(StaticResourceConfiguration.IMG_DIRECTORY+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/files";
    }

    @GetMapping("/files")
    public String list(Model model, HttpServletRequest request) {

            // save the incoming file to our directory
            File[] files = new File(StaticResourceConfiguration.IMG_DIRECTORY).listFiles();

            ArrayList urls = new ArrayList();
            for(int i=0 ; i<files.length; i++){
                urls.add(getBaseUrl(request)+StaticResourceConfiguration.IMG_CONTEXT_PATH+files[i].getName());
            }
            model.addAttribute("files",urls);
        return "uploadForm";
    }

    public static String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme() + "://";
        String serverName = request.getServerName();
        String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        String contextPath = request.getContextPath();
        return scheme + serverName + serverPort + contextPath;
    }

}

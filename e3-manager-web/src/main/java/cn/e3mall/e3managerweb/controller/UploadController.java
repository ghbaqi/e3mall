package cn.e3mall.e3managerweb.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import cn.e3mall.e3managerweb.fastdfs.FastDFSClient;
import cn.e3mall.e3managerweb.fastdfs.FastDFSFile;

@Controller
public class UploadController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UploadController.class);


    /**
     * 文件上传
     */
    @PostMapping(value = "/pic/upload")
    @ResponseBody
    public Map upload(MultipartFile uploadFile) {
        HashMap<String, Object> map = new HashMap<>();
        if (uploadFile.isEmpty()) {
            map.put("error", 1);
            map.put("message", "请选择图片");
            return map;
        }
        try {
            // 上传成功
            String path = saveFile(uploadFile);
            map.put("error", 0);
            map.put("url", path);
            return map;
        } catch (IOException e) {
            map.put("error", 1);
            map.put("message", e.getMessage());
            e.printStackTrace();
            return map;
        }
    }


    /**
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        int len1 = inputStream.available();
        file_buff = new byte[len1];
        inputStream.read(file_buff);
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        return path;
    }
}

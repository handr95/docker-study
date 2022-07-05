package com.study.dockervolume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileController {

    @ResponseBody
    @PostMapping("/upload")
    public Boolean uploadSingle(@RequestBody UploadReq req) throws Exception {
        String filePath = System.getProperty("user.dir") + "/feedback/" + req.getFileNm() + ".txt";
        String tempFilePath = System.getProperty("user.dir") + "/temp/" + req.getFileNm() + ".txt";

        // 임시 폴더에 복사
        OutputStream tempOutput = new FileOutputStream(tempFilePath);
        byte[] by = req.getFileContent().getBytes();
        tempOutput.write(by);
        tempOutput.close();

        // feedback 폴더에 이미 데이터가 있다면 덮어쓰지 않음. 없다면 temp 폴더에서 덮어씀
        File file = new File(filePath);
        if (file.exists()) {
            return false;
        }

        Files.move(Paths.get(tempFilePath), Paths.get(filePath));

        return true;
    }

    @ResponseBody
    @GetMapping("/feedback/{fileName}")
    public String uploadSingle(@PathVariable("fileName") String fileName) {
        String filePath = System.getProperty("user.dir") + "/feedback/" + fileName;
        StringBuilder fileInfo = new StringBuilder();
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                fileInfo.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInfo.toString();
    }

    @GetMapping("/file")
    public String goFile() {
        return "fileUpload";
    }
}

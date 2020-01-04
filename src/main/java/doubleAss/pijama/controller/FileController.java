package doubleAss.pijama.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.ImmutableMap;

import doubleAss.pijama.service.StorageServcie;
import doubleAss.pijama.service.UploadResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 파일관련 컨트롤러
 *
 * @author 슷호브
 */
@Slf4j
@Controller
public class FileController {
    @Autowired
    private StorageServcie servcie;

    /**
     * Froala Editor 이미지 업로드
     */
    @PostMapping("/files")
    @ResponseBody
    public Map<String, String> imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

        try {
            UploadResult result = servcie.upload(file);

            log.debug("upload result : {}", result);

            // {"link" : "/image/201905/e98ff4f7-93a3-4aeb-813b-12f20a03db96.jpg"}
            return ImmutableMap.of(
                        "link",
                        String.format("%s/%s", request.getRequestURL(), result.getPath()));

        } catch (Exception ex) {
            ex.printStackTrace();

            return ImmutableMap.of("error", ex.getMessage());
        }
    }

    /**
     * 이미지 다운로드 (ex) /image/201905/e98ff4f7-93a3-4aeb-813b-12f20a03db96.jpg
     */
    @GetMapping("/files/{path}/{id}")
    public void image(HttpServletResponse response, @PathVariable String path, @PathVariable String id) {
        try {
            servcie.to(path, id, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
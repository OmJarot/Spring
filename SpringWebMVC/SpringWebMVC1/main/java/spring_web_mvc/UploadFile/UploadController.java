package spring_web_mvc.UploadFile;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class UploadController {

    @PostMapping(value = "/upload/file",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)//untuk upload file gunakan multipart_form_data_value
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            @RequestPart("file") MultipartFile file) throws IOException {//filenya akan di simpan di file menggunakan MulitpartFIle
        Path path = Path.of("upload/" + file.getOriginalFilename());
        //Files.write(path, file.getBytes()); memasukan filenye ke path manual
        file.transferTo(path);//otomatis memasukan filenya ke path
        return "Success save file "+name +" to "+ path;
    }

}

package doubleAss.pijama.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadResult {

    private String path;
    private String name;
    private Long size;
}
package dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class ModelClass {

        private String id;
        private String name;
        private String incantation;
        private String effect;
        private boolean canBeVerbal;
        private String type;
        private String light;
        private String creator;


}

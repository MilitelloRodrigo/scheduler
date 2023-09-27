package ar.com.bds.model;

import ar.com.bds.enums.Method;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Job")
public class JobBDs {

    @Id
    private String id;
    @Indexed(name = "name" , unique = true)
    private String name;
    private boolean enable;
    private String endpoint;
    private String cron;
    private Method method;
}

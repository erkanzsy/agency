package demo.slope.agency.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {
    @Id
    private String id;

    @Field(name = "from", type = FieldType.Text)
    private String from;

    @Field(name = "to", type = FieldType.Text)
    private String to;

    @Field(name = "date", type = FieldType.Date)
    private Date date;

    @Field(name = "amount", type = FieldType.Double)
    private double amount;
}

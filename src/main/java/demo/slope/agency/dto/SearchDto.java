package demo.slope.agency.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class SearchDto {
    @NotNull
    @Size(min = 3,max = 3)
    private String from;
    @NotNull
    @Size(min = 3, max = 3)
    private String to;
    private Date departureDate;
}

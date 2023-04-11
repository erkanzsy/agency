package demo.slope.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {
    @NotNull
    @Size(min = 3,max = 3)
    private String from;
    @NotNull
    @Size(min = 3, max = 3)
    private String to;
    private Date date;
    private double amount;
}

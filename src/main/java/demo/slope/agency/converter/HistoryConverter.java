package demo.slope.agency.converter;


import demo.slope.agency.dto.HistoryDto;
import demo.slope.agency.entity.History;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HistoryConverter {
    public HistoryDto convertEntityToDto(History history) {
        ModelMapper modelMapper = new ModelMapper();
        HistoryDto historyDTO = modelMapper.map(history, HistoryDto.class);
        return historyDTO;
    }

}

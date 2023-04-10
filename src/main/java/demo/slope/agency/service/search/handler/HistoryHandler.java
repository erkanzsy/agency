package demo.slope.agency.service.search.handler;

import demo.slope.agency.dto.ChainDto;
import demo.slope.agency.dto.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class HistoryHandler implements Handler {

    @Value(value = "${kafka.topic.history}")
    private String topic;

    protected KafkaTemplate<String, Object> template;

    public HistoryHandler(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    @Override
    public void handle(ChainDto chainDto) {
        List<FlightDto> flights = chainDto.getFlights();

        FlightDto flightDto = flights.stream().min(Comparator.comparingDouble(FlightDto::getAmount)).get();

        System.out.println("started");

        template.send(topic, flightDto);

        System.out.println("pushed");
    }
}

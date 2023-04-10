package demo.slope.agency;

import demo.slope.agency.repository.HistoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class AgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgencyApplication.class, args);
    }

}

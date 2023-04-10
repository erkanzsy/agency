package demo.slope.agency.repository;

import demo.slope.agency.entity.History;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoryRepository extends ElasticsearchRepository<History, String> {
    History findByFromAndToAndDate(String from, String to, Date date);
    List<History> findByFromAndToAndDateBetweenOrderByDateAsc(String fromC, String toC, Date from, Date to);
}

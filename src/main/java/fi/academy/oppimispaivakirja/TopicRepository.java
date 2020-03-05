package fi.academy.oppimispaivakirja;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
    @Query("SELECT h FROM Topic h WHERE h.id = :id")
    List<Topic> haeIdlla(@Param("id") Integer id);
}

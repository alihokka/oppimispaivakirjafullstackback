package fi.academy.oppimispaivakirja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    private TopicRepository topicRepo;

    @GetMapping("/api/{id}")
    public List<Topic> haeIdlla (@PathVariable(name="id") Integer id){
        return topicRepo.haeIdlla(id);
    }

    @GetMapping("/api/naytatopicit")
    private Iterable<Topic> naytaTopicit(){
        return topicRepo.findAll();
    }

    @PostMapping("/api/lisaatopic")
    private void lisaaTopic(@RequestBody Topic t){
        topicRepo.save(t);
    }

    @DeleteMapping("/api/poistatopic/{id}")
    public void poistaTopic(@PathVariable(name="id") Integer id){
        topicRepo.deleteById(id);
    }

    @PutMapping("/api/paivitatopic/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable(name = "id", required = true) int id) {
        Optional<Topic> top = topicRepo.findById(id);
        Topic c = top.orElseThrow(RuntimeException::new);
        c.setTitle(topic.getTitle());
        c.setDescription(topic.getDescription());
        c.setAdditionalSource(topic.getAdditionalSource());
        c.setComplete(topic.isComplete());
        c.setCreationDate(topic.getCreationDate());
        c.setCompletionDate(topic.getCompletionDate());
        topicRepo.save(c);
    }
}

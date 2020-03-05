package fi.academy.oppimispaivakirja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
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
}

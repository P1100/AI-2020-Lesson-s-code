package it.polito.ai.boot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

//@RestController
public class Home {

    //@Autowired
    private TimeStampService timesStampSerice;
    private List<String> data;

    @Autowired
    public Home(TimeStampService timeStampService, List<String> data) {
        this.timesStampSerice = timeStampService;
        this.data = data;
    }

    @GetMapping("/")
    public String home() {
        return "Home page generated at " + timesStampSerice.getTimestamp() + " " + data.stream().collect(Collectors.joining(" - "));
    }

}

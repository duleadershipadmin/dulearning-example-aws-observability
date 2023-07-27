package com.dulearning.observability.aws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RestController
public class Controller {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired CloudWatchService cloudWatchService;

    @GetMapping("/health")
    public Boolean health() {
        return true;
    }

    @PostMapping("/add")
    public Message addMessage(@RequestBody Message message) {
        var start = System.currentTimeMillis();
        var val = messageRepository.save(message);
        cloudWatchService.putMetricData("example-observabiilty", "duration", (System.currentTimeMillis() - start) / 1000.0, "add");
        return val;
    }

    @PutMapping("/update/{id}")
    public Message updateMessage(@PathVariable String id, @RequestBody  String message) throws InterruptedException {
        var start = System.currentTimeMillis();
        var m = messageRepository.findById(id).get();
        m.setText(message);
        var val = messageRepository.save(m);
        cloudWatchService.putMetricData("example-observabiilty", "duration", (System.currentTimeMillis() - start) / 1000.0, "update");
        return val;
    }
}

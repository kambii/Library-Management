package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Publisher;
import com.example.librarymanagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> getPublisher(){
        return publisherService.getPublishers();
    }

    @PostMapping
    public void registerNewPublisher(@RequestBody Publisher publisher){
        publisherService.addNewPublisher(publisher);
    }

    @DeleteMapping("{publisherId}")
    public void deletePublisher(@PathVariable("publisherId") Long publisherId){
        publisherService.deletePublisher(publisherId);
    }

    @PutMapping(path = "{publisherId}")
    public void updatePublisher(
            @PathVariable("publisherId") Long publisherId,
            @RequestParam(required = false) String publisherName){
        publisherService.updatePublisher(publisherId, publisherName);
    }

}

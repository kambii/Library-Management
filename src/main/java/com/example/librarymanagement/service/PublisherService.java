package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Publisher;
import com.example.librarymanagement.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getPublishers(){
        return publisherRepository.findAll();
    };

    public void addNewPublisher(Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherRepository.findPublisherByName(publisher.getPublisherName());
        if (publisherOptional.isPresent()){
            throw new IllegalStateException("publisherName taken");
        }
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long publisherId) {
        boolean exists = publisherRepository.existsById(publisherId);
        if (!exists){
            throw new IllegalStateException("publisher with id" + publisherId + "does not exists");
        }
        publisherRepository.deleteById(publisherId);
    }

    @Transactional
    public void updatePublisher(Long publisherId, String publisherName) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new IllegalStateException(
                        "publisher with id" + publisherId + "does not exist"));

        if (publisherName != null && publisherName.length() > 0 &&
                !Objects.equals(publisher.getPublisherName(), publisherName)){
            publisher.setPublisherName(publisherName);
        }
    }

}

package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/events") //root url
public class EventController {
    private List<Event> events=new ArrayList<>();

    @GetMapping
    public List<Event> getAllEvents(){
        return events;
    }
    @PostMapping
    public String addEvent(@RequestBody Event event){
        events.add(event);
        return "Event added suuceesfully..";
    }
    
    @GetMapping("/{id}")
    public Event getById(@PathVariable int id){
        
        return events.get(id);
        
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        events.remove(id);
    }
}

package com.harsh.springbootrestapi;

import com.harsh.springbootrestapi.Model.Aliens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlienController
{
    @Autowired
    AlienRepo repo;
    @GetMapping(path="/aliens",produces = {"application/json"})//get request taking json format only from the client
    public List<Aliens> getAllAliens()
    {
        List<Aliens> aliens=repo.findAll();
        return aliens;
    }
    @GetMapping("/alien/{aid}")
    public Aliens getAlien(@PathVariable("aid") int aid)//Use of Path variable to get the id from the url
    {
        return repo.findById(aid).orElse(new Aliens("",0));
    }
    @PostMapping(path="/alien", consumes={"application/json"})
    public Aliens addAlien(@RequestBody Aliens aliens )//Post Request to Add a particular Alien From the client
    {
        repo.save(aliens);
        return aliens;
    }
    @DeleteMapping("/alien/{aid}")
    public void deleteAlien(@PathVariable("aid") int aid)//Delete Request to Delete a particular Alien From the client
    {
        repo.deleteById(aid);
    }
}

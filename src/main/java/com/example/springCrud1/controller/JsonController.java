package com.example.springCrud1.controller;

import com.example.springCrud1.client.SoapRequestClient;
import com.example.springCrud1.model.JsonTable;
import com.example.springCrud1.model.Person;
import com.example.springCrud1.service.JsonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JsonController {

    public final JsonService jsonService;
    private final SoapRequestClient soapRequestClient;


    @Autowired
    public JsonController(JsonService jsonService, SoapRequestClient soapRequestClient){
        this.jsonService = jsonService;
        this.soapRequestClient = soapRequestClient;
    }


    @GetMapping("/jsons")
    public String findAll(Model model){
        List<JsonTable> jsonTables = jsonService.findAll();

        model.addAttribute("jsons", jsonTables);
        return "json-list";
    }


    @GetMapping("/json-create")
    public String createJsonForm(JsonTable jsonTable){

        return "json-create";
    }

    @PostMapping("/json-create")
    public String createJson(JsonTable jsonTable) throws JsonProcessingException {

        jsonService.savePerson(jsonTable);
        jsonService.saveJson(jsonTable);
        //тут должен быть вызов метода сервиса который преобразует json в xml и (для начала) просто сохраняет результат в бд
        jsonService.saveXML(jsonTable);
        return "redirect:/jsons";
    }


    @GetMapping("/json-delete/{id}")
    public String deleteJson(@PathVariable("id") Long id){

        jsonService.deleteById(id);
        return "redirect:/jsons";
    }

    @GetMapping("/json-update/{id}")
    public String updateJsonForm(@PathVariable("id") Long id, Model model){

        JsonTable jsonTable = jsonService.findById(id);
        model.addAttribute("json", jsonTable);


        String convertedXML = soapRequestClient.getConvertedXML(jsonTable.getXml_text());
        System.out.println(convertedXML);


        return "json-update";
    }

    @PostMapping("/json-update")
    public String updateJson(JsonTable jsonTable){
        jsonService.saveJson(jsonTable);
        return "redirect:/jsons";
    }

    @GetMapping("/persons")
    public String findAllPersons(Model model){
        List<Person> personList = jsonService.findAllpersons();

        model.addAttribute("persons", personList);
        return "person-list";
    }
}

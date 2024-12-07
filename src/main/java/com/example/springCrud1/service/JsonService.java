package com.example.springCrud1.service;

import com.example.springCrud1.model.JsonTable;
import com.example.springCrud1.model.Person;
import com.example.springCrud1.repository.JsonRepository;
import com.example.springCrud1.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class JsonService {

    private final JsonRepository jsonRepository;
    private final PersonRepository personRepository;

    @Autowired
    public JsonService(JsonRepository jsonRepository, PersonRepository personRepository){
        this.jsonRepository = jsonRepository;
        this.personRepository = personRepository;
    }


    public JsonTable findById(Long id){
        return jsonRepository.findById(id).orElse(null);
    }

    public List<JsonTable> findAll(){

        return jsonRepository.findAll();
    }

    public List<Person> findAllpersons(){
        return personRepository.findAll();
    }

    public JsonTable saveJson(JsonTable jsonTable){
        return jsonRepository.save(jsonTable);
    }

    public JsonTable saveXML(JsonTable jsonTable) throws JsonProcessingException {
        String text_json = jsonTable.getJson_text();

        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        Gson g = new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();
        Person person = g.fromJson(text_json, Person.class);

        String xmlText = xmlMapper.writeValueAsString(person);
        jsonTable.setXml_text(xmlText);

        return jsonRepository.save(jsonTable);
    }

    public Person savePerson(JsonTable jsonTable){
        String text_json = jsonTable.getJson_text();

        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        Gson g = new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();
        Person person = g.fromJson(text_json, Person.class);

        return personRepository.save(person);
    }

    public JsonTable saveXML_response(JsonTable jsonTable, String xml_string){
        jsonTable.setXml_response(xml_string);
        return jsonRepository.save(jsonTable);
    }


    public void deleteById(Long id){
        jsonRepository.deleteById(id);
    }

}

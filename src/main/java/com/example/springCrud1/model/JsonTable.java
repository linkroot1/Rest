package com.example.springCrud1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "json_list_table")
public class JsonTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "json_object")
//    @Convert(converter= JSONObjectConverter.class)
//    private JSONObject jsonObject;

    @Column(name = "json_text")
    private String json_text;


    @Column(name = "xml_text")
    private String xml_text;

//    @Column(name = "json_obj")
//    @Convert(converter= JSONObjectConverter.class)
//    private JSONObject jsonObject;
}
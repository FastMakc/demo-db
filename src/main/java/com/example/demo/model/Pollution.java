package com.example.demo.model;
<<<<<<< HEAD
=======

>>>>>>> origin/main
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "pollution")
public class Pollution {


    @Id
    private String id;
    private double co;
    private double no;
    private double no2;
    private double o3;
    private double so2;
    private double pm2_5;
    private double pm10;
    private double nh3;



}

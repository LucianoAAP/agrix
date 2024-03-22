package com.betrybe.agrix.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Farm.
 */
@Entity
@Table(name = "farm")
public class Farm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(length = 255)
  private String name;
  @Column
  private Double size;
  @OneToMany(mappedBy = "farm")
  @JsonIgnore
  private List<Crop> crops;
  
  public Farm() {
    
  }
  
  public Farm(String name, Double size) {
    this.name = name;
    this.size = size;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Double getSize() {
    return size;
  }
  
  public void setSize(Double size) {
    this.size = size;
  }
  
  public List<Crop> getCrops() {
    return crops;
  }
  
  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}

package com.betrybe.agrix.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Fertilizer.
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(length = 255)
  private String name;
  @Column(length = 255)
  private String brand;
  @Column(length = 255)
  private String composition;
  @ManyToMany
  @JoinTable(
          name = "crops_fertilizers",
          joinColumns = @JoinColumn(name = "fertilizer_id"),
          inverseJoinColumns = @JoinColumn(name = "crop_id")
  )
  private List<Crop> crops;
  
  public Fertilizer() {
    
  }
  
  /**
   * Constructor.
   */
  public Fertilizer(String name, String brand, String composition) {
    this.name = name;
    this.brand = brand;
    this.composition = composition;
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
  
  public String getBrand() {
    return brand;
  }
  
  public void setBrand(String brand) {
    this.brand = brand;
  }
  
  public String getComposition() {
    return composition;
  }
  
  public void setComposition(String composition) {
    this.composition = composition;
  }
  
  public List<Crop> getCrops() {
    return crops;
  }
  
  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}

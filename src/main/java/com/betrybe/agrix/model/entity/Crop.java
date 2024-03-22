package com.betrybe.agrix.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Crop.
 */
@Entity
@Table(name = "crop")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(length = 255)
  private String name;
  @Column(name = "planted_area")
  private Double plantedArea;
  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;
  @ManyToMany(mappedBy = "crops")
  @JsonIgnore
  private List<Fertilizer> fertilizers;
  @Column(name = "planted_date")
  @DateTimeFormat(pattern = "YYYY-MM-DD")
  private LocalDate plantedDate;
  @Column(name = "harvest_date")
  @DateTimeFormat(pattern = "YYYY-MM-DD")
  private LocalDate harvestDate;
  
  public Crop() {
    
  }
  
  /**
   * Constructor.
   */
  public Crop(String name, Double plantedArea, Farm farm,
      LocalDate plantedDate, LocalDate harvestDate) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
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
  
  public Double getPlantedArea() {
    return plantedArea;
  }
  
  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }
  
  public Farm getFarm() {
    return farm;
  }
  
  public void setFarm(Farm farm) {
    this.farm = farm;
  }
  
  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }
  
  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }
}

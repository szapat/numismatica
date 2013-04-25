/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author DAW
 */
public class Moneda {
    //definicion variables
    private String name; //nombre de referencia
    private String year; 
    private float value; //valor en su acuñacion
    private float coin;  //moneda nacional
    
    private float weight; //peso
    
    private String conservation; //grado de conservacion
    
    private String material; //materiales
    private float dimx;
    private float dimy;
    
    private int category;
    
    private String country;
    
    private float price; //precio mercado
    
    private String type; //legal, retirada, conmemorativa
    
    private String observations; //observaciones

    
    
    public Moneda(String name, String year, float value, float coin, float weight, String conservation, String material, float dimx, float dimy, int category, String country, float price, String observations) {
        this.name = name;
        this.year = year;
        this.value = value;
        this.coin = coin;
        this.weight = weight;
        this.conservation = conservation;
        this.material = material;
        this.dimx = dimx;
        this.dimy = dimy;
        this.category = category;
        this.country = country;
        this.price = price;
        this.observations = observations;
    }

    
    //get y set
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getCoin() {
        return coin;
    }

    public void setCoin(float coin) {
        this.coin = coin;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getConservation() {
        return conservation;
    }

    public void setConservation(String conservation) {
        this.conservation = conservation;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getDimx() {
        return dimx;
    }

    public void setDimx(float dimx) {
        this.dimx = dimx;
    }

    public float getDimy() {
        return dimy;
    }

    public void setDimy(float dimy) {
        this.dimy = dimy;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
    
    

 
 
    
    
    
    
    
}

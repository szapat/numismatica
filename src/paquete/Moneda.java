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
    private int id; //identificador unico
    private String name; //nombre de referencia
    private int year; 
    private float value; //valor en su acuñacion
    private float coin;  //moneda nacional
    
    private float weight; //peso
    
    private String conservation; //grado de conservacion
    
    private String material; //materiales
    private float dimx;
    private float dimy;
    
    private int category;
    private String variant;
    
    private int country;
    
    private float price; //precio mercado
    
    private String type; //legal, retirada, conmemorativa
    
    private String observations; //observaciones

    
    public Moneda(){
        
    }   
    
    public Moneda(int id, String name, int year, float value, float coin, float weight, String conservation, String material, float dimx, float dimy, int category, String variant, int country, float price, String type, String observations) {
        this.id = id;
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
        this.variant = variant;
        this.country = country;
        this.price = price;
        this.type = type;
        this.observations = observations;
    }

    
    //get y set
    
    public int getId() {
        return id;
    }

    public void setName(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
    
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
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

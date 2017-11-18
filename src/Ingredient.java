/** 
 * DO NOT EDIT OR HAND IN THIS CLASS
 */
public class Ingredient{
    /**
     * 1. Name of ingredient is not case sensitive and is always stored as lower case.
     * 2. Quantity is double.
     */
    private String name;
    private Double quantity;
    
    public Ingredient(String name, Double quantity){
        this.name = name.toLowerCase();
        this.quantity = quantity;
    }

    public void setName(String name){
        this.name = name.toLowerCase();
    }

    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public Double getQuantity(){
        return quantity;
    }
}

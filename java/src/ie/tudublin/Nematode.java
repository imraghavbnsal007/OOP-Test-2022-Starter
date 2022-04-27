package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode extends PApplet{
    public String name;
    public float length;
    public boolean limbs;
    public String gender;
    public boolean eyes;

    public Nematode(TableRow tr)
    {
        this(
            tr.getString("Name"),
            tr.getFloat("length"),
            tr.getInt("limbs?") == 1 ? true : false,
            tr.getString("gender"),
            tr.getInt("eyes?") == 1 ? true : false
        );
    }

    public Nematode(String name, float length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }
    

}

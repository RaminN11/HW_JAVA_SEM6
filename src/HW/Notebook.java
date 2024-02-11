package HW;

import java.util.*;

public class Notebook {

    String brand;
    int ram;
    int storage;
    String os;
    String color;

    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public boolean matchFilter(Map<String, Object> filter) {
        for (Map.Entry<String, Object> entry : filter.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();


            switch (key) {
                case ("ram"):
                    if (ram < (int) value) {
                        return false;
                    }
                    break;
                case ("storage"):
                    if (storage < (int) value) {
                        return false;
                    }
                    break;
                case ("os"):
                    if (!os.equals(value)) {
                        return false;
                    }
                    break;
                case ("color"):
                    if (!color.equals(value)) {
                        return false;
                    }
                    break;


            }
        }
        return true;
    }

    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

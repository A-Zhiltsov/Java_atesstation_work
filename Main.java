import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

import javax.print.DocFlavor.STRING;

public class Main {
 public static void main() {
    laptop lap_1 = new laptop("Первая модель", 1, 6, "Windows", "black", 16);

    laptop lap_2 = new laptop("Вторая модель",2,7,"Linux","brown",8);

    laptop lap_3 = new laptop("Третья модель",4,4,"Windows", "gray", 4);

    laptop lap_4 = new laptop("Четвертая модель",8, 6,"Linux","white",32);
    
    HashSet<laptop> laptop_set = new HashSet<>();
    laptop_set.add(lap_1);
    laptop_set.add(lap_2);
    laptop_set.add(lap_3);
    laptop_set.add(lap_4);

    HashSet<laptop> filtred_laptops = laptop.Filtr(laptop_set);
    
    for (laptop laptop : filtred_laptops) {
        laptop.print_info();
    }
 }
}

class laptop {
    private String model;
    private int RAM;
    private int memory;
    private String OS;
    private String color;
    private double mass;

    public laptop(String model, int RAM, int memory, String OS, String color, double mass){
        this.model = model;
        this.RAM = RAM;
        this.memory = memory;
        this.OS = OS;
        this.color = color;
        this.mass = mass;
    }

    public String getModel(){
        return model;
    }

    public int getMemory(){
        return memory;
    }

    public int getRAM(){
        return RAM;
    }

    public String getOS(){
        return OS;
    }

    public String getColor(){
        return color;
    }

    public double getMass(){
        return mass;
    }

    public void setModel(String model){
        this.model= model;
    }

    public void setMemory(int memo){
        this.memory = memo;
    }

    public void setRAM(int ram){
        this.RAM = ram;
    }

    public void setOS(String os){
        this.OS = os;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setMass(double mass){
        this.mass = mass;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) return false;

        laptop lap = (laptop) obj;

        return model.equals(lap.model) &&  memory == lap.memory && RAM == lap.RAM
        &&  OS == lap.OS &&  color.equals(lap.color) && mass == lap.mass;
    }

    @Override
    public int hashCode() {
        
        return Objects.hash(model,RAM,memory,OS,color,mass);
    }

    public static HashSet<laptop> Filtr(HashSet<laptop> list) {
        HashSet<laptop> result = new HashSet<>();
        
        Map<Integer, String> standarts = new HashMap<>();
        standarts.put(1, "ОЗУ");
        standarts.put(2, "Объем ЖД");
        standarts.put(3, "Операционная система");
        standarts.put(4, "Цвет");
        standarts.put(5, "Масса");

        System.out.println("Введите цифру, соответствующую выбранному критерию:");
        int i = 1;
        while (standarts.containsKey(i)){
            System.out.println(i+" - "+ standarts.get(i));
            i++;
        }

        Scanner in = new Scanner(System.in);
        int key = in.nextInt();
        
        switch (key) {
            case 1:
                System.out.println("Введите минимальное значение");
                int RAM_min_value = in.nextInt();
                for (laptop laptop : list) {
                    if(laptop.RAM >= RAM_min_value){
                        result.add(laptop);
                    }
                }
                break;
            case 2:
                System.out.println("Введите минимальное значение");
                int mem_min_value = in.nextInt();
                for (laptop laptop : list) {
                    if(laptop.memory >= mem_min_value){
                        result.add(laptop);
                    }
                }

                break;
            case 3:
                System.out.println("Введите желаемую операционную систему");
                String OS_value = in.next();
                for (laptop laptop : list) {
                    if(laptop.OS.equals(OS_value)){
                        result.add(laptop);
                    }
                }

            break;
            case 4:
                System.out.println("Введите минимальное значение");
                String color_value = in.next();
                for (laptop laptop : list) {
                    if(laptop.color.equals(color_value)){
                        result.add(laptop);
                    }
                }

            break;
            case 5:
                System.out.println("Введите минимальное значение");
                double mass_min_value = in.nextDouble();
                for (laptop laptop : list) {
                    if(laptop.mass >= mass_min_value){
                        result.add(laptop);
                    }
                }

            break;
            default:
                System.out.println("Такого критерия нет!");
                break;
        }
        in.close();
        return result;
    }


@Override
public String toString() {
    return "Модель - "+model+". ОЗУ - "+Integer.toString(RAM)+"ГБ. Объем ЖД - "+Integer.toString(memory)
        +"ГБ. Операционная система - "+OS+". Цвет - "+color+". Вес - "+Double.toString(mass)+" кг.";
}

    void print_info(){
        System.out.println("Модель - "+model+". ОЗУ - "+RAM+"ГБ. Объем ЖД - "+memory
        +"ГБ. Операционная система - "+OS+". Цвет - "+color+". Вес - "+mass+" кг.");
    }
 }
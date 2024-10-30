package lesson6.task3;

import java.util.ArrayList;
import java.util.List;

public class Park {
    public List<Attraction> attractionList = new ArrayList<>();

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void addAttraction(Attraction attraction) {
        attractionList.add(attraction);
    }

    public void deleteAttraction(Attraction attraction) {
        System.out.println();
        System.out.println("Аттракцион удален: " + attraction.name);
        attractionList.remove(attraction);
    }

    public void infoCountAttractions() {
        int count = attractionList.size();
        System.out.println();
        System.out.println("Всего аттракционов: " + count);
        System.out.println();
    }

    public void infoAttraction() {
        for (Attraction attraction : attractionList) {
            System.out.println(attraction);
        }
    }

    public static class Attraction {
        public String name;
        public int workingHours;
        public int price;

        public Attraction(String name, int workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Аттракцион: " + name + "," +
                    " Время работы аттракциона " + workingHours + " мин," +
                    " Цена аттракциона: " + price + " $";
        }
    }
}

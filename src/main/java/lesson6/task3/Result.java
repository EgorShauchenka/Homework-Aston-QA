package lesson6.task3;

public class Result {
    public static void main(String[] args) {
        Park park = new Park();

        Park.Attraction attraction1 = new Park.Attraction("Сюрприз", 4, 1);
        Park.Attraction attraction2 = new Park.Attraction("Вальс", 3, 3);
        Park.Attraction attraction3 = new Park.Attraction("Вихрь", 2, 2);

        park.addAttraction(attraction1);
        park.addAttraction(attraction2);
        park.addAttraction(attraction3);

        park.infoCountAttractions();
        park.infoAttraction();
        park.deleteAttraction(attraction1);
        park.infoCountAttractions();
        park.infoAttraction();
    }
}

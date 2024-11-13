package lesson10.task1;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void reductionFood(int amount) {
        if (getFood() >= amount) {
            food -= amount;
        }

    }

    public void infoFood() {
        System.out.println("Еды в миске осталось: " + food);
    }
}

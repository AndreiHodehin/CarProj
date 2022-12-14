package entity;

public class CarToUser {
    private User user;
    private Car car;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarToUser{" +
                "user=" + user +
                ", car=" + car +
                '}';
    }
}

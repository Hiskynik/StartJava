public class Wolf {
    private String nickname;
    private String gender;
    private String color;
    private int age;

    public String getNickname() {
        return nickname;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    public void walk() {
        System.out.println("walking");
    }

    public void sit() {
        System.out.println("sitting");
    }

    public void run() {
        System.out.println("running");
    }

    public void howl() {
        System.out.println("howling");
    }

    public void hunt() {
        System.out.println("hunting");
    }
}
public class Doctor {
    private int id;
    private String name;
    private Gender gender;
    // 1-10
    private int level = 1;
    private boolean isAvailable = false;

    private static Doctor doctor;

    private Doctor() {}

    public static synchronized Doctor createDoctor() {
        if (doctor == null)
            doctor = new Doctor(1, "Dr. FLora", Gender.FEMALE, 6);
        return doctor;
    }

    private Doctor(int id, String name, Gender gender, int level) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}

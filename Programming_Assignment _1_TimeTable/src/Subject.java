public class Subject {
    private String name;
    private String tutor;
    private String room;

    public Subject(String name, String tutor, String room) {
        this.name = name;
        this.tutor = tutor;
        this.room = room;
    }

    public Subject(String name) {
        this.name = name;
        this.tutor = "";
        this.room = "";
    }

    public Subject(Subject other) {
        this.name = other.name;
        this.tutor = other.tutor;
        this.room = other.room;
    }

    public String getName() { return name; }
    public String getTutor() { return tutor; }
    public String getRoom() { return room; }

    public void setTutor(String tutor) { this.tutor = tutor; }
    public void setRoom(String room) { this.room = room; }

    public boolean equals(Subject other) {
        return this.name.equals(other.name)
                && this.tutor.equals(other.tutor)
                && this.room.equals(other.room);
    }

    public String toString() {
        return name;
    }

    public String getDetails() {
        return "Name: " + name + "\nTutor: " + tutor + "\nRoom: " + room;
    }
}
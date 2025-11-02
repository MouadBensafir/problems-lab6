package LinkedListChallenge;

public class Place {
    private String name;
    private int distance;

    public Place(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() { return name; }
    public int getDistance() { return distance; }

    @Override
    public String toString() {
        return String.format("%s : %d km", name, distance);
    }

    // For checking duplicates by name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Place)) return false;
        Place other = (Place) obj;
        return this.name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
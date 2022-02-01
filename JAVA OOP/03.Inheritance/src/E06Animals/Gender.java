package E06Animals;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String asString;

    Gender(String asString) {
        this.asString = asString;
    }

    @Override
    public String toString() {
        return this.asString;
    }
}

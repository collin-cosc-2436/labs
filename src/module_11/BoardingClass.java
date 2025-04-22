package module_11;

public enum BoardingClass {

    FIRST_CLASS(3),
    BUSINESS_CLASS(2),
    ECONOMY_CLASS(1);

    private final int priority;

    BoardingClass(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

}

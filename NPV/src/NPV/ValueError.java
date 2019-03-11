package NPV;

public class ValueError extends Exception {

    private String errorMessage;

    public ValueError(String m) {
        this.errorMessage = m;
    }

    public String message() {
        return this.errorMessage;
    }
}

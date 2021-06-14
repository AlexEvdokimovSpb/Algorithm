public class Leader {

    private final String name;
    private final int ageLeader;
    private final int termOfAppointment;
    private final boolean zeroAble;

    public Leader(String name, int ageLeader, int termOfAppointment, boolean zeroAble) {
        this.name = name;
        this.ageLeader = ageLeader;
        this.termOfAppointment = termOfAppointment;
        this.zeroAble = zeroAble;
    }

    public String getName() {
        return name;
    }

    public int getAgeLeader() {
        return ageLeader;
    }

    public int getTermOfAppointment() {
        return termOfAppointment;
    }

    public boolean isZeroAble() {
        return zeroAble;
    }
}

package deep_dive.inherit.parent;

import java.util.List;

public class DoctorsDemo {

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Doctor surgeon = new Surgeon();
        Doctor generalPractitioner = new GeneralPractitioner();
        List<Doctor> doctors = List.of(doctor, surgeon, generalPractitioner);
        for (Doctor d : doctors) d.operation();
    }

}

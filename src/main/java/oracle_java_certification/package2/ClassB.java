package oracle_java_certification.package2;

import oracle_java_certification.package1.ClassC;

public class ClassB extends ClassC {

    public void print() {
        super.message = "World!";
        super.print();
    }

}

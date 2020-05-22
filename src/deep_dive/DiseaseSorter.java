package deep_dive;

import java.util.ArrayList;
import java.util.List;

public class DiseaseSorter {

    public static void main(String[] args) {
        Disease polio = new Disease("polio", false);
        Disease flu = new Disease("influenza", true);
        Disease malaria = new Disease("malaria", true);
        Disease cancer = new Disease("cancer", false);
        cancer.setCurable(true);
        List<Disease> diseases = new ArrayList<>();
        diseases.add(polio);
        diseases.add(flu);
        diseases.add(malaria);
        diseases.add(cancer);
        System.out.println("Curable diseases: ");
        diseases.stream().filter(Disease::isCurable).forEachOrdered(d -> System.out.println(d.getName()));
    }

}

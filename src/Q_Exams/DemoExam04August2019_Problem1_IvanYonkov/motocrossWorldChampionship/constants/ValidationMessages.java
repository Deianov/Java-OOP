package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.constants;

public class ValidationMessages {

    public class Motorcycle {

        public static final String MODEL_VALIDATION = "Model %s cannot be less than %d symbols.";

        public static final String HORSE_POWER_VALIDATION = "Invalid horse power: %d";

    }

    public class Race {

        public static final String NAME_VALIDATION = "Name %s cannot be less than %d symbols.";

        public static final String LAPS_VALIDATION = "Laps cannot be less than %d.";

        public static final String RIDER_ADD_TYPE_VALIDATION = "Rider cannot be null.";

        public static final String RIDER_ADD_PARTICIPATION_VALIDATION = "Rider %s could not participate in race.";

        public static final String RIDER_ADD_DUPLICATION_VALIDATION = "Rider %s is already added in %s race.";
    }

    public class Rider {

        public static final String NAME_VALIDATION = Race.NAME_VALIDATION;

        public static final String MOTORCYCLE_VALIDATION = "Motorcycle cannot be null.";

    }

    private ValidationMessages() {
    }

}

package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AcademicRank {
    PROFESSOR,
    ASSISTANT_PROFESSOR,
    ASSOCIATE_PROFESSOR;
    private static List<AcademicRank> ranks = new ArrayList<>(Arrays.asList(PROFESSOR, ASSISTANT_PROFESSOR, ASSOCIATE_PROFESSOR));
    public static AcademicRank getEnum(String nameRank) {
        for(AcademicRank rank : ranks) {
            if (nameRank.equals(rank.toString()))
                return rank;
        }
        return null;
    }
}

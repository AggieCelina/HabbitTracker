package com.ac.habbittracker.data;

import android.provider.BaseColumns;

/**
 * Created by marka1 on 7/21/17.
 */

public class TrackerContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private TrackerContract(){}

    public static final class RunEntry implements BaseColumns {

        public final static String TABLE_NAME = "runs";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DISTANCE ="distance";
        public final static String COLUMN_UNIT = "unit";
        public final static String COLUMN_PACE = "pace";

        public final static int UNIT_KM = 0;
        public final static int UNIT_MILES = 1;
    }

    public static final class FitnessEntry implements BaseColumns {

        public final static String TABLE_NAME = "fitness";
        public final static String _ID = BaseColumns._ID;
        public final static String TRAININIG_TYPE = "training_type";
        public final static String LENGTH = "length";

        public final static int TRAINING_HIIT = 0;
        public final static int TRAINING_PILATES = 1;
        public final static int TRAINING_YOGA = 2;
        public final static int TRAINING_CLIMBING = 3;
    }
}

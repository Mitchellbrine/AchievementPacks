package mc.Mitchellbrine.achevementPacks.util;

import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;

public class ErrorMessages {

    public static String compareError(Object object, Object object2) {
        String message = "Expected: " + object + " | Found: " + object2;
        AchievementPacksMain.logger.warn(message);
        return message;
    }

}

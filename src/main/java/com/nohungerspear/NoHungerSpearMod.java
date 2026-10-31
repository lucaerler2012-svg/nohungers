package com.nohungerspear;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Einstiegspunkt. Die ganze Logik steckt im PlayerMixin und in SpearHunger.
 */
public class NoHungerSpearMod implements ModInitializer {
    public static final String MOD_ID = "nohungerspear";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("No Hunger Spear geladen: Speer-Angriffe und Lunge kosten keinen Hunger.");
    }
}

package com.nohungerspear;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * Entscheidet, ob ein Hunger-Verbrauch (Exhaustion) unterdrückt wird.
 *
 * Regel: Der Spieler hält einen Speer in der Haupthand UND die Exhaustion sieht nach
 * Speer-Nutzung aus:
 *  - 0.1   = normaler Nahkampf-Angriff (Vanilla)
 *  - >= 4.0 = Lunge-Verzauberung (4.0 x Level: 4, 8, 12)
 *
 * Alles andere (Sprinten, Springen, Blöcke abbauen, Regeneration, Schwimmen ...)
 * bleibt Vanilla, auch wenn man einen Speer hält.
 *
 * TODO: Die Erkennung über den Betrag ist eine Näherung. Sauberer wäre, den Speer-Angriff
 *       selbst zu markieren, sobald die Zielmethode in 26.3 geprüft ist.
 */
public final class SpearHunger {
    private SpearHunger() {}

    // Einstellungen (TODO: später in eine Konfigurationsdatei auslagern)
    public static final boolean CANCEL_ATTACK_EXHAUSTION = true;
    public static final boolean CANCEL_LUNGE_EXHAUSTION = true;

    private static final float VANILLA_ATTACK_EXHAUSTION = 0.1f;
    private static final float LUNGE_MIN_EXHAUSTION = 4.0f;

    public static boolean shouldCancel(Player player, float exhaustion) {
        if (!isSpear(player.getMainHandItem())) {
            return false;
        }
        boolean isAttack = Math.abs(exhaustion - VANILLA_ATTACK_EXHAUSTION) < 0.0001f;
        boolean isLunge = exhaustion >= LUNGE_MIN_EXHAUSTION;
        return (CANCEL_ATTACK_EXHAUSTION && isAttack) || (CANCEL_LUNGE_EXHAUSTION && isLunge);
    }

    /**
     * Erkennt Speere am Item-Namen ("wooden_spear", "iron_spear", ... auch von anderen Mods).
     * Das vermeidet eine Abhängigkeit von Tag- oder Komponenten-Namen.
     */
    public static boolean isSpear(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        String path = BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
        return path.endsWith("_spear") || path.equals("spear");
    }
}

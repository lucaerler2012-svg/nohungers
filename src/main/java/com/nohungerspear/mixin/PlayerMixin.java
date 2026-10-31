package com.nohungerspear.mixin;

import com.nohungerspear.SpearHunger;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Jeder Hunger-Verbrauch des Spielers läuft über Player#causeFoodExhaustion(float).
 * Wir brechen die Methode am Anfang ab, wenn der Verbrauch vom Speer kommt.
 *
 * TODO: Prüfen, ob Lunge in 26.3 tatsächlich über diese Methode läuft. Falls Lunge den
 *       Hunger direkt über FoodData abzieht, bleibt nur der Lunge-Teil wirkungslos
 *       (Log/Test: Lunge benutzen und Hungerleiste beobachten).
 */
@Mixin(Player.class)
public abstract class PlayerMixin {

    @Inject(method = "causeFoodExhaustion", at = @At("HEAD"), cancellable = true)
    private void nohungerspear$skipSpearExhaustion(float exhaustion, CallbackInfo ci) {
        if (SpearHunger.shouldCancel((Player) (Object) this, exhaustion)) {
            ci.cancel();
        }
    }
}

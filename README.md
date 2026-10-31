# No Hunger Spear

Fabric-Mod für Minecraft **26.3**: Der Speer kostet keinen Hunger mehr, weder beim normalen Angriff noch beim Lunge-Ansturm.

## Funktionen

- Normale Speer-Angriffe verbrauchen keine Hungerleiste.
- Die Lunge-Verzauberung (Ansturm, Vanilla: 4 x Level Exhaustion) kostet keinen Hunger.
- Alles andere bleibt Vanilla: Sprinten, Springen, Regeneration usw. verbrauchen auch mit Speer in der Hand normal Hunger.
- Erkennt alle Speere am Item-Namen (`*_spear`), auch aus anderen Mods.

## Anforderungen

| | |
|---|---|
| Minecraft | 26.3 |
| Fabric Loader | 0.19.5 oder neuer |
| Fabric API | 0.165.0+26.3 oder neuer |
| Java | 25 |

## Installation

`nohungerspear-1.0.0.jar` (die Datei **ohne** `-sources`) und Fabric API in den `mods`-Ordner legen.

## Bauen

Siehe `GITHUB_ANLEITUNG.md`. Kurz: Dateien auf GitHub hochladen, die Action baut die JAR (Reiter *Actions* → Artifact `nohungerspear-jar`).

## Bekannte Einschränkungen

- Nicht gegen 26.3 kompiliert getestet.
- Die Erkennung "kommt vom Speer" arbeitet über den Betrag (0,1 = Angriff, ab 4,0 = Lunge) in `SpearHunger`. Sehr selten kann dadurch ein anderer Verbrauch mit Speer in der Hand mit erwischt werden, z. B. ein einzelner Schritt beim Sprinten mit genau 0,1.
- Lunge funktioniert in Vanilla nur mit mindestens 7 Hungerpunkten. Diese Bedingung bleibt unverändert, die Mod entfernt nur den Verbrauch.
- Zieht Lunge in 26.3 den Hunger nicht über `Player#causeFoodExhaustion` ab, bleibt der Lunge-Teil wirkungslos (der Angriffs-Teil geht trotzdem).

## TODO

- [ ] Lunge-Hunger in 26.3 gezielt verifizieren und ggf. direkt abfangen
- [ ] Konfigurationsdatei (Angriff / Lunge einzeln ein- und ausschalten; die Schalter existieren schon in `SpearHunger`)
- [ ] Mod-Icon ergänzen

## Lizenz

MIT

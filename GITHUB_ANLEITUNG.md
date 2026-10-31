# Von den Dateien zur fertigen JAR

1. Auf github.com ein neues Repository anlegen (z. B. `nohungerspear`).
2. Alle Dateien hochladen. Beim Drag & Drop geht der versteckte Ordner `.github` gern verloren. Dann so nachholen:
   **Add file → Create new file**, Dateiname `.github/workflows/build.yml` eintippen (die Schrägstriche erzeugen die Ordner) und den Inhalt der mitgelieferten `build.yml` einfügen.
3. Reiter **Actions**: Der Lauf "Build" startet automatisch.
4. Wenn er grün ist: Lauf anklicken, unten bei **Artifacts** `nohungerspear-jar` herunterladen. Darin liegt `nohungerspear-1.0.0.jar`.
5. Wird er rot: Fehlermeldung aus dem Schritt "Mod bauen" kopieren und mir schicken.

In `src/main/resources/fabric.mod.json` den Platzhalter `DEIN-NAME` in der Repository-URL ersetzen.

## Modrinth

- Loader: Fabric, Game version: 26.3
- Dependency: Fabric API (Required)
- Kurzbeschreibung: Der Speer verbraucht keinen Hunger mehr, weder beim Angriff noch bei Lunge.

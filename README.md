# Sopra Basisprojekt
- Code im Ordner `src`
- Tests im Ordner `test`
- Compilieren des Codes und Ausführen der Tests via `mvn test`
- Ausführen des Programms via `mvn exec:java`
- JavaDoc unter `target/site/apidocs` generieren via `mvn javadoc:javadoc`
- Konfiguration des Maven Projektes in der `pom.xml`
 - Setzen der Hauptklasse die die Main-Methode enthält unter `plugins` im `exec-maven-plugin`
 - Hinzufügen von weiteren Bibliotheken unter `dependencies`
- Konfiguration der Gitlab Continuous Integration in der `.gitlab-ci.yml`
- Ausführen der Tests im Docker container: `docker build -t sopra-mvn-test . && docker run -it sopra-mvn-test`

# Warm-up-Aufgabe
- Auschecken des initialen Commits via `git checkout init`
- Anlegen eines eigenen Branches via `git checkout -b warmup-<vorname>-<nachname>`
- Pushen des eigenen Branches via `git push -u origin`
- Implementieren und ständiges commiten + pushen
- Taggen der finalen Version via `git tag warmup-final-<vorname>-<nachname>`
- Pushen des Tags via `git push origin warmup-final-<vorname>-<nachname>`

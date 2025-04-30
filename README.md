# Gestor d'Artistes - Chinook DB

Aquest projecte consisteix en el desenvolupament d'una aplicació Java per gestionar dades de la base de dades **Chinook**, focalitzant-se en la taula d'artistes i àlbums. El programa permet consultar, afegir, modificar i esborrar artistes, així com veure els primers àlbums d'un artista concret.

## 🎯 Objectius

- Permetre la gestió bàsica de dades sobre artistes.
- Utilitzar bones pràctiques de programació amb Java.
- Fer consultes a una base de dades SQLite utilitzant JDBC.
- Controlar errors i validar dades d'entrada de l'usuari.

## 🛠️ Funcionalitats

### ✅ Menú Principal
Opcions disponibles:
1. Consultar tots els artistes  
2. Consultar artistes pel seu nom  
3. Consultar els 5 primers àlbums pel nom de l’artista  
4. Afegir un artista  
5. Modificar el nom d’un artista  
6. Borrar un artista  
7. Sortir del programa

---

### 🔠 Consultar artistes pel seu nom
- Sol·licita el nom a l'usuari.
- Si té menys de 2 caràcters, mostra:  
  `Has d'introduir almenys 2 caràcters`
- Si té 2 o més caràcters, mostra els artistes que continguin aquest text.

---

### 🎵 Consultar els 5 primers àlbums d’un artista
- Sol·licita el nom de l'artista.
- Si té menys de 2 caràcters, mostra:  
  `Has d'introduir almenys 2 caràcters`
- Si compleix, mostra el nom actualitzat.


---

### ➕ Afegir un artista
- Sol·licita el nom del nou artista.
- Si té menys de 2 caràcters, mostra:  
  `Has d'introduir almenys 2 caràcters`
- Si és vàlid, afegeix l'artista i mostra:  
  `L’artista s’ha afegit correctament`

---

### ✏️ Modificar el nom d’un artista
- Sol·licita la `ID` de l'artista a modificar.
- Sol·licita el nou nom.
- Si té menys de 2 caràcters, mostra:  
  `Has d'introduir almenys 2 caràcters`
- Si és vàlid, actualitza i mostra:  
  `L’artista s’ha modificat correctament`

---

### ❌ Esborrar un artista
- Sol·licita la `ID` de l'artista a esborrar.
- Si tot és correcte, mostra:  
  `L’artista s’ha esborrat correctament`

---

## 💾 Requisits

- Java 17 o superior
- Driver JDBC per **PostgreSQL** (`postgresql-42.x.x.jar`)
- IDE com Visual Studio Code

---

## 📚 Documentació

- El projecte està documentat amb **JavaDoc**.
- També s’inclouen comentaris per facilitar la comprensió del codi.

---

## ⚠️ Validacions i errors

- Validació de dades d'entrada (mínim 2 caràcters).
- Gestió d’errors per a consultes sense resultats:
  `No hi ha resultats per aquesta consulta`
- Control d'errors de connexió amb la base de dades.

---


## ✍️ Autor

Pràctica realitzada per **Rafel Dalmau** com a part del mòdul de **Programació** del cicle DAW.

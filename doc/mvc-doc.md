### MVC pattern
    * M - model
    * V - view
    * C - controller

V - widoki są serwowane przez kontroler
C - serwuje widoki/odbiera request'y
M - dane i operacje na nich

Model = Service + Repository

### Aplikacja webowa
View
Controller
Service
Repository

### Aplikacja standalone
Service
Repository

REST
* HTTP
* JSON
* CRUD na HTTP
    * hierarchiczne adresy
    * przedmioty w liczbie mnogiej
    * Read - GET --> \books - kolekcja
    * Read one - GET --> \books\{id} - przedmiot
    * Delete - DELETE --> \books\{id} - przedmiot
    * Create - POST --> \books - przedmiot
    * Update (replace) - PUT \books\{id} 
    * Update (partial) - PATCH \books\{id}

    * HATEOS --> REST Full
* Example API:
  * GET --> \items
  * GET --> \items\{id}
  * GET --> \items\categories\{id}
  
  * GET --> \categories
  * GET --> \categories\{id}
  * GET --> \categories\{id}\items

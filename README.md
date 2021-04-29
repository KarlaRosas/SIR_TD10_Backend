# Backend Kanban
## Prerequisites
### For Users
* JRE >= 1.8
* java IDE  (Eclispe,Intelliji Idea etc..)
*WAMPServer
*Phpmyadmin V5, Database server MySQL 

## Getting Started
1. https://github.com/KarlaRosas/SIR_TD10_Backend.git
2. Start WAMP server and database
3. persistence.xml file configuration:

 * Configurer path, username and password of the database
 * Verify that the 'create' parameter is enabled: property name="hibernate.hbm2ddl.auto" value="create"
  If the database is created, change the value to 'none' or 'update'


**How it works**

1. Run the JpaTest file
2. View the creation of the database
3. If the database is created, change the value to 'none' or 'update' in persistance.xml property name="hibernate.hbm2ddl.auto" value="none"
4. Run RestServer file
5. The api is available to be used http://localhost:8080/api/

**integration Backfront**
6. In the following link you will find the frontend project of the application https://github.com/KarlaRosas/TP10SirFrontEnd
7. Clone: https://github.com/KarlaRosas/TP10SirFrontEnd.git
8. Follow the frontend project instructions in the README.md 

 
## API REST 

## Tableau kanban:
+ [GET] ALL: http://localhost:8080/api/tableau/all
+ [GET] ID: http://localhost:8080/api/tableau/{id_tableu}
+ [GET] ByName: http://localhost:8080/api/tableau/name/{name_tableu}

+ [POST] http://localhost:8080/api/tableau/ajouter
+ [JSON POST] {"name": "Backend"}

+ [PUT] http://localhost:8080/api/tableau/editer
+ [JSON PUT] {"id": id_tableau, "name": "Nouveau_nom"}


## Section Kanban:
+ [GET]  ALL: http://localhost:8080/api/section/all
+ [GET]  ID: http://localhost:8080/api/section/{id_section}
+ [GET]  ByName: http://localhost:8080/api/section/name/{name_section}

+ [POST] http://localhost:8080/api/section/ajouter
+ [POST] http://localhost:8080/api/tableau/{id_tableau}/ajouter-section
+ [JSON POST] {"name": "section_name"}

+ [PUT] http://localhost:8080/api/section/editer
+ [JSON PUT] {"id": 1, "name": "New_name"}


## Fiche kanban:
+ [GET] ALL: http://localhost:8080/api/fiches/all
+ [GET] ID: http://localhost:8080/api/fiches/{id_fiche}
+ [GET] ByName : http://localhost:8080/api/fiches/namefiche/{name_fiche}

+ [POST] http://localhost:8080/api/fiches/ajouter
+ [POST JSON] { "name": "FicheName", "url": "kanban.com","lieu": "Rennes","tempsMinutes": 10}

+ [POST] http://localhost:8080/api/fiches/{id_fiche}/ajouter-tag
+ [JSON POST] {"name":"name_tag"}

+ [PUT]  http://localhost:8080/api/fiches/editer
+ [JSON PUT] {"id": id_fiche,"name": "NouveauNom","url": "kanban.com","lieu": "Rennes","tempsMinutes": 10}


## Tags kanban:
+ [GET] ALL: http://localhost:8080/api/tags/all
+ [GET] ID : http://localhost:8080/api/tags/{id_tag}
+ [GET] ByName : http://localhost:8080/api/tags/name/{name_tag}

+ [POST] http://localhost:8080/api/tags/ajouter
+ [JSON POST] {"name": "name_tag"}

+ [PUT ] http://localhost:8080/api/tags/editer
+ [JSON PUT] {"id": id_tag, "name": "Priority5"}


## Utilisateur kanban:
+ [GET] ALL: http://localhost:8080/api/utilisateur/all
+ [GET] ID : http://localhost:8080/api/utilisateur/{id_utilisateur}
+ [GET] ByName : http://localhost:8080/api/utilisateur/name/{name_utilisateur}

+ [POST] http://localhost:8080/api/utilisateur/ajouter
+ [JSON POST] { "name": "name"}

+ [PUT]  http://localhost:8080/api/utilisateur/editer
+ [JSON PUT] {"id": id_utilisateur, "name": "nouveu prenom"}

   
**Authors**

* Rabeaa KESSAL
* Karla ROSAS 
* Léo VARIERAS
* Oliver Barais
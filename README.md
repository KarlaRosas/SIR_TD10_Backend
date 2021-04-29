## JaxRS + openAPI

1. Import this project in your IDE, 
2. Start the database
3. Start the database viewer
4. Start the backend. There is a main class to start the backend


Restart your server and access to http://localhost:8080/api/, you should access to a swagger ui instance that provides documentation on your api. 

## API REST 

## Tableau kanban:
+ [GET] ALL: http://localhost:8080/tableau/all
+ [GET] ID: http://localhost:8080/tableau/{id_tableu}
+ [GET] ByName: http://localhost:8080/tableau/name/{name_tableu}

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
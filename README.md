# Enigma

est un Escape Game en ligne.

Il permet à un utilisateur joueur de s'inscrire et de s'authentifier.
Il pourra y retouver son score moyen ainsi que ses 5 meilleures performances
suite à sa connection.

Le but du jeu est de se déplacer par des clics (gauche, droit, arrière) 
de pièce en pièce en y trouvant le(s) indice(s) par pièce dans un laps de
temps.

Des textes d'information pourront vous aidez a trouver les indices des différentes pièces.  

Nous avons une base de données MySQL nommée Enigma avec ses tables Person, Pièce et Score.  

## Installation

<strong>Back-end :</strong>  
IDE IntelliJ                        (est un environnement de développement intégré de technologie Java)  
Java jdk 1.8                        (ensemble de bibliothèques logicielles de base du langage de programmation Java)  
Apache Maven 3.5.4                  (permet de compiler et de déployer des applications Java)  
MySQL Workbench 8.0                 (est un logiciel de gestion et d'administration de bases de données  

<strong>Front-end :</strong>  
Vue CLI 3                           (est un framework permettant de construire des applications web simples)  

## Usage  

<strong>Lancer la partie back-end :</strong>  
du terminal de l'IDE > cd Enigma/Backend  
du terminal de l'IDE > mvn package -Dmaven.test.skip=true   (maven compile votre projet Enigma en générant un fichier jar)  
du terminal de l'IDE > java -jar fichier.jar  (execute votre projet en mode console)   

<strong>Lancer la partie front-end :</strong>  
du terminal de l'IDE > cd Enigma/Front/enigma  
du terminal de l'IDE > npm install              (installe toutes les dependences imbriqué sur le package.json)  
du terminal de l'IDE > npm run serve            (lance votre projet localement)  
Navigateur >  http://localhost:8080/  

## Merci à  

Olivia  
Fadi  
Nico  
Dom  

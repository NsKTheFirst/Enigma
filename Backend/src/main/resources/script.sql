USE enigma;

CREATE TRIGGER insert_Uuid_Piece
BEFORE INSERT ON piece
FOR EACH  ROW 
BEGIN 
    SET NEW.id = UUID(); 
END;

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
1,
'Porte entrée',
' https://imgur.com/juwrHV3.png',
'J’y suis… Je ne réalise toujours pas que l’on me donne accès à la tristement célèbre maison d’Amityville pour un article.',
'',
'',
'',
'',
11);

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
2,
'Hall',
'https://imgur.com/48qourp.png',
'*Click*... tiens ? C’est comme si la porte s’était refermée derrière moi. J’ai un mauvais préssentiment. Je recherche la scène de crime et je file.',
'3',
'5',
'',
'',
16);

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar,clue, position)
VALUES (
3,
'Cuisine',
'https://imgur.com/wXUH39E.png',
'La cuisine est plutôt propre... étonnant.',
'2',
'4',
'',
'',
10);

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
4,
'Salon',
'https://imgur.com/qGF7Iuu.png',
'Le salon a été décoré avec goût.',
'3',
'5',
'',
'',
16);

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
5,
'Porte mystère',
'https://imgur.com/B9YEXdm.png',
'La pièce qui m\'intéresse le plus est derrière cette porte... forcément fermée par un cadenas sur lequel on peut lire "µ&$". Je peux surement trouver la bonne combinaison.',
'4',
'2',
'',
'',
17);

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
6,
'Indice hall',
'https://imgur.com/4biuS0W.png',
'C\'est avec ce téléphone que la mère a essayé de prévenir la police avant l\'inévitable. Oh, il est gravé quelque chose sur le combiné :',
'',
'',
'2',
'$ = 5',
null);

INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
7,
'Indice Cuisine',
'https://imgur.com/QSCpv3L.png',
'Ah, en y regardant de plus près, il y a comme des traces brune sombres dans l’évier. Quelqu\'un a trempé son doigt dans cette même couleur pour écrire :',
'',
'',
'3',
'& = $ -2',
null);


INSERT INTO piece (numPage, nom, imageUrl, text, left_ar, right_ar, back_ar, clue, position)
VALUES (
8,
'Indice Salon',
'https://imgur.com/mIY5ytf.png',
'Des notes en vrac… Rien n’a de sens, ces idées sembles bien provenir d’un esprit dérangé… Quelqu\'un a également griffonné :',
'',
'',
'4',
'µ =  2 + 4',
null);


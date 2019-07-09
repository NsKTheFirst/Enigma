USE 'enigma';

INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Porte entrée',
' https://imgur.com/juwrHV3',
'J’y suis… Je ne réalise toujours pas que l’on me donne accès à la tristement célèbre maison d’Amityville pour un article.',
'',
'',
'',
'',
11);

INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Hall',
'https://imgur.com/48qourp',
'*Click*... tiens ? C’est comme si la porte s’était refermée derrière moi. J’ai un mauvais préssentiment. Je recherche la scène de crime et je file.',
'3',
'5',
'',
'',
16);

INSERT INTO 'page' (nom, imageUrl, text, left, right, back,clue, position)
VALUES (
'Cuisine',
'https://imgur.com/wXUH39E',
'La cuisine est plutôt propre... étonnant.',
'2',
'4',
'',
'',
10);

INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Salon',
'https://imgur.com/qGF7Iuu',
'Le salon a été décoré avec goût.',
'3',
'5',
'',
'',
16);

INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Porte mystère',
'https://imgur.com/B9YEXdm',
'La pièce qui m\'intéresse le plus est derrière cette porte… forcément fermée par un cadenas sur lequel on peut lire “µ&$”. Je peux surement trouver trouver la bonne combinaison.',
'4',
'2',
'',
'',
17);

INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Indice hall',
'https://imgur.com/4biuS0W',
'C’est avec ce téléphone que la mère a essayé de prévenir la police avant l’inévitable. Oh, il est gravé quelque chose sur le combiné :',
'',
'',
'2',
'$ = 5',
'');

INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Indice Cuisine',
' https://imgur.com/QSCpv3L',
'Ah, en y regardant de plus près, il y a comme des traces brune sombres dans l’évier. Quelqu'un a trempé son doigt dans cette même couleur pour écrire :',
'',
'',
'3',
'& = $ -2',
'');


INSERT INTO 'page' (nom, imageUrl, text, left, right, back, clue, position)
VALUES (
'Indice Salon',
'https://imgur.com/mIY5ytf',
'Des notes en vrac… Rien n’a de sens, ces idées sembles bien provenir d’un esprit dérangé… Quelqu’un a également griffonné :',
'',
'',
'4',
'µ =  2 + 4',
'');


# UQBC1
Le client est l’Université du Québec à Baie-Comeau (UQBC) qui désire se doter d’un
système pour permettre aux chargés de cours et aux professeurs de saisir les notes des
travaux et examens, et de communiquer les résultats aux étudiants.
2) L’UQBC est une nouvelle université avec peu de ressources qui fait appel à vous les
étudiants pour l’aider avec ce projet. Elle a désigné un chargé de cours pour agir
comme Product Owner.
3) Une version plus complète avec des interfaces verra le jour mais pour l’instant l’UQBC
désire un petit logiciel fonctionnel, flexible et évolutif, qui lui permettra de mettre
quelque chose en place.
4) Le projet doit être livré en entier.
5) Le concept est de permettre aux enseignants de saisir les notes des étudiants, pour
chaque évaluation, dans un fichier texte en format JSON, unique à chaque évaluation,
très simple (étudiant, note, pondération de l’évaluation). À noter qu’un laboratoire sur
JSON aura lieu le 15 fév.
6) Chaque enseignant se verra remettre un gabarit de fichier à utiliser pour chaque
évaluation (le gabarit sera fourni par le PO par courriel à toutes les équipes). Chaque
enseignant reçoit aussi un fichier JSON avec les noms des étudiants et leur code
permanent (aussi fourni par le PO), afin d’utiliser cette information comme référence
dans le fichier de saisie.
7) À partir de ce fichier, le logiciel que vous développerez devra produire des fichiers de
sorties JSON, décrits ci-dessus. Les fichiers sont présentés dans l’ordre d’importance
pour l’UQBC.
a. Un fichier par étudiant avec les notes de toutes ses évaluations (le fichier peut
être produit et envoyé à tout moment et inclura les évaluations compilées à ce
jour).
i. Le fichier devra être versionné car chaque nouvelle évaluation, ou
modification, devra générer un nouveau fichier individuel d’étudiants,
avec leurs nouveaux résultats ajoutés ou modifiés.
ii. L’enseignant acheminera aux étudiants leur fichier de résultats, via un
courriel individuel.
iii. Ce fichier doit fournir à l’étudiant sa note à ce jour sur 100,
basée sur la pondération des évaluations.
iv. Le fichier doit aussi inclure la moyenne du groupe pour chaque
évaluation.

b. Un fichier pour l’enseignant contenant toutes les évaluations et tous les
étudiants, afin de lui donner une vue d’ensemble (le fichier peut être produit à
tout moment et inclura les évaluations compilées à ce jour).

Énoncé des exigences et grille de correction de la partie 1 – INF2015 Gr. 40 H2018

2

i. Ce fichier doit inclure la note à ce jour sur 100 pour chaque étudiant,
basée sur la pondération des évaluations. Il doit aussi inclure la
moyenne du groupe pour chaque évaluation.
ii. Le fichier devra être versionné car chaque nouvelle évaluation, ou
modification, devra générer un nouveau fichier.

c. Un fichier pour le registraire contenant la note finale de chaque étudiant, pour
la production des relevés de note. Le registraire générera des bulletins officiels.
Le code permanent est la clé pour permettre au registraire de distinguer chaque
étudiant.
i. Afin d’éviter les erreurs, ce fichier ne peut être généré que si toutes les
évaluations, totalisant une pondération de 100%, ont été compilées.
d. Un fichier pour l’enseignant présentant pour chaque évaluation (toutes dans le
même fichier), la moyenne, le mode, la médiane, l’écart type et le nombre
d’étudiants (le fichier peut être produit à tout moment et inclura les évaluations
compilées à ce jour).
i. Le fichier devra être versionné car chaque nouvelle évaluation, ou
modification, devra générer un nouveau fichier.

e. Un fichier pour l’enseignant présentant les dossiers des étudiants en échec,
donc n’ayant pas obtenu 60% de l’ensemble des évaluations compilées (le
fichier peut être produit à tout moment et inclura les évaluations compilées à ce
jour).

Plan des livraisons (Release Plan)
La partie 2 du travail de session correspond à la livraison #1 et doit inclure le point a ci-haut.
La partie 3 est la livraison #2 et doit inclure les points b et c.
La partie 4 est la livraison #3 et doit inclure les points d et e.
Les parties 2,3 et 4 ont aussi certaines particularités qui ont été présentées en classe dans
l’explication initiale, et qui seront précisées avant chaque partie.
Procédure pour formuler des questions au PO
Les questions au PO doivent être formulées par courriel et la réponse (ainsi que la question)
seront acheminées à toutes les équipes. Prévoir un délai de 24h-48h pour la réponse.
Outils
GitLab ou GitLub sont les 2 gestionnaires de sources permis pour la gestion du code source.
L’EDI est au choix des équipes.
La gestion du backlog peut se faire avec n’importe quel outil, incluant Excel, mais doit être
présentée (incluse) dans le rapport d’étape et non pointé vers un lien ou un autre fichier.

# TigerC

Ce project est un compilateur pour le langage `tiger`, développé dans le cadre de notre Projet de Compilation des Langages à TELECOM Nancy.

## Utilisation

Ce programme s'utilise grâce au script bash `./tigerc` à la racine du projet. Il s'utilise ainsi :

```text
Usage:
    tigerc <fichier> <tâche> [argument] [options...]

Tâches:
    --parse-tree            Génère une representation graphique de l'arbre suyntaxique du programme en entrée
    --ast <out-path>        Génère un fichier DOT représentant l'AST du programme en entrée
    --check-syntax          Vérifie la syntaxe du programme en entrée
    --check-semantics       Vérifie la sémantique du programme en entrée
    --symtab                Affiche la table des symboles du programme en entrée

Options:
    -h, --help              Montre ce message (en anglais)
    --color                 Active la sortie en couleur (activé par défaut)
    --no-color              Désactive la sortie en couleur
    --log-level=<value>     Met le niveau de trace de Gradle à une des options suivantes : quiet, warn, info, debug. Par défaut: quiet
```

## Tests

Les tests se trouvent dans le dossier `examples/tests`. Ils sont séparés en tests sémantiques et syntaxiques, chacun ayant des exemples passants et des exemples qui échouent.

Vous pouvez lancer tous les tests syntaxiques avec le script `TestingSyntaxic.sh`, et tous les tests sémantiques avec le script `TestingSemantic.sh`.

Des exemples de programmes complets se trouvent dans le dossier `examples/programs`.

Enfin, le programme `pandora.tig` est conçu pour échouer tous les tests sémantiques que nous avons implémentés.

# TigerC

Ce project est un compilateur pour le langage `tiger`, développé dans le cadre de notre Projet de Compilation des Langages à TELECOM Nancy.

## Utilisation

Ce programme s'utilise grâce au script bash `./tigerc` à la racine du projet. Il s'utilise ainsi :

```bash
Usage:
    tigerc <fichier> <tâche> [argument] [options...]

Tâches:
    --parse-tree            Génère une representation graphique de l'arbre suyntaxique du programme en entrée
    --ast <out-path>        Génère un fichier DOT représentant l'AST du programme en entrée
    --check-syntax          Vérifie la syntaxe du programme en entrée
    --check-semantics       Vérifie la sémantique du programme en entrée

Options:
    -h, --help              Montre ce message (en anglais)
    --color                 Active la sortie en couleur (activé par défaut)
    --no-color              Désactive la sortie en couleur
    --log-level=<value>     Met le niveau de trace de Gradle à une des options suivantes : quiet, warn, info, debug. Par défaut: quiet
```

Des programmes d'exemple peuvent être trouvés dans le dossier `examples`.

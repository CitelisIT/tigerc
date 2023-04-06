# TigerC

This project is a compiler for the `tiger` language, developed as part of our compilation project at TELECOM Nancy.

## Usage

This program is used with the bash script `./tigerc` found at the root of the project. It is used as follows :

```text
Usage:
    tigerc <file> <task> [argument] [options...]

Tasks:
    --parse-tree            Generates a representation of the input program's parse tree
    --ast <out-path>        Generates a DOT representation of the input program's AST
    --check-syntax          Check the syntax of the input program
    --check-semantics       Check the semantics of the input program
    --symtab                Dump the input program's symbol table
    --compile               Compile the input program
Options:
    -h, --help              Show this message
    --color                 Turns on colored output (default=true)
    --no-color              Turns off colored output
    --log-level=<value>     Sets gradle's log level to the specified value of (quiet, warn, info, debug). Default: quiet
```

Example programs can be found under the `examples` directory.

## Testing

Tests can be found under the `examples/tests` directory. They are separated into semantic and syntactic tests, both having passing and failing examples.

You can launch all the syntactic tests with the `TestingSyntaxic.sh` script, and all the semantic tests with the `TestingSemantic.sh` script.

Complete programs examples can be found under the `examples/programs` directory.

Finally, the `pandora.tig` program is designed to fail all the semantic tests we have implemented.

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

Options:
    -h, --help              Show this message
    --color                 Turns on colored output (default=true)
    --no-color              Turns off colored output
    --log-level=<value>     Sets gradle's log level to the specified value of (quiet, warn, info, debug). Default: quiet
```

Example programs can be found under the `examples` directory.

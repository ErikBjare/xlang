xlang
=======

Very simplistic programming language implemented in Java

## Syntax
On Backus-Naur Form:

    <stmt-sequence> ::= <stmt>  { ; <stmt>}
    <stmt> ::= <assign-stmt> | <output-stmt> | <if-stmt> | <while-stmt>
    <assign-stmt> ::= <var> = <expr>
    <output-stmt> ::= output <expr>
    <if-stmt> ::= if <expr> then <stmt-sequence> else <stmt-sequence> endif
    <while-stmt> ::= while <expr> do <stmt-sequence> done
    <expr> ::= <term> {<add-operator> <term>}
    <term> ::= <factor> {<mult-operator> <factor>}
    <factor> ::= (<expr>) | <cardinal> | <var>
    <add-operator> ::= + | ?
    <mult-operator> ::= * | /
    <cardinal> ::= <digit> {<digit>}
    <digit> ::= 0 | 1 | 2 | .... | 9
    <var> ::= <letter> {<letter> | <digit>}<letter> ::= a | b | ... | z | A | B | ... | Z


### Examples

Example of a program calculating the fibonacci sequence:

    a = 1;
    b = 0;
    i = 0;

    while (5-i) do
        a = b+a;
        b = a+b;
        output a;
        output b;
        i = i+1
    done;

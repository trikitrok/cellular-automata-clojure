#Cellular Automata kata.

##Description

Most of us have probably heard of Conway's Game of Life, but there are other cellular automata that are equally interesting. In fact, there is a group of 256 one-dimensional cellular automata that are quite easy to simulate but still fun to observe.

These CAs have a number of simple "rules" that define system behavior, like "If my neighbors are both active, I am inactive" and the like. The rules are all given numbers, but they're not sequential for historical reasons.

So to simulate these elementary cellular automata, you first need to construct a rule table. This table is a description of the changes that happen in each discreet step of time. 

For instance, this is the table for the **Rule 30 automaton**:

    +-----------------------------------------------------------------+
    | Neighborhood    | 111 | 110 | 101 | 100 | 011 | 010 | 001 | 000 |
    +-----------------------------------------------------------------+
    | New Center Cell |  0  |  0  |  0  |  1  |  1  |  1  |  1  |  0  |
    +-----------------------------------------------------------------+

and this is the one for the **Rule 90 automaton**:

    +-----------------------------------------------------------------+
    | Neighborhood    | 111 | 110 | 101 | 100 | 011 | 010 | 001 | 000 |
    +-----------------------------------------------------------------+
    | New Center Cell |  0  |  1  |  0  |  1  |  1  |  0  |  1  |  0  |
    +-----------------------------------------------------------------+
  
#Coding the CAs.

##1. CA evolution.

Given the rule, the **initial state as a list of 0s and 1s**, and **the number of evolution steps**, your program should return **a list with the states of the celular automata for the given steps (including the initial one)**. 

Example of calling the function:

    (evolve rule-90 [1 1 0 1 0 1 0] 5) => [[1 1 0 1 0 1 0]
                                           [1 1 0 0 0 0 1]
                                           [1 1 1 0 0 1 0]
                                           [1 0 1 1 1 0 1]
                                           [0 0 1 0 1 0 0]
                                           [0 1 0 0 0 1 0]]
                                           
##2. Rendering the CA evolution.

Given **a list with the states of the celular automata for the given steps (including the initial one)** substitute the 0 with " " and the 1s with "X" and place each state in a different line.

For example: 

    (render [[1 1 0 1 0 1 0]
             [1 1 0 0 0 0 1]
             [1 1 1 0 0 1 0]]) => "xx x x \nxx    x\nxxx  x \n"

If your program is ok, if you print the result of rendering the **Rule 90 automaton** evolution during 25 steps using the following input:

    00000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000
    
you should obtain this [Serpinski triangle](https://en.wikipedia.org/wiki/Sierpinski_triangle):

                                                     x
                                                    x x
                                                   x   x
                                                  x x x x
                                                 x       x
                                                x x     x x
                                               x   x   x   x
                                              x x x x x x x x
                                             x               x
                                            x x             x x
                                           x   x           x   x
                                          x x x x         x x x x
                                         x       x       x       x
                                        x x     x x     x x     x x
                                       x   x   x   x   x   x   x   x
                                      x x x x x x x x x x x x x x x x
                                     x                               x
                                    x x                             x x
                                   x   x                           x   x
                                  x x x x                         x x x x
                                 x       x                       x       x
                                x x     x x                     x x     x x
                               x   x   x   x                   x   x   x   x
                              x x x x x x x x                 x x x x x x x x
                             x               x               x               x
                            x x             x x             x x             x x
                    
  
If you print the result of rendering the **Rule 30 automaton** evolution during 20 steps using the following input:

    00000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000
    
you should see this other figure:

                                                     x
                                                    xxx
                                                   xx  x
                                                  xx xxxx
                                                 xx  x   x
                                                xx xxxx xxx
                                               xx  x    x  x
                                              xx xxxx  xxxxxx
                                             xx  x   xxx     x
                                            xx xxxx xx  x   xxx
                                           xx  x    x xxxx xx  x
                                          xx xxxx  xx x    x xxxx
                                         xx  x   xxx  xx  xx x   x
                                        xx xxxx xx  xxx xxx  xx xxx
                                       xx  x    x xxx   x  xxx  x  x
                                      xx xxxx  xx x  x xxxxx  xxxxxxx
                                     xx  x   xxx  xxxx x    xxx      x
                                    xx xxxx xx  xxx    xx  xx  x    xxx
                                   xx  x    x xxx  x  xx xxx xxxx  xx  x
                                  xx xxxx  xx x  xxxxxx  x   x   xxx xxxx

##Sources:
  1. [Challenge #213 [Easy] Cellular Automata: Rule 90](https://www.reddit.com/r/dailyprogrammer/comments/3jz8tt/20150907_challenge_213_easy_cellular_automata/)
  2. [Ruby Quiz Cellular Automata (#134)](http://rubyquiz.com/quiz134.html)

## How to run the tests

The project uses [Midje](https://github.com/marick/Midje/).

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

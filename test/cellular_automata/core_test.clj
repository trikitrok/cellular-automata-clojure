(ns cellular-automata.core-test
  (:require
    [midje.sweet :refer :all]
    [cellular-automata.core :as automata]
    [cellular-automata.rules :as rules]))

(facts
  "about cellular automata"

  (facts
    "about evolving an automaton"
    (automata/evolve
      rules/rule-90
      [1 1 0 1 0 1 0]
      5) => [[1 1 0 1 0 1 0]
             [1 1 0 0 0 0 1]
             [1 1 1 0 0 1 0]
             [1 0 1 1 1 0 1]
             [0 0 1 0 1 0 0]
             [0 1 0 0 0 1 0]])

  (facts
    "about rendering an automaton"
    (automata/render
      [[1 1 0 1 0 1 0]
       [1 1 0 0 0 0 1]
       [1 1 1 0 0 1 0]]) => "xx x x \nxx    x\nxxx  x "))

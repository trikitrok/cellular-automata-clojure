(ns cellular-automata.core-test
  (:require
    [midje.sweet :refer :all]
    [cellular-automata.core :as automata]
    [cellular-automata.rules :as rules]))

(facts
  "an elementary cellular automaton"

  (facts
    "evolves from an initial state for some time steps
    following a given rule"
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
    "can be rendered as text lines"
    (automata/render
      [[1 1 0 1 0 1 0]
       [1 1 0 0 0 0 1]
       [1 1 1 0 0 1 0]]) => "xx x x \nxx    x\nxxx  x "))

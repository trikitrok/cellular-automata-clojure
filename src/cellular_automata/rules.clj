(ns cellular-automata.rules)

(def rule-90
  {[1 1 1] 0
   [1 1 0] 1
   [1 0 1] 0
   [1 0 0] 1
   [0 1 1] 1
   [0 1 0] 0
   [0 0 1] 1
   [0 0 0] 0})

(def rule-30
  {[1 1 1] 0
   [1 1 0] 0
   [1 0 1] 0
   [1 0 0] 1
   [0 1 1] 1
   [0 1 0] 1
   [0 0 1] 1
   [0 0 0] 0})

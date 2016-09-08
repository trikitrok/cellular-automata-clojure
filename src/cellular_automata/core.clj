(ns cellular-automata.core
  (:require
    [clojure.string :as string]))

(def ^:private representations
  {0 " "
   1 "x"})

(defn- extract-neighborhoods [state]
  (partition 3 1 (repeat 0) (cons 0 state)))

(defn- evolve-once [rule state]
  (mapv rule (extract-neighborhoods state)))

(defn evolve [rule initial-state time-steps]
  (->> initial-state
       (iterate (partial evolve-once rule))
       (take (inc time-steps))))

(defn- render-state [line]
  (apply str (map representations line)))

(defn render [states]
  (->> states
       (map render-state)
       (string/join "\n")))

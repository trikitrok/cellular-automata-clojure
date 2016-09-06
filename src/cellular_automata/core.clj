(ns cellular-automata.core
  (:require
    [clojure.string :as string]))

(def ^:private representations
  {0 " "
   1 "x"})

(defn- extract-neighborhoods [state]
  (->> state
       (cons 0)
       (partition 3 1 (repeat 0))))

(defn- evolve-once [rule state]
  (->> state
       extract-neighborhoods
       (mapv rule)))

(defn evolve [rule initial-state time-steps]
  (->> initial-state
       (iterate (partial evolve-once rule))
       (take (inc time-steps))))

(defn- render-line [line]
  (apply str (map representations line)))

(defn render [states]
  (->> states
       (map render-line)
       (string/join "\n")))

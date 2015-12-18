(ns n3llyb0y.adventofcode.day2)

(defn extract-lines [s]
  (clojure.string/split s #"\n"))

(defn string->lwh-tupple [s]
  (map #(Integer/parseInt %) (clojure.string/split s #"x")))

(defn lwh-areas [[l w h]]
  [(* l w) (* w h) (* h l)])

(defn areas->square-ft [areas]
  (* 2 (apply + areas)))

(defn areas->padding [areas]
  (first (sort areas)))

(defn total-paper-required [input]
  (->> input
       extract-lines
       (map (comp lwh-areas string->lwh-tupple))
       (reduce (fn [acc areas]
                 (+ (areas->square-ft areas) (areas->padding areas) acc))
               0)))



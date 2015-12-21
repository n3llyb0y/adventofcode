(ns n3llyb0y.adventofcode.day5)

(defn vowelcount [s]
  (let [char-map (frequencies s)]
    (reduce #(+ %1 (get char-map %2 0))
            0
            [\a \e \i \o \u])))

(defn any-adjacent-char? [s]
  (some #(= (first %) (last %))
        (partition 2 1 s)))

(defn any-naughty-seq? [s]
  (let [naughty-seqs #".*(ab|cd|pq|xy).*"]
    (boolean (re-matches naughty-seqs s))))

(defn nice? [s]
  (and (> (vowelcount s) 2)
       (any-adjacent-char? s)
       (not (any-naughty-seq? s))))

(defn num-nice [strs]
  (let [nice-strs (filter true? (map nice? strs))]
    (count nice-strs)))

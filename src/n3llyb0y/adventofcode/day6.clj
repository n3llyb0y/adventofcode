(ns n3llyb0y.adventofcode.day6)

(defn lighting-grid [[x y]]
  (vec (repeat x (vec (repeat y 0)))))

(defn comma-string->int-tupple [s]
  (map #(Integer/parseInt %) (clojure.string/split s #",")))

(defn extract-co-ords [s]
  (let [matcher (re-matcher #"(\d+,\d+)" s) ;; matcher is mutable! run...away.
        from (comma-string->int-tupple ((re-find matcher) 0))
        to (comma-string->int-tupple ((re-find matcher) 0))]
    [from to]))

(defn operation [s]
  (cond
    (re-matches #".*on.*" s)
    (fn [_] 1)

    (re-matches #".*off.*" s)
    (fn [_] 0)

    (re-matches #".*toggle.*" s)
    (fn [i] (if (> i 0) 0 1))))

(defn process [grd instr]
  (let [[from to] (extract-co-ords instr)
        [x xs] [(first from) (first to)]
        [y ys] [(last from) (last to)]
        op (operation instr)
        ops (for [h (range x (+ 1 xs))
                  v (range y (+ 1 ys))]
              [[h v] op])]
    (loop [grd grd
           ops ops]
      (if (empty? ops)
        grd
        (recur (apply update-in grd (first ops)) (rest ops))))))

(defn count-on [grd]
  (reduce #(+ %1 (apply + %2)) 0 grd))

(defn process-all [instructions xy]
  (loop [grid (lighting-grid xy)
         instructions instructions]
    (if (empty? instructions)
      grid
      (recur (process grid (first instructions)) (rest instructions)))))

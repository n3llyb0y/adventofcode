(ns n3llyb0y.adventofcode.day3)

(defn visits [co-ordinates]
  (loop [moves (sequence co-ordinates)
         current-location {:x 0 :y 0}
         visits {current-location 1}]
    (if (empty? moves)
      visits
      (let [coord-op (case (first moves)
                       \^ {:y 1}
                       \v {:y -1}
                       \< {:x -1}
                       \> {:x 1}
                       :default (throw (IllegalArgumentException. "Ooops")))
            next-location (merge-with + current-location coord-op)
            visits (merge-with + visits {next-location 1})]
        (recur (rest moves) next-location visits)))))

(ns n3llyb0y.adventofcode.day1)

(defn calculate-floor [moves]
  (apply - (vals (frequencies moves))))

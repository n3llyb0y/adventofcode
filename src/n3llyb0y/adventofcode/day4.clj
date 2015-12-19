(ns n3llyb0y.adventofcode.day4
  (:require [digest]))

(defn mine [seed]
  (future
    (loop [i 0]
      (let [s (str seed i)
            hsh (digest/md5 s)]
        (if (re-matches #"^0{5}.*" hsh)
          i
          (recur (inc i)))))))

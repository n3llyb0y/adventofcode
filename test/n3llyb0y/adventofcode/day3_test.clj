(ns n3llyb0y.adventofcode.day3-test
  (:require [n3llyb0y.adventofcode.day3 :as sut]
            [clojure.test :as t]))

(t/deftest day3-spherical-houses-in-a-vacuum

  (t/testing "> delivers presents to 2 houses: one at the starting location, and one to the east"
    (let [co-ordinates ">"
          uniques (count (sut/visits co-ordinates))]
      (t/is (= 2 uniques))))

  (t/testing "^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location"
    (let [co-ordinates "^>v<"
          uniques (count (sut/visits co-ordinates))]
      (t/is (= 4 uniques))))

  (t/testing "^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses"
    (let [co-ordinates "^v^v^v^v^v"
          uniques (count (sut/visits co-ordinates))]
      (t/is (= 2 uniques)))

    (t/testing "It will work for a much larger set of co-ordinates"
      (let [co-ordinates (clojure.string/trim-newline
                          (slurp "test/n3llyb0y/adventofcode/fixtures/day3.txt"))
            uniques (count (sut/visits co-ordinates))]
        (t/is (= 2592 uniques))))))

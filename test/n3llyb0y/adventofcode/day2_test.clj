(ns n3llyb0y.adventofcode.day2-test
  (:require [n3llyb0y.adventofcode.day2 :as sut]
            [clojure.test :as t]))

(t/deftest day2-I-was-told-there-would-be-no-math

  (t/testing "It will calculate square footage plus padding"
    (let [dimensions "1x1x10\n2x3x4"
          total-feet (sut/total-paper-required dimensions)]
      (t/is (= 101 total-feet))))

  (t/testing "Given the required input it will produce the correct output"
    (let [dimensions (slurp "test/n3llyb0y/adventofcode/fixtures/day2.txt")
          total-feet (sut/total-paper-required dimensions)]
      (t/is (= 1588178 total-feet)))))

(ns n3llyb0y.adventofcode.day6-test
  (:require [n3llyb0y.adventofcode.day6 :as sut]
            [clojure.test :as t]))

(t/deftest day6-watch-that-leccy-bill
  (t/testing "It will create a grid of NxN initialised to 'off'"
    (let [lighting-dimension [10 10]
          lighting-grid (sut/lighting-grid lighting-dimension)]
      (t/is (= 10 (count lighting-grid)))
      (t/is (every? #(= 10 (count %1)) lighting-grid))
      (t/is (= 0 (reduce #(+ %1 (apply + %2)) 0 lighting-grid)))))

  (t/testing "It will extract co-ordinates"
    (let [co-ords "from 2,3 to 12,345"]
      (t/is (= [[2 3][12 345]] (sut/extract-co-ords co-ords)))))

  (t/testing "It will know the operation to perform"
    (let [on "turn on"
          off "turn off"
          toggle "toggle"]
      (t/is (= 1 ((sut/operation on) 'any)))
      (t/is (= 0 ((sut/operation off) 'any)))
      (t/is (= 1 ((sut/operation toggle) 0)))
      (t/is (= 0 ((sut/operation toggle) 1)))))

  (t/testing "It will turn lights on given the correct instructions"
    (let [lighting-grid [[0 0] [0 0]]
          instruction "turn on 0,0 through 1,1"
          light-arangement (sut/process lighting-grid instruction)]
      (t/is (= 4 (sut/count-on light-arangement)))))

  (t/testing "It will turn lights off given the correct instructions"
    (let [lighting-grid [[1 1] [1 1]]
          instruction "turn off 0,0 through 1,1"
          light-arangement (sut/process lighting-grid instruction)]
      (t/is (= 0 (sut/count-on light-arangement)))))

  (t/testing "It will toggle lights on given the correct instructions"
    (let [lighting-grid [[1 0] [0 0]]
          instruction "toggle 0,0 through 1,1"
          light-arangement (sut/process lighting-grid instruction)]
      (t/is (= 3 (sut/count-on light-arangement)))))

  (t/testing "It will process a sequence of instructions"
    (let [instructions (clojure.string/split
                        (slurp "test/n3llyb0y/adventofcode/fixtures/day6.txt") #"\n")
          xy [1000 1000]
          processed-grid (sut/process-all instructions xy)]
      (t/is (= 543903 (sut/count-on processed-grid))))))

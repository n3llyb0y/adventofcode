(ns n3llyb0y.adventofcode.day4-test
  (:require [n3llyb0y.adventofcode.day4 :as sut]
            [clojure.test :as t]))

(t/deftest day4-its-off-to-work-we-go
  (t/testing "If your secret key is abcdef, the answer is 609043,
             because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...),
             and it is the lowest such number to do so"
    (let [seed "abcdef"
          answer (sut/mine seed)]
      (t/is (= 609043 @answer))))

  (t/testing "If your secret key is pqrstuv, the lowest number it
             combines with to make an MD5 hash starting with five zeroes is 1048970;
             that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef"
    (let [seed "pqrstuv"
          answer (sut/mine seed)]
      (t/is (= 1048970 @answer)))))

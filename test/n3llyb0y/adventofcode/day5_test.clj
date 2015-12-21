(ns n3llyb0y.adventofcode.day5-test
  (:require [n3llyb0y.adventofcode.day5 :as sut]
            [clojure.test :as t]))

(t/deftest day5-where-are-the-interns?
  (t/testing "it counts vowels"
    (let [good-string "aeioouaeiouaeiou"
          bad-string "xcfghytpplk"]
      (t/is (= 16 (sut/vowelcount good-string)))
      (t/is (= 0 (sut/vowelcount bad-string)))))

  (t/testing "it will find adjacent chars"
    (let [with-adjacent "asldljkddwlekjrr"
          without-adjacent "qwertyuiop"]
      (t/is (sut/any-adjacent-char? with-adjacent))
      (t/is (not (sut/any-adjacent-char? without-adjacent)))))

  (t/testing "it will find naughty sequences"
    (let [naught-seqs ["blahab" "foocdfoo" "pqser" "ghfxydhs"]]
      (t/is (every? sut/any-naughty-seq? naught-seqs))))

  (t/testing "adventofcode input"
    (let [strings (slurp "test/n3llyb0y/adventofcode/fixtures/day5.txt")
          nice-strings (sut/num-nice (clojure.string/split strings #"\n"))]
      (t/is (= 236 nice-strings)))))

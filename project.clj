(defproject n3llyb0y.adventofcode "0.1.0-SNAPSHOT"
  :description "Thoughts about adventofcode.com puzzles "
  :url "http://adventofcode.cpm"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [digest "1.4.4"]]
  :main ^:skip-aot n3llyb0y.adventofcode
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

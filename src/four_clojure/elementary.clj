(ns four-clojure.elementary)

(def n (= true true))

(defn nt [] n)

(defn is-it-true [f] (f))

(defn simple-math [] (= (- 10 (* 2 3)) 4))

(defn capitalize [string] (.toUpperCase string))

(defn list-equality [] (= (list :a :b :c) '(:a :b :c)))

(defn get-5 [x] (conj '("Joe" 5) {:a 'b} true x))

(defn vector-equality [] (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))

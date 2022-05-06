(ns four-clojure.elementary)

(def n (= true true))

(defn nt [] n)

(defn is-it-true [f] (f))

(defn simple-math [] (= (- 10 (* 2 3)) 4))

(defn capitalize [string] (.toUpperCase string))

(defn list-equality [] (= (list :a :b :c) '(:a :b :c)))

(defn list-add [x] (conj '("Joe" 5) {:a 'b} true x))

(defn vector-equality [] (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))

(defn set-union [] (= #{:a :b :c} (clojure.set/union #{:a :b} #{:b :c})))

(defn set-add [] (= #{1 2 3 4 5} (conj #{1 4 3 5} 2)))

(defn map-get-key [] (:last {:first "John" :last "Saylor"}))

(defn one-two-three [] (conj {:a 1} {:b 2} {:c 3}))

(defn id [name] (map (fn [name] {:name name :id (rand-int 100000000)}) [name]))

(defn turtle-sequence [] (first (conj [:haire] :turtle)))

(defn sequences [] (= (first '(1 2 3)) (second [2 1 3]) (last (list 3 2 1))))

(defn the-rest [] (rest '(0 1 2 3)))

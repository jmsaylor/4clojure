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

(defn fiver [] (= 8 ((fn add-five [x] (+ x 5)) 3)))

(defn fiver-anon [] (= 8 ((fn [x] (+ x 5)) 3)))

(defn fiver-short [] (= 8 (#(+ % 5) 3)))

(defn fiver-partial [] (= 8 ((partial + 5) 3)))

(defn doubler [x] (* 2 ((partial + 1.5) x)))

(defn hello-world [x] (str "Hello" \space x))

(defn map-5 [x] (map #(* % 5) x))

(defn map-1 [x] (map #(+ % 1) x))

(defn big-map [x] (if (< (count x) 1000) (recur (conj (map-1 x) 3 2 1)) x))


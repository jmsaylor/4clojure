(ns four-clojure.easy)

(defn last-5-vec [] (= (last [1 2 3 4 5]) 5))

(defn last-of-list [] (#(first (rseq (vec %))) '(1 2 3 4 5)))

(defn penultimate-of-vec [] (#(get % (- (count %) 2)) [1 2 3 4 5]))

(defn penultimate-of-list [] (#(let [v (vec %)]
                                 (get v (- (count v) 2))) '(1 2 3 4 5)))

(def cars [{:name 'Porsche :year 1995} {:name 'Cadillac :year 1970} {:name 'Tesla :year 2021}])

(defn group-new [cars] (let [{new-cars 'true} (group-by #(< 2020 (:year %)) cars)] new-cars))

(defn get-cars [] cars)

(defn test-let [] (let [tester true] tester))

(def words ["the" "George" "filter" "oar" "Franklin" "zoo"])

(def odd-words
  (comp
   (filter (fn [x] (odd? (count x))))
   (map (fn [x] (.toUpperCase x)))))

(def simple
  (comp
   (map inc)
   (filter even?)))

;;eager
;;(into [] odd-words words)

;;lazy
;;(sequence odd-words words)

(def tax-calculation
  (comp
   (filter #(>= % 100))
   (map #(* 0.08 %))))

(def tax (transduce tax-calculation + 0 [99 100 101]))

(def the-sum (reduce + 0 [2 4 6]))

(def odd-comp (comp (filter odd?)))

(defn find-odds [coll] (transduce odd-comp conj [] coll))

(defn fib
  ([x]
   (if (= x 0) []
       (if (= x 1) [0]
           (fib (- x 2) [0 1]))))
  ([x coll]
   (if (< x 1)
     coll
     (let [[n1 n2] (take-last 2 coll)]
       (recur (dec x) (conj coll (+ n1 n2)))))))

(def nums (take-last 2 [1 2 3]))

(defn test-take [] (let [[x y] (take-last 2 [1 2 3])] (+ x y)))


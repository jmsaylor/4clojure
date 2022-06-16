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

(defn rev [coll] (into '() coll))

(defn is-palindrome [thing] (= (seq thing) (into '() thing)))

(defn f1 [n] [(- n 1) n (+ n 1)])

(defn mad-catter [coll] (mapcat f1 coll))

(defn mad-mapper [coll] (map f1 coll))

(defn flat [coll]
  (if (not (coll? coll))
    (list coll)
    (mapcat flat coll)))

(defn flat-a [coll]
  ;;(println coll)
  (if (not (coll? coll))
    (do (println (str "true:  " coll))
        (list coll))
    (do (println (str "false: " coll))
        (mapcat flat-a coll))))

(defn grab-capitals [s] (reduce str (re-seq #"[A-Z]" s)))

(defn compress [i] (reduce #(if (not= %2 (last %1)) (conj %1 %2) %1) [] i))

(defn compress-f [i] (reduce (fn [a b] (if (not= b (last a)) (conj a b) a)) [] i))

(defn compress-m [i] (map last (partition-by str i)))

(defn pack [x] (partition-by identity x))

(defn duplicate-r [s] (reduce (fn [acc next] (conj acc next next)) [] s))

(defn duplicate-i [s] (interleave s s))

(defn duplicate-m [s] (mapcat (fn [r] (repeat 2 r)) s))

(defn s-duplicate [s] (flat (list s s)))

(defn s-duplicate-r [s] (reduce (fn [acc next] (conj acc next)) s s))

(defn interpose-m [c i]
  (let [r (reduce (fn [acc next] (conj acc next c)) [] i)]
    (butlast r)))

(defn interpose-m-alt [c i] (butlast (reduce #(conj %1 %2 c) [] i)))

(defn max-value [& i] (reduce (fn [acc next] (if (> acc next) acc next)) i))

(defn max-value-rec
  ([i] (max-value-rec (first i) (rest i)))
  ([m i] (if (empty? i)
            m
            (let [m-local (max m (first i))]
              (recur m-local (rest i))))))

(def test-arch 'arch)

(defn range-m
  ([x y] (range-m (list y) x y))
  ([l x y]
   (let [f (first l)]
   (if (<= f x)
     l
     (recur (conj l (- f 1)) x y)))))

(defn range-o [x y] (if (= x y) nil (cons x (range-o (+ x 1) y))))

(defn k-index [c] (keep-indexed (fn [index value] (conj (list value) index)) c))
   
(defn fact [i] (reduce (fn [acc next] (* acc next)) 1 (range 2 (inc i))))

(defn fact-r [i] (* i (if (> i 1) (fact-r (dec i)) 1)))

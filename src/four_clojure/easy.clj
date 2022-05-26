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


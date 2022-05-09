(ns four-clojure.easy)

(defn last-5-vec [] (= (last [1 2 3 4 5]) 5))

(defn last-of-list [] (#(first (rseq (vec %))) '(1 2 3 4 5)))

(defn penultimate-of-vec [] (#(get % (- (count %) 2)) [1 2 3 4 5]))

(defn penultimate-of-list [] (#(let [v (vec %)]
                                (get v (- (count v) 2))) '(1 2 3 4 5)))



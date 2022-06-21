(ns  four-clojure.medium)

(def test-n 'test)

(defn reverse-interleave [coll n]
  (reduce
   (fn [acc [index value]] (let [group (mod index n)]
     (assoc acc group (conj (get acc group) value))))
   (vec (repeat n []))
   (keep-indexed (fn [index value] [index value]) coll)))

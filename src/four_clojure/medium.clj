(ns  four-clojure.medium)

(def test-n 'test)

(defn rev-c [coll n]
  (reduce
   (fn [acc [index value]] (let [group (mod index n)]
     (assoc acc group (cons value (get acc group)))))
   (vec (repeat n []))
   (keep-indexed (fn [index value] [(inc index) value]) coll)))

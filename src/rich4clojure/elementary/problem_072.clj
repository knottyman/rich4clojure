(ns rich4clojure.elementary.problem-072
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Rearranging Code: ->> =
;; By 4Clojure user: amalloy
;; Difficulty: Elementary
;; 
;; The ->> macro threads an expression x through a
;; variable number of forms. First, x is inserted as the
;; last item in the first form, making a list of it if it
;; is not a list already. Then the first form is inserted
;; as the last item in the second form, making a list of
;; that form if necessary. This process continues for all
;; the forms. Using ->> can sometimes make your code more
;; readable.

(def __ )

(comment
  (map inc (take 3 (drop 2 [2 5 4 1 3 6])))
  ;; => (5 2 4)

  (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
  ;; => 11 
  ;; this works but I don't think it is the correct answer

  (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc))
  ;; => (5 2 4)

  (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
  ;; => 11
  ;; again this works, but not sure if it it the expected wayto do this

  ;; I took a peek at some solutions and turns out this is the wqay that others are doing this.

  )

(tests
  (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6])))) :=
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
   11)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/7c7f22cab82de9fbeb08aa518efca3ec
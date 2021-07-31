(ns rich4clojure.elementary.problem-071
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Rearranging Code: -> =
;; By 4Clojure user: amalloy
;; Difficulty: Elementary
;; 
;; The -> macro threads an expression x through a variable
;; number of forms. First, x is inserted as the second
;; item in the first form, making a list of it if it is
;; not a list already. Then the first form is inserted as
;; the second item in the second form, making a list of
;; that form if necessary. This process continues for all
;; the forms. Using -> can sometimes make your code more
;; readable.

(def __ last)

(comment
  (sort (rest (reverse [2 5 4 1 3 6])))
  ;; => (1 2 3 4 5)

  (last (sort (rest (reverse [2 5 4 1 3 6]))))
  ;; => 5

  (-> [2 5 4 1 3 6] (reverse) (rest) (sort))
  ;; => (1 2 3 4 5)

  (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
  ;; => 5

  (-> [2 5 4 1 3 6] )
  ;; => [2 5 4 1 3 6]

  (-> [2 5 4 1 3 6] (reverse))
  ;; => (6 3 1 4 5 2)

      (-> [2 5 4 1 3 6] (reverse) (rest))
      ;; => (3 1 4 5 2)

      (-> [2 5 4 1 3 6] (reverse) (rest) (sort))
      ;; => (1 2 3 4 5)

      (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
      ;; => 5

  )


(tests
  (__ (sort (rest (reverse [2 5 4 1 3 6])))) :=
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
   5)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/1c3da359cc636512f717ff01c4ef2388
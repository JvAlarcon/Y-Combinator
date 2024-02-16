(ns y-combinator.core)

; A "functional" is just a function that takes another function as input.
; The Y combinator finds the fixed point of the "functional" passed in as an argument
; It needs to satisfy the property: Y(F) = F(Y(F))
; Below the definition of the Y Combinator
(def Y (fn [f] 
         (fn [x] f(fn [y] 
                    (x(x))(y)))
         (fn [x] f(fn [y] 
                    (x(x))(y)))))
; Note that the Y does not reference itself
(Y (println "hello"))

; Let's make a factorial
(def y-fact
  "Factorial with two parameters"
  (fn [fact, n]
      (case n
        0 1
        (* n (fact fact (- n 1))))))

(println (y-fact y-fact 5)) ; Works fine
(println (y-fact y-fact 100)) ; Error - long overflow
(println (y-fact y-fact 20)) ; Works fine

; Let's make a Fibonacci
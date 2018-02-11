(ns clj-try.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(-main)

(if false
  (do (println "Succcess")
      "By zeus hammer")
  (do (println "failure!")
      "Bu Aqia,ams trident"))

;when always return nil
; nil -no value
(when true
  (println "Success!")
  "abra cadabra")

; nil check
(nil? 1)
(nil? nil)


(if "bears eats beets"
  "bears beets Battlestar Galactica")

(if nil
  "This is won't be result beacuse nil is falsey"
  "nil is falsey")

; compare operators
(= 1 1)

;'or' and 'and'
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)

(and :free_wifi :hot_coffee)

(and :feelin_super_cool nil false)

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

(defn error-messsage
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE"
       (if (= severity :mild)
         "MILDLY INCONVENCIENED!"
         "DOOMED!")))

(error-messsage :miled)

; //////////////////MAPS//////////////////////////////

(hash-map :a 1 :b 2)

(get {:a 0 :b 1} :b)

(get {:a 0 :b {:c "ho hum"}} :b)

(get {:a 0 :b 1} :c "unicorns?")

(get-in {:a 0 :b {:c "No hum"}} [:b :c])

; like a function
({:name "The Human Coffeport"} :name)

(:a {:a 1 :b 2 :c 3})

(:d {:a 1 :b 2 :c 3} "No such value")

;//////////////////////VECTORS/////////////////////////

(get [3 2 1] 0)

(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

(vector "creepy" "full" "moon")

(conj [1 2 3] 4)

;///////////////////////LIST////////////////////////////
`(1 2 3 4)

(nth `(:a :b :c) 0)

(list 1 "two" {3 4})

(conj '(1 2 3) 4)

;/////////////////////////////SETS///////////////////////////
#{"kurt vonnegut" 20 :icicle}

(hash-set 1 1 2 2)

(conj #{:a :b} :b)

(set [3 3 3 4 4])

(contains? #{:a :b } :a)

(:a #{:a :b})

(get #{:a :b} :a)

;/////////////////////////////Functions//////////////////////////
(or + -)


(defn x-chop
  "Describe fnc"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West" "slap")

; (defn x-chop
;   "Describe the kind of chop you're inflicting on someone"
;   ([name chop-type]
;    (str "I " chop-type " chop " name "! Take that!"))
;   ([name]
;    (x-chop name "karate")))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")

;//// desctructuring
(defn my-first
  [[first-thing]]
  first-thing)

(my-first ["oven", "bike", "war-axe"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                (clojure.string/join ", " unimportant-choices))))


(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts]
        final-body-parts []
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
              (into final-body-parts
                    (set [part (matching-part part)])))))))
                    

(symmetrize-body-parts asym-hobbit-body-parts)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(let [[pongo & dalmatians] dalmatian-list]
    [pongo dalmatians])

;;; 4 times of fnctions
((fn add-five [x] (+ x 5)) 3)
((fn [x] (+ x 5)) 3)
(#(+ % 5) 3)
((partial + 5) 3)




























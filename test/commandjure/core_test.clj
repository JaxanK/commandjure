(ns commandjure.core-test
  (:require [clojure.test :refer :all]
            [commandjure.core :refer :all]))

;Can run these by calling lein test

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))


(deftest a-test2
  (testing "I succeed"
    (is (= 1 1))))
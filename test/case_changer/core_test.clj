(ns case-changer.core-test
  (:require [clojure.test :refer :all]
            [case-changer.core :refer :all]))


(deftest test-say-hi
  (are [exp name] (= exp (say-hi name))
    nil "dogman"
    "Hi, tracy!" "tracy"
    "Hi, brah!" nil))
